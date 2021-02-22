package springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import springboot.backend.apirest.DTO.DTO;
import springboot.backend.apirest.models.entity.Order1;

public interface IOrderService {
	
	public List<Order1> findAll();
	public Page<Order1> findAll(Pageable pageable);
	public List<Order1> findByStartDateBetween(String fechaInicial,String fechaFinal);
	public Order1 findOne(Integer id);
	public void save(Order1 order1);


}
