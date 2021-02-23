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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Oramirez
 */
@Entity
@Table(name = "order", catalog = "test", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o")
    , @NamedQuery(name = "Order1.findByOrderId", query = "SELECT o FROM Order1 o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "Order1.findByCreationDate", query = "SELECT o FROM Order1 o WHERE o.creationDate = :creationDate")
    , @NamedQuery(name = "Order1.findByDeliveryAddress", query = "SELECT o FROM Order1 o WHERE o.deliveryAddress = :deliveryAddress")
    , @NamedQuery(name = "Order1.findByTotal", query = "SELECT o FROM Order1 o WHERE o.total = :total")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    
    @Basic(optional = false)
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    
    @Basic(optional = false)
    @Column(name = "delivery_address", nullable = false, length = 191)
    private String deliveryAddress;
    
    @Basic(optional = false)
    @Column(name = "total", nullable = false)
    private double total;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private List<OrderDetail> orderDetailList;
   
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerId;

    
}
