package com.pbob.lazada.Orders;

import java.sql.Date;

import com.pbob.lazada.Customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String shippingStatus;
    private String paymentStatus;
    private Date tanggalOrder;
    @ManyToOne
    private Customer customer;

    public Orders(){
    }
    

    public Orders( String status, String shippingStatus, String paymentStatus, Date tanggalOrder, Customer customer) {
        this.status = status;
        this.shippingStatus = shippingStatus;
        this.paymentStatus = paymentStatus;
        this.tanggalOrder = tanggalOrder;
        this.customer = customer;
    }

}
