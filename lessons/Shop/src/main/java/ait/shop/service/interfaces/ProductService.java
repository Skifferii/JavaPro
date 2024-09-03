package ait.shop.service.interfaces;

import ait.shop.model.dto.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    public ProductDTO saveProduct(@RequestBody ProductDTO product);

    public ProductDTO getById(@PathVariable long id);

    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO product);

    public ProductDTO remove(@PathVariable Long id);

    public List<ProductDTO> getAll();

    ProductDTO removeByTitle(String title);

    ProductDTO restoreByTitle(Long id);

    long getProductsCount();

    BigDecimal getTotalPrice();

    BigDecimal getAveragePrice();

    void attachImage(String imageUrl, String productTitle);

}
