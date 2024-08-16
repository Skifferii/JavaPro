package ait.shop.controller;

import ait.shop.model.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")

public class CustomerController {

    @PostMapping
    public Customer saveProduct(@RequestBody Customer customer) {

        //TODO ask to service


        return customer;
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable long id) {
        //TODO ask to service from id
        return null;
    }

    @PutMapping("/{id}")
    public Customer updateProduct( @PathVariable Long id, @RequestBody Customer product) {

        return product;
    }


    @DeleteMapping("/{id}")
    public Customer remove(@PathVariable Long id) {
        return null;
    }



    @GetMapping
    public List<Customer> getAll() {
        return null;
    }



}
