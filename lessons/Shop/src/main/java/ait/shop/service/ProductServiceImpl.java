package ait.shop.service;

import ait.shop.model.dto.ProductDTO;
import ait.shop.model.entity.Product;
import ait.shop.repository.repository.ProductRepository;
import ait.shop.service.interfaces.ProductService;
import ait.shop.service.mapping.ProductMappingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMappingService mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product =mapper.mapDtoToEntity(productDTO);
       // product.setActive(true);
        return mapper.mapEntityToDto(repository.save(product));
    }

    @Override
    public ProductDTO getById(long id) {
        Product product = repository.findById(id).orElse(null);
        if (product == null || !product.isActive()) {
            return null;
        }
        return mapper.mapEntityToDto(product);

    }
    @Override
    public List<ProductDTO> getAll() {
         return repository.findAll().stream()
                 .filter(Product ::isActive)
                 .map(mapper::mapEntityToDto)
                 .toList();
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public long getProductsCount() {
        return repository.count();
    }

    @Override
    public ProductDTO remove(Long id) {
        return null;
    }



    @Override
    public ProductDTO removeByTitle(String title) {
        return null;
    }

    @Override
    public ProductDTO restoreByTitle(Long id) {
        return null;
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
