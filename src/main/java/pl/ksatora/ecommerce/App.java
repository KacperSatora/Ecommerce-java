package pl.ksatora.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.ksatora.ecommerce.catalog.ArrayListProductStorage;
import pl.ksatora.ecommerce.catalog.ProductCatalog;
import pl.ksatora.ecommerce.sales.SalesFacade;
import pl.ksatora.ecommerce.sales.cart.InMemoryCartStorage;
import pl.ksatora.ecommerce.sales.offering.OfferCalculator;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new ArrayListProductStorage());
        productCatalog.addProduct("Lego set 1", "very nice lego set", BigDecimal.TEN);
        productCatalog.addProduct("Cobi set 1", "not so nice blocks", BigDecimal.ONE);

        return productCatalog;
    }
    @Bean
    SalesFacade createMySalesFacade() {
        return new SalesFacade(new InMemoryCartStorage(), new OfferCalculator());
    }
}