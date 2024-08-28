package ait.shop.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

@Schema(description = "DTO for  Product")

public class ProductDTO {
    @Schema(description = "Product unique identifier", example = "777", accessMode = Schema.AccessMode.READ_ONLY)
       private Long id; //null

    @Schema(description = "Product title", example = "marakuya")
    @NotNull(message = "Product title cannot be null")
    @NotBlank(message = "Product title cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9 ]{2,}$", message = "Product title should be at least 3 characters long and contains only letters and spaces")
    private String title; //null

    @Schema(description = "Product price", example = "25.45")
    @DecimalMin(value = "1.0", message = "product price should be greater or equal than 1.0")
    @DecimalMax(value = "100000.0", message = "product price should be less than 1")
    private BigDecimal price; //null



    @Override
    public String toString() {
        return String.format("ProductDTO: id - %d, title - %s, price - %s",
                id, title, price);
    }

    public ProductDTO() {
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(price);
        return result;
    }
}
