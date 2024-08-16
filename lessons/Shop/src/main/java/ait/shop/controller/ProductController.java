package ait.shop.controller;

import ait.shop.model.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {

        //TODO ask to service

        return product;
    }
//
//    //GET /products?id=3
//    @GetMapping
//    public Product getById (@RequestParam long id) {
//        //TODO ask to service from id
//        return null;
//    }
//

    //GET /products/{id} - peremennay wega
    @GetMapping("/{id}")
    public Product getById(@PathVariable long id) {
        //TODO ask to service from id
        return null;
    }

    @PutMapping("/{id}")
    public Product updateProduct( @PathVariable Long id, @RequestBody Product product) {

        return product;
    }


    @DeleteMapping("/{id}")
    public Product remove(@PathVariable Long id) {
        return null;
    }



    @GetMapping
    public List<Product> getAll() {
        return null;
    }



}
