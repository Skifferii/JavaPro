package ait.shop.repository.repository;

import ait.shop.model.entity.Customer;
import ait.shop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
