package springboot.backend.apirest.models.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.OrderDetail;

public interface IOrderDetailService {
	
	public OrderDetail findOne(Integer id);
	public List <OrderDetail> findAll();
	Page<OrderDetail> findAll(Pageable pageable);
	public void save(OrderDetail orderDetailList);
	

}
