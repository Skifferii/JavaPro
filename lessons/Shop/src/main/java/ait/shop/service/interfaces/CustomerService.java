package ait.shop.service.interfaces;

import ait.shop.model.dto.CustomerDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(@RequestBody CustomerDTO customer);

    List<CustomerDTO> getAllActiveCustomers();

    CustomerDTO getById(@PathVariable long id);

    CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customer);

    CustomerDTO deleteById(@PathVariable Long id);

    void deleteByName(String title);

    CustomerDTO restoreById(Long id);

    long getActiveCustomerCount();

    BigDecimal getTotalCostOfCustomersProducts(long customerId);

    BigDecimal getAverageCostOfCustomersProducts(long customerId);
    void addProductToCustomersCart(long customerId, long productId );
    void removeProductToCustomersCart(long customerId, long productId );
    void clearCustomersCart(long customerId);


}
