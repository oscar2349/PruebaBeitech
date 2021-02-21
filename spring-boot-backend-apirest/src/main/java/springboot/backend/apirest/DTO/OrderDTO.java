package springboot.backend.apirest.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import springboot.backend.apirest.models.dao.IOrderDetailDao;
import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.OrderDetail;
import springboot.backend.apirest.models.services.OrderDetailServiceImpl;

@Service
public class OrderDTO {

	private String detalleproductos = "";
	List<DTO> listadoDTO = new ArrayList<DTO>();

	public List<DTO> RetornaDTO(Page<Order1> orderList) {

		for (Order1 order1 : orderList) {
			DTO dto = new DTO();
			dto.setCreationDate(order1.getCreationDate());
			dto.setTotal(order1.getTotal());
			dto.setOrderId(order1.getOrderId());
			dto.setDeliveryAddress(order1.getDeliveryAddress());

			for (OrderDetail orderDetail : order1.getOrderDetailList()) {
				detalleproductos = detalleproductos + orderDetail.getQuantity() + " x "
						+ orderDetail.getProductDescription() + "<br>";

			}
			dto.setOrderDetailList(detalleproductos);
			detalleproductos = "";
			listadoDTO.add(dto);
		}

		return listadoDTO;

	}
	
	public List<DTO> RetornaDTO(List<Order1> orderList) {

		for (Order1 order1 : orderList) {
			DTO dto = new DTO();
			dto.setCreationDate(order1.getCreationDate());
			dto.setTotal(order1.getTotal());
			dto.setOrderId(order1.getOrderId());
			dto.setDeliveryAddress(order1.getDeliveryAddress());

			for (OrderDetail orderDetail : order1.getOrderDetailList()) {
				detalleproductos = detalleproductos + orderDetail.getQuantity() + " x "
						+ orderDetail.getProductDescription() + "<br>";

			}
			dto.setOrderDetailList(detalleproductos);
			detalleproductos = "";
			listadoDTO.add(dto);
		}

		return listadoDTO;

	}

}
