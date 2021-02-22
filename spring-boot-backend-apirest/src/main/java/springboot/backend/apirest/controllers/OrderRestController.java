package springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.backend.apirest.DTO.DTO;
import springboot.backend.apirest.DTO.OrderDTO;
import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.services.ICustomerService;
import springboot.backend.apirest.models.services.IOrderDetailService;
import springboot.backend.apirest.models.services.IOrderService;
import springboot.backend.apirest.models.services.IProductService;
import springboot.backend.apirest.paginator.PageRender;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OrderRestController {

	@Autowired
	private IOrderService OrderService;
	@Autowired
	private ICustomerService CustomerService;
	@Autowired
	private IProductService ProductService;
	@Autowired
	private IOrderDetailService OrderDetailService;

	@GetMapping("/order")
	
	public DTO index() {


		OrderDTO orderDTO = new OrderDTO();
		DTO dto = new DTO();


		dto.setListCustomer(CustomerService.findAll());//
	
		return dto;
	}

}
