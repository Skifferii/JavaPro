package app.service;

import app.domain.Product;
import app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class ProductServiceImpl implements ProductService {



    private String articlePrefix;
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository, @Value("${article.prefix}") String articlePrefix) {
        this.repository = repository;
        this.articlePrefix = articlePrefix;
    }

    @Override
    public Product getById(long id) {
        Product product = repository.getProductById(id);
        setArticle(product);
        return product;
    }

    private  void  setArticle (Product product){
        // Art-B-2
        String article = String.format("%s-%s-%d",articlePrefix,product.getTitle().charAt(0), product.getId());
        product.setArticle(article);

    }
}
