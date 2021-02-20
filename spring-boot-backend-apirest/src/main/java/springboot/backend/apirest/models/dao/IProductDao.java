package springboot.backend.apirest.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.Product;

public interface IProductDao extends PagingAndSortingRepository<Product, Integer>{

}
