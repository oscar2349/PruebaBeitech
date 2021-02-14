package springboot.backend.apirest.DTO;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.OrderDetail;

public class DTO {
	
	private Date creationDate;
	private double total;
    private Integer orderId;
	private String deliveryAddress,orderDetail,customerId;
	List<Customer> listCustomer;
	List<OrderDetail> OrderDetail;

	public List<OrderDetail> getOrderDetail() {
		return OrderDetail;
	}

	public void setOrderDetail(List <OrderDetail> orderDetail) {
		OrderDetail =  orderDetail;
	}

	public List<Customer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<Customer> listCustomer) {
		this.listCustomer =  listCustomer;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer integer) {
		this.orderId = integer;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date date) {
		this.creationDate = date;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double d) {
		this.total = d;
	}

	public String getOrderDetailList() {
		return orderDetail;
	}

	public void setOrderDetailList(String orderDetailList) {
		this.orderDetail = orderDetailList;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
    
  

}
