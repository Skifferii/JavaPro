package ait.shop.repository;

import ait.shop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByActiveTrue();
    Optional<Product> findByTitle(String title);
//    List<Product> findAllByActive(boolean active);
}
