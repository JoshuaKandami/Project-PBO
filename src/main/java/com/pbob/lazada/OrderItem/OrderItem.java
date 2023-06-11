package com.pbob.lazada.OrderItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderItem {
    
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderID;
    private int productID;
    private int jumlah;

    public OrderItem() {
    }

    public OrderItem(int orderID, int productID, int jumlah) {
        this.orderID = orderID;
        this.productID = productID;
        this.jumlah = jumlah;
    }
}
