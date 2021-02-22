package springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.backend.apirest.models.dao.IOrderDao;
import springboot.backend.apirest.models.dao.IProductDao;
import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.Product;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAll(Pageable pageable) {
		return productDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Product product) {
		productDao.save(product);
		
	}

	@Override
	public Product findOne(Integer id) {
		return productDao.findById(id).orElse(null);
	}

	

}
