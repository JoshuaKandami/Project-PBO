package com.pbob.lazada.Customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void simpan(Customer customer) {
        this.customerRepository.save(customer);
    }

    public List<Customer> ambilSemua() {
        return customerRepository.findAll();
    }

    public Customer ambilById(Long id) {
        Customer customer = this.customerRepository.findById(id).orElse(null);
        return customer;
    }

    public void ubah(Long id, Customer customer) {
        Customer data_lama = this.customerRepository.findById(id).orElse(null);

        data_lama.setNamaLengkap(customer.getNamaLengkap());
        data_lama.setNomorHp(customer.getNomorHp());
        data_lama.setUser(customer.getUser());
        data_lama.setAlamat(customer.getAlamat());
        customerRepository.save(data_lama);
    }

    public void hapus(Long id) {
        customerRepository.deleteById(id);
    }
}
