package springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.backend.apirest.util.*;

import springboot.backend.apirest.DTO.DTO;
import springboot.backend.apirest.DTO.OrderDTO;
import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.OrderDetail;
import springboot.backend.apirest.models.entity.Product;
import springboot.backend.apirest.models.services.ICustomerService;
import springboot.backend.apirest.models.services.IOrderDetailService;
import springboot.backend.apirest.models.services.IOrderService;
import springboot.backend.apirest.models.services.IProductService;
import springboot.backend.apirest.paginator.PageRender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes("order1")
public class OrderControllerMVC {

	@Autowired
	private IOrderService OrderService;
	@Autowired
	private ICustomerService CustomerService;
	@Autowired
	private IProductService ProductService;
	@Autowired
	private IOrderDetailService OrderDetailService;

	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		OrderDTO orderDTO = new OrderDTO();
		Pageable pageRequest = PageRequest.of(page, 15);
		Page<Order1> orderList = OrderService.findAll(pageRequest);

		PageRender<Order1> pageRender = new PageRender<Order1>("/listar", orderList);

		model.addAttribute("order1", orderList);
		model.addAttribute("page", pageRender);
		model.addAttribute("listdetalleproductos", orderDTO.RetornaDTO(orderList));
		return "listar";
	}

	@GetMapping("/form")
	public String crear(Map<String, Object> model) {

		DTO dto = new DTO();
		Order1 order1 = new Order1();

		dto.setListCustomer(CustomerService.findAll());//
		dto.setProductList(ProductService.findAll());

		model.put("order1", order1);
		model.put("titulo", "Formulario de Ordenes");
		model.put("listCustomer", dto.getListCustomer());
		model.put("listProduct", dto.getProductList());
		return "form";
	}

	@GetMapping("/filtro")
	public String filtrar() {

		return "filtro";
	}
	@PostMapping("/form")
	public String guardar(HttpServletRequest request, Order1 order1,RedirectAttributes flash) {
		List<String> productos = new ArrayList<String>();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

		for (int i = 1; i <= 5; i++) {
			if (request.getParameter("producto" + i) != "") {
				productos.add(request.getParameter("producto" + i));
			}

		}

		//if (productos.size() >= 3) {
			int j = 1;
			
			
			java.util.Date fecha = new Date();
			order1.setCreationDate(fecha);
			order1.setCustomerId(CustomerService.findOne(Integer.parseInt(request.getParameter("customerId"))));
			double total=0;
			
			for (String idProducto : productos) {

				OrderDetail orderDetail = new OrderDetail();
				Product product = ProductService.findOne(Integer.parseInt(idProducto));
				int cantidad = Integer.parseInt(request.getParameter("cantidad"+j));
				double precio = product.getPrice();
				total = (total) + cantidad * precio;//Guardar el total de la Orden
				order1.setTotal(total);//precio * cantidad
				
				orderDetail.setOrderId(order1);
				orderDetail.setPrice(total);
				orderDetail.setProductDescription(product.getProductDescription());
				orderDetail.setProductId(product);
				orderDetail.setQuantity(cantidad);

				orderDetailList.add(orderDetail);
				j++;

			}
			
			order1.setOrderDetailList(orderDetailList);
			OrderService.save(order1);

			flash.addFlashAttribute("success", "Creado con Exito");
			return "redirect:listar";

	}
}
