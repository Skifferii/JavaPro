package ait.shop.service;

import ait.shop.exception_handling.exceptions.FirstTestException;
import ait.shop.exception_handling.exceptions.ThirdTestException;
import ait.shop.model.dto.CustomerDTO;
import ait.shop.model.entity.Customer;
import ait.shop.repository.CustomerRepository;
import ait.shop.service.interfaces.CustomerService;
import ait.shop.service.mapping.CustomerMappingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    final private CustomerMappingService mapper;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = mapper.mapDtoToEntity(customerDTO);
        return mapper.mapEntityToDto(repository.save(customer));
    }

    @Override

    public CustomerDTO getById(long id) {
       Customer customer = repository.findById(id).orElse(null);
        if (customer == null) {
            throw new ThirdTestException("Customer with id " + id + " not found");
        } if (!customer.isActive()) {
            throw new FirstTestException("THIS FIRST TEST MASSAGE");
        }
        return mapper.mapEntityToDto(customer);
    }



    @Override
    public   List<CustomerDTO> getAllActiveCustomers() {
        return repository.findAll().stream().filter(Customer ::isActive).map(mapper::mapEntityToDto).toList();
    }
    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        return null;
    }
    @Override
    public long getActiveCustomerCount() {
        return repository.count();
    }

    @Override
    public BigDecimal getTotalCostOfCustomersProducts(long customerId) {
        return null;
    }

    @Override
    public BigDecimal getAverageCostOfCustomersProducts(long customerId) {
        return null;
    }

    @Override
    public void addProductToCustomersCart(long customerId, long productId) {

    }

    @Override
    public void removeProductToCustomersCart(long customerId, long productId) {

    }

    @Override
    public void clearCustomersCart(long customerId) {

    }

    @Override
    public CustomerDTO deleteById(Long id) {
        Customer customer = repository.findById(id).orElse(null);
        if (customer == null || !customer.isActive()) {
            return null;
        }else {repository.deleteById(id);};
        return null;
    }
    @Override
    public void  deleteByName(String title) {

    }

    @Override
    public CustomerDTO restoreById(Long id) {
        return null;
    }


}
