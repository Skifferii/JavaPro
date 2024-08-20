package ait.shop.controller;

import ait.shop.model.entity.Customer;
import ait.shop.service.interfaces.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")


public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @PutMapping("/restore/{id}")
    public Customer restoreById(Long id) {
        return customerService.restoreById(id);
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable long id) {
        return customerService.getById(id);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/count")
    public long getCustomerCount() {
        return customerService.getCustomerCount();
    }

    @DeleteMapping("/{id}")
    public Customer removeById(@PathVariable Long id) {
        return customerService.removeByID(id);
    }

    @DeleteMapping("/{by-title}")
    public Customer removeByName(String title) {
        return customerService.removeByName(title);
    }

}
