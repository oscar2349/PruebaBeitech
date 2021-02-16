package springboot.backend.apirest.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import springboot.backend.apirest.models.entity.Order1;
import springboot.backend.apirest.models.entity.OrderDetail;

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

}
