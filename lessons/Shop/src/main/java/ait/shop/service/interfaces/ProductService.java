package ait.shop.service.interfaces;

import ait.shop.model.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    public Product saveProduct(@RequestBody Product product);

    public Product getById(@PathVariable long id);

    public Product updateProduct(@PathVariable Long id, @RequestBody Product product);

    public Product remove(@PathVariable Long id);

    public List<Product> getAll();

    Product removeByTitle(String title);

    Product restoreByTitle(Long id);

    long getProductsCount();

    BigDecimal getTotalPrice();

    BigDecimal getAveragePrice();

}
