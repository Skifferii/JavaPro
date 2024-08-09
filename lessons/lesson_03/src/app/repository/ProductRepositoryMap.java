package app.repository;

import app.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository

public class ProductRepositoryMap implements ProductRepository {
    private Map<Long, Product> database = new HashMap<>();

  ProductRepositoryMap(){
    initData();
}

private void initData(){
    database.put(1L, new Product(1L,"Apple", new BigDecimal(3)));
    database.put(2L, new Product(2L,"Banana", new BigDecimal(2)));
    database.put(3L, new Product(3L,"Orange", new BigDecimal(5)));
}


    @Override
    public Product getProductById(long id) {
        return database.get(id);
    }
}
