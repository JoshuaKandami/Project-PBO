package com.pbob.lazada.Orders;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void simpan(Orders orders) {
        this.ordersRepository.save(orders);
    }

    public List<Orders> ambilSemua() {
        return this.ordersRepository.findAll();
    }

    public Orders ambilById(Long id) {
        // mengambil data
        Orders orders = this.ordersRepository.findById(id).orElse(null);
        return orders;
    }

    public void ubah(Long id, Orders orders) {
        Orders data_lama = this.ordersRepository.findById(id).orElse(null);

        data_lama.setStatus(orders.getStatus());
        data_lama.setShippingStatus(orders.getShippingStatus());
        data_lama.setPaymentStatus(orders.getPaymentStatus());
        data_lama.setTanggalOrder(orders.getTanggalOrder());
        data_lama.setCustomer(orders.getCustomer());

        this.ordersRepository.save(data_lama);
    }

    public void hapus(Long id) {
        this.ordersRepository.deleteById(id);
    }
}
