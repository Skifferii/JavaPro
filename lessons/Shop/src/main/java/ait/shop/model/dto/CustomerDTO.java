package ait.shop.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;

@Schema(description = "DTO for  Customer")

public class CustomerDTO {
    @Schema(description = "Customer unique identifier", example = "232", accessMode = Schema.AccessMode.READ_ONLY)
       private Long id; //null

    @Schema(description = "Customer name", example = "Bob")
    private String name; //null

    @Schema(description = "Is active", example = "true")
    private boolean active;

    @JsonManagedReference
    private CartDTO cart;

    @Override
    public String toString() {
        return String.format("CustomerDTO: id - %d, name - %s, active - %s, cartId: %s",
                id, name, active ? "yes" : "no", cart.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDTO that = (CustomerDTO) o;
        return active == that.active && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Boolean.hashCode(active);
        result = 31 * result + Objects.hashCode(cart);
        return result;
    }
}
