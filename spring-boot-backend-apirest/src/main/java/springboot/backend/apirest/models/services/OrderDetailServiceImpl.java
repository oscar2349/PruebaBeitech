package springboot.backend.apirest.models.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.backend.apirest.models.dao.IOrderDetailDao;
import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.OrderDetail;


@Service
public class OrderDetailServiceImpl implements IOrderDetailService{

	@Autowired
	private IOrderDetailDao orderDetailDao;
	
	@Override
	public OrderDetail findOne(Integer id) {
		return orderDetailDao.findById(id).orElse(null);
	}

	@Override
	public List<OrderDetail> findAll() {
		
		return (List<OrderDetail>) orderDetailDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<OrderDetail> findAll(Pageable pageable) {
		return orderDetailDao.findAll(pageable);
	}


}
