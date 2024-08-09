package app.controller;

import app.domain.Product;
import app.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product getProductById(long id){
        return productService.getById(id);
    }
}
