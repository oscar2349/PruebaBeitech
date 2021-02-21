package springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.backend.apirest.models.dao.IOrderDao;
import springboot.backend.apirest.models.entity.Order1;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private IOrderDao orderDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Order1> findAll() {
		return (List<Order1>) orderDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Order1> findAll(Pageable pageable) {
		return orderDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Order1 order1) {
		orderDao.save(order1);
		
	}

	@Override
	public Order1 findOne(Integer id) {
		return orderDao.findById(id).orElse(null);
	}

	@Override
	public List<Order1> findByStartDateBetween(String fechaInicial, String fechaFinal) {
		return (List<Order1>)orderDao.findByStartDateBetween(fechaInicial, fechaFinal);
	}

	

}
