package springboot.backend.apirest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.backend.apirest.DTO.DTO;
import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.Product;
import springboot.backend.apirest.models.services.ICustomerService;
import springboot.backend.apirest.models.services.IOrderService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OrderRestController {

	@Autowired
	private IOrderService clienteService;

	@Autowired
	private ICustomerService customerService;

	@GetMapping("/order")
	public List<DTO> index() {

		List<Order1> list = clienteService.findAll();
		List<DTO> listDto = new ArrayList<DTO>();
		
		Customer customer = new Customer();
		List<Product> productList = null;

		for (Order1 order1 : list) {
			DTO dto = new DTO();
			dto.setOrderId(order1.getOrderId());
			dto.setCreationDate(order1.getCreationDate());
			dto.setDeliveryAddress(order1.getDeliveryAddress());
			customer = order1.getCustomerId();

			dto.setCustomer(customer);
			listDto.add(dto);

		}
		return listDto;
	}

}
