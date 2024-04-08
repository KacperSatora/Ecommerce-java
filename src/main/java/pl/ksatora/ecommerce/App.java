package pl.ksatora.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.ksatora.ecommerce.catalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("yooooooooo");
        SpringApplication.run(App.class, args);
    }
    @Bean
    ProductCatalog createMyProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.addProduct("Lego set 1", "ok");
        productCatalog.addProduct("Cobi set 1", "Nice");
        return  productCatalog;
    }
}
