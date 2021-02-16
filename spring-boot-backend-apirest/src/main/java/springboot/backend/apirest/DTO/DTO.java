package springboot.backend.apirest.DTO;

import java.util.Date;
import java.util.List;

import springboot.backend.apirest.models.entity.Customer;
import springboot.backend.apirest.models.entity.OrderDetail;
import springboot.backend.apirest.models.entity.Product;

public class DTO {

	private Date creationDate;
	private double total;
	private Integer orderId;
	private String deliveryAddress, orderDetail;
	private Integer producto1,producto2,producto3;
	List<Customer> listCustomer;
	List<OrderDetail> OrderDetail;
	List<Product> productList ;
	private Customer customer;


	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}

	public List<OrderDetail> getOrderDetail() {
		return OrderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		OrderDetail = orderDetail;
	}

	public List<Customer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<Customer> listCustomer) {
		this.listCustomer = listCustomer;
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

	public Integer getProducto1() {
		return producto1;
	}

	public void setProducto1(Integer producto1) {
		this.producto1 = producto1;
	}

	public Integer getProducto2() {
		return producto2;
	}

	public void setProducto2(Integer producto2) {
		this.producto2 = producto2;
	}

	public Integer getProducto3() {
		return producto3;
	}

	public void setProducto3(Integer producto3) {
		this.producto3 = producto3;
	}



	
}
