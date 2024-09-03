package ait.shop.service;

import ait.shop.exception_handling.exceptions.FirstTestException;
import ait.shop.exception_handling.exceptions.ThirdTestException;
import ait.shop.model.dto.ProductDTO;
import ait.shop.model.entity.Product;
import ait.shop.repository.ProductRepository;
import ait.shop.service.interfaces.ProductService;
import ait.shop.service.mapping.ProductMappingService;
import com.amazonaws.services.s3.transfer.Copy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMappingService mapper;
    private final ProductRepository productRepository;

//    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(ProductRepository repository, ProductMappingService mapper, ProductRepository productRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.productRepository = productRepository;
    }


    @Transactional
    @Override
    public void attachImage(String imageUrl, String productTitle) {
        // Ищем продукт в базе по названию
        Product product = productRepository.findByTitle(productTitle)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Присваиваем продукту ссылку на изображение
        product.setImage(imageUrl);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        System.out.println("Method save work");
        Product product = mapper.mapDtoToEntity(productDTO);
//        product.setActive(true);
        return mapper.mapEntityToDto(repository.save(product));
    }

//    @Override
//    public ProductDTO getById(long id) {
//        logger.info("Method getById called with parameter: {}", id);
//        logger.warn("Method getById called with parameter: {}", id);
//        logger.error("Method getById called with parameter: {}", id);
//
//        Product product =  repository.findById(id).orElse(null);
//
//        if (product == null || !product.isActive() ) {
//            return null;
//        }
//
//        return mapper.mapEntityToDto(product);
//    }

    @Override
    public ProductDTO getById(long id) {

        Product product =  repository.findById(id).orElse(null);

        if (product == null) {
            throw new ThirdTestException("Product with id " + id + " not found");
        }
        if (!product.isActive() ) {
            throw new FirstTestException("This is first Test Exception message");
        }


        return mapper.mapEntityToDto(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        // создаю поток из элементов списка
        return repository.findAll().stream()
                // фильтрую поток (оставляю только активные элементы
                .filter(Product::isActive)
                // маппинг: поток Product -> поток ProductDto.
                // Каждый элемент потока будет преобразован из Product в ProductDto
                .map(mapper::mapEntityToDto)
                // собираю элементы потока в список (List)
                .toList();
    }


    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return null;
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
