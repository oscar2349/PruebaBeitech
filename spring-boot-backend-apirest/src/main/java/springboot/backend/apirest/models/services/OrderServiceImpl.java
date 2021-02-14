package springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.backend.apirest.DTO.DTO;
import springboot.backend.apirest.models.dao.ICustomerDao;
import springboot.backend.apirest.models.dao.IOrderDao;
import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.OrderDetail;
import springboot.backend.apirest.models.entity.Product;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private IOrderDao orderDao;
	private ICustomerDao customerDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Order1> findAll() {
		return (List<Order1>) orderDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Order1> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return orderDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Order1 order1) {

		orderDao.save(order1);
		
	}

	

}
