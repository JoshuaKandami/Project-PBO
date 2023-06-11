package com.pbob.lazada.OrderItem;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/orderitem/")
    public String index(Model model) {
        // data yang dikembalikan method akan disimpan di dalam suatu list dengan nama
        // daftar product
        List<OrderItem> daftarOrderItems = this.orderItemService.ambilSemua();

        // dafarproduct dari list di atas
        // datanya = nama yang akan digynakan pada halaman web
        // pada saat mau mengaskses data yang di daftar product, harus pakai datanya
        model.addAttribute("dataorderitem", daftarOrderItems);

        return "/orderitem/index";
    }

    @GetMapping("/orderitem/tambah")
    public String form_tambahkate() {
        return "/orderitem/tambah";
    }

    // menyimpan data yang ditambahkan
    @PostMapping("/orderitem/simpan")
    public String simpan(@ModelAttribute OrderItem orderItem) {
        // menjalankan perintah di fungsi
        this.orderItemService.simpan(orderItem);
        // setelah dtanya disimpan, mau kembali ke halaman mana
        return "redirect:/orderitem/";
    }

    @GetMapping("/orderitem/view/{id}")
    public String view(@PathVariable Long id, Model model) {

        // mengambil data
        OrderItem orderItem = this.orderItemService.ambilById(id);

        // mengambalikan data ke web
        model.addAttribute("orderitem", orderItem);

        return "orderitem/view";

    }

    @GetMapping("/orderitem/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        OrderItem orderItem = this.orderItemService.ambilById(id);
        model.addAttribute("orderitem", orderItem);
        return "orderitem/edit";
    }

    @PostMapping("/orderitem/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute OrderItem orderItem) {
        this.orderItemService.ubah(id, orderItem);
        return "redirect:/orderitem/";
    }

    
   @GetMapping("/orderitem/hapus/{id}")
   public String hapus(@PathVariable Long id) {
      this.orderItemService.hapus(id);
      return "redirect:/orderitem/";
   }
}
