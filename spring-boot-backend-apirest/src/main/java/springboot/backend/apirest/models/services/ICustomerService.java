package springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import springboot.backend.apirest.DTO.DTO;
import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.Order1;

public interface ICustomerService {
	
	public List<Customer> findAll();
	public Customer findOne(Integer id);
	public Page<Customer> findAll(Pageable pageable);


}
