package ait.shop.service;

import ait.shop.model.entity.Customer;
import ait.shop.model.entity.Product;
import ait.shop.repository.repository.CustomerRepository;
import ait.shop.repository.repository.ProductRepository;
import ait.shop.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getById(long id) {
        Customer customer = repository.findById(id).orElse(null);
        if (customer == null || !customer.isActive()) {
            return null;
        }
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer remove(Long id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public Customer removeByName(String title) {
        return null;
    }

    @Override
    public Customer restoreById(Long id) {
        return null;
    }

    @Override
    public long getCustomerCount() {
        return repository.count();
    }
}
