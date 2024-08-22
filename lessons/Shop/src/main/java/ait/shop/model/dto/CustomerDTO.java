package ait.shop.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;

@Schema(description = "DTO for  Customer")

public class CustomerDTO {
    @Schema(description = "Customer unique identifier", example = "232", accessMode = Schema.AccessMode.READ_ONLY)
       private Long id; //null

    @Schema(description = "Customer name", example = "Bob")

    private String name; //null

    @Override
    public String toString() {
        return String.format("Product: id - %d, name - %s",
                id, name);
    }

    public CustomerDTO() {
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        return result;
    }
}
