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

    @GetMapping("/{id}")
    public Customer getById(@PathVariable long id) {
        return customerService.getById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }



    @DeleteMapping("/{id}")
    public Customer removeById(@PathVariable Long id) {
        return customerService.restoreById(id);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @PutMapping("/{by-title}")
    public Customer removeByName(String title) {
        return customerService.removeByName(title);
    }
    @PutMapping
    public Customer removeByID(Long id) {
        return customerService.removeByID(id);
    }
    @PutMapping("/restore/{id}")
    public Customer restoreById(Long id) {
        return customerService.restoreById(id);
    }

    @GetMapping("/count")
    public long getCustomerCount() {
        return customerService.getCustomerCount();
    }


}
