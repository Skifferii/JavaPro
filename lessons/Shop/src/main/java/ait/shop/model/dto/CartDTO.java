package ait.shop.model.dto;

import ait.shop.model.entity.Customer;
import ait.shop.model.entity.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

public class CartDTO {


    private Long id;

    @JsonBackReference
    private Customer customer;

    List<ProductDTO> products;


    @Override
    public String toString() {
        return String.format("CartDTO: id: %d, products: %s, customer : %s", id, products == null ? "null" : products, customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartDTO cartDTO = (CartDTO) o;
        return Objects.equals(id, cartDTO.id) && Objects.equals(customer, cartDTO.customer) && Objects.equals(products, cartDTO.products);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(customer);
        result = 31 * result + Objects.hashCode(products);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
