package ait.shop.controller;

import ait.shop.model.dto.CustomerDTO;
import ait.shop.service.interfaces.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer controller", description = "controller for operations with customer")

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @PutMapping("/restore/{id}")
    public CustomerDTO restoreById(Long id) {
        return customerService.restoreById(id);
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable long id) {
        return customerService.getById(id);
    }

    @GetMapping
    public List<CustomerDTO> getAllActiveCustomers() {
        return customerService.getAllActiveCustomers();
    }

    @GetMapping("/count")
    public long getActiveCustomerCount() {
        return customerService.getActiveCustomerCount();
    }


    @DeleteMapping("/{id}")
    public CustomerDTO deleteById(@PathVariable Long id) {
        return customerService.deleteById(id);
    }

    @DeleteMapping("/byname/{name}")
    public void deleteByName(@RequestParam String name) {
        customerService.deleteByName(name);
    }

//    @GetMapping
//    public BigDecimal getTotalCostOfCustomersProducts(long customerId) {
//        return null;
//    }
//
//    @GetMapping
//    public BigDecimal getAverageCostOfCustomersProducts(long customerId) {
//        return null;
//    }
//
//    @PostMapping
//    public void addProductToCustomersCart(long customerId, long productId) {
//
//    }
//
//    @DeleteMapping
//    public void removeProductToCustomersCart(long customerId, long productId) {
//
//    }
//
//    @DeleteMapping
//    public void clearCustomersCart(long customerId) {
//
//    }
}
