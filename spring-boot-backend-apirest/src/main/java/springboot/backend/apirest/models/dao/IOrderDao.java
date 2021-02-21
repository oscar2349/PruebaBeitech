package springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import springboot.backend.apirest.models.entity.Order1;

public interface IOrderDao extends PagingAndSortingRepository<Order1, Integer>{

	@Query(
			  value = "SELECT * FROM test.order where creation_date BETWEEN ?1 AND ?2 ORDER BY creation_date DESC  ", 
			  nativeQuery = true)
	public List <Order1> findByStartDateBetween(String fechaInicial,String fechaFinal);
	
	
}
