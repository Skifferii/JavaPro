package client;

import app.controller.ProductController;
import app.domain.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("app");

        ProductController controller = context.getBean(ProductController.class);

        Product product = controller.getProductById(2);
        System.out.println(product);
        System.out.println(controller.getProductById(1));
    }
}
