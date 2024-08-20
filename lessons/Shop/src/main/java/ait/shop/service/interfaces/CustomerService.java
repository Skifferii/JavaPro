package ait.shop.service.interfaces;

import ait.shop.model.entity.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(@RequestBody Customer customer);

    public Customer getById(@PathVariable long id);

    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer);

    public Customer removeByID(@PathVariable Long id);

    public List<Customer> getAll();

    Customer removeByName(String title);

    Customer restoreById(Long id);

    long getCustomerCount();

}
