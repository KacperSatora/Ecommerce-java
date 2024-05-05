package pl.ksatora.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import pl.ksatora.ecommerce.catalog.ArrayListProductStorage;
import pl.ksatora.ecommerce.catalog.ProductCatalog;

@SpringBootTest
public class AppTest {
    @Test
    void contextLoads(){}

    @Bean
    ProductCatalog createMyProductCatalog(){
        ProductCatalog productCatalog = new ProductCatalog(new ArrayListProductStorage());
        productCatalog.addProduct("Lego set 1", "Nice one");
        productCatalog.addProduct("Lego set 2", "Nice one");
        return productCatalog;
    }
}
