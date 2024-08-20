package ait.shop.service;

import ait.shop.model.entity.Product;
import ait.shop.repository.repository.ProductRepository;
import ait.shop.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {
        product.setActive(true);
        return repository.save(product);
    }

    @Override
    public Product getById(long id) {
        Product product = repository.findById(id).orElse(null);
        if (product == null || !product.isActive()) {
            return null;
        }
        return product;

    }
    @Override
    public List<Product> getAll() {
         return repository.findAll().stream()
                 .filter(Product ::isActive)
                 .toList();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return repository.save(product);
    }


    @Override
    public Product remove(Long id) {
        return null;
    }



    @Override
    public Product removeByTitle(String title) {
        return null;
    }

    @Override
    public Product restoreByTitle(Long id) {
        return null;
    }

    @Override
    public long getProductsCount() {
        return 0;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return null;
    }

    @Override
    public BigDecimal getAveragePrice() {
        return null;
    }
}
