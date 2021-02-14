package springboot.backend.apirest.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import springboot.backend.apirest.models.entity.Customer;

public interface ICustomerDao extends PagingAndSortingRepository<Customer, Integer>{

}
