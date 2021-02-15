package springboot.backend.apirest.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import springboot.backend.apirest.models.entity.Order1;

public interface IOrderDao extends PagingAndSortingRepository<Order1, Integer>{

}
