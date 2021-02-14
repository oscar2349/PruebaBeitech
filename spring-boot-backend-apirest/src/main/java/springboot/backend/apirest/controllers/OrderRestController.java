package springboot.backend.apirest.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.services.IOrderService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OrderRestController {

	@Autowired
	private IOrderService clienteService;

	@GetMapping("/order")
	public List<Order1> index() {
		
		return clienteService.findAll();
	}
	@GetMapping("/prueba")
	public String prueba(Model model) {
		model.addAttribute("titulo", "Prueba");
		return "hello";
	}

}
