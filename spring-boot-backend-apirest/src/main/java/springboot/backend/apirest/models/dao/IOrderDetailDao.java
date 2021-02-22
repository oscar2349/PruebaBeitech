package springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.OrderDetail;

public interface IOrderDetailDao extends PagingAndSortingRepository<OrderDetail, Integer>{
	
	@Query(
			  value = "SELECT * FROM test.order_detail where order_id = ?1 ;", 
			  nativeQuery = true)
	public List<OrderDetail> findOrderId(Integer id);
}
