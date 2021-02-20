package springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import springboot.backend.apirest.DTO.DTO;
import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.OrderDetail;
import springboot.backend.apirest.models.entity.Product;

public interface IProductService {
	
	public List<Product> findAll();
	public Product findOne(Integer id);
	public Page<Product> findAll(Pageable pageable);
	public void save(Product product);


}
