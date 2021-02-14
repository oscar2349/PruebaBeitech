package springboot.backend.apirest.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springboot.backend.apirest.DTO.DTO;
import springboot.backend.apirest.DTO.OrderDTO;
import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.OrderDetail;
import springboot.backend.apirest.models.services.ICustomerService;
import springboot.backend.apirest.models.services.IOrderDetailService;
import springboot.backend.apirest.models.services.IOrderService;
import springboot.backend.apirest.paginator.PageRender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@Controller
@SessionAttributes("order1")

public class OrderControllerMVC {
	OrderDTO orderDTO = new OrderDTO();

	@Autowired
	private IOrderService OrderService;
	@Autowired
	private ICustomerService CustomerService;
	@Autowired
	private IOrderDetailService OrderDetailService;

	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Order1> orderList = OrderService.findAll(pageRequest);

		PageRender<Order1> pageRender = new PageRender<Order1>("/listar", orderList);

		model.addAttribute("titulo", "Listado de ordenes");
		model.addAttribute("order1", orderList);
		model.addAttribute("page", pageRender);
		model.addAttribute("listdetalleproductos", orderDTO.RetornaDTO(orderList));
		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Pageable pageRequest = PageRequest.of(1, 10);
		DTO dto = new DTO();
		Order1 order1 = new Order1();
		java.util.Date fecha = new Date();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		
		dto.setListCustomer(CustomerService.findAll().subList(0, 10));
		dto.setOrderDetail(OrderDetailService.findAll().subList(0, 10));
		
		orderDetailList.add(OrderDetailService.findOne(1));
		orderDetailList.add(OrderDetailService.findOne(2));

		order1.setCustomerId(CustomerService.findOne(1));
		order1.setCreationDate(fecha);
		order1.setOrderDetailList(orderDetailList);

		model.put("order1", order1);
		model.put("titulo", "Formulario de Ordenes");
		model.put("listCustomer", dto.getListCustomer());
		model.put("listOrderDetail", dto.getOrderDetail());
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Order1 order1, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de order");

			return "form";
		}
		String mensajeFlash = (order1.getOrderId() != null) ? "orden editado con éxito!" : "Orden creado con éxito!";

		OrderService.save(order1);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}

}
