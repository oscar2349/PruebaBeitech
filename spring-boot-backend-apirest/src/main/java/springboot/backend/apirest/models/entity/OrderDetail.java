/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Oramirez
 */
@Entity
@Table(name = "order_detail", catalog = "test", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o")
    , @NamedQuery(name = "OrderDetail.findByOrderDetailId", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailId = :orderDetailId")
    , @NamedQuery(name = "OrderDetail.findByProductDescription", query = "SELECT o FROM OrderDetail o WHERE o.productDescription = :productDescription")
    , @NamedQuery(name = "OrderDetail.findByPrice", query = "SELECT o FROM OrderDetail o WHERE o.price = :price")
    , @NamedQuery(name = "OrderDetail.findByQuantity", query = "SELECT o FROM OrderDetail o WHERE o.quantity = :quantity")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_detail_id", nullable = false)
    private Integer orderDetailId;
   
    @Basic(optional = false)
    @Column(name = "product_description", nullable = false, length = 191)
    private String productDescription;
    
    @Basic(optional = false)
    @Column(name = "price", nullable = false)
    private double price;
    
    @Basic(optional = false)
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false)
    private Product productId;
   
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    @ManyToOne(optional = false)
    private Order1 orderId;
    
}
