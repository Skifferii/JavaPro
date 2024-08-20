package ait.shop.controller;

import ait.shop.model.entity.Product;
import ait.shop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) { //TODO ask to service
        return productService.saveProduct(product);
    }

//    //GET /products?id=3
//    @GetMapping
//    public Product getById (@RequestParam long id) {//TODO ask to service from id
// return null;}

    //GET /products/{id} - peremennay wega
    @GetMapping("/{id}")
    public Product getById(@PathVariable long id) {    //TODO ask to service from id
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Product remove(@PathVariable Long id) {
        return productService.remove(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @DeleteMapping("/{by-title}")
    public Product removeByTitle(String title) {
        return productService.removeByTitle(title);
    }

    @PutMapping("/restore/{id}")
    public Product restoreByTitle(Long id) {
        return productService.restoreByTitle(id);
    }

    @GetMapping("/count")
    public long getProductsCount() {
        return productService.getProductsCount();
    }

    @GetMapping("/total-price")
    public BigDecimal getTotalPrice() {
        return productService.getTotalPrice();
    }

    @GetMapping("average-price")
    public BigDecimal getAveragePrice() {
        return productService.getAveragePrice();
    }

}
