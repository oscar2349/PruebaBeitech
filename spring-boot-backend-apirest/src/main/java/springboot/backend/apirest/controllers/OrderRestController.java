package springboot.backend.apirest.controllers;


import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.services.IOrderService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OrderRestController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IOrderService clienteService;

	@GetMapping("/order")
	public Order1 index() {
	
		return clienteService.findOne(10);
	}

}
