package com.pbob.lazada.Orders;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/orders/")
    public String index(Model model) {
        List<Orders> daftarOrders = this.ordersService.ambilSemua();
        model.addAttribute("dataorders", daftarOrders);
        return "orders/index";
    }

    @GetMapping("/orders/tambah")
    public String form_tambah() {
        return "/orders/tambah";
    }

    @PostMapping("/orders/simpan")
    public String simpan(@ModelAttribute Orders orders) {

        this.ordersService.simpan(orders);
        return "redirect:/orders/";

    }

    @GetMapping("/orders/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Orders orders = this.ordersService.ambilById(id);
        model.addAttribute("orders", orders);
        return "orders/view";
    }

    @GetMapping("/orders/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Orders orders = this.ordersService.ambilById(id);
        model.addAttribute("orders", orders);
        return "orders/edit";
    }

    @PostMapping("/orders/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Orders orders) {
        this.ordersService.ubah(id, orders);
        return "redirect:/orders/";

    }

    @GetMapping("/orders/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        this.ordersService.hapus(id);
        return "redirect:/orders/";
    }
}
