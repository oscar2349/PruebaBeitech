package springboot.backend.apirest.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import springboot.backend.apirest.models.entity.OrderDetail;

public interface IOrderDetailDao extends PagingAndSortingRepository<OrderDetail, Integer>{

}
