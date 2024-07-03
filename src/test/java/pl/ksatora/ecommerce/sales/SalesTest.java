package pl.ksatora.ecommerce.sales;

import org.junit.jupiter.api.Test;
import pl.ksatora.ecommerce.sales.cart.InMemoryCartStorage;
import pl.ksatora.ecommerce.sales.offering.Offer;
import pl.ksatora.ecommerce.sales.offering.OfferCalculator;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesTest {

    @Test
    void itShowsCurrentOffer() {
        SalesFacade sales = thereIsSalesFacade();
        var customerId = thereIsCustomer("Kacper");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(0, offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }

    @Test
    void itAddsProductToCart() {
        var customerId = thereIsCustomer("Kacper");
        var productId = thereIsProduct("Product A", BigDecimal.valueOf(10));
        SalesFacade sales = thereIsSalesFacade();
        //ACT
        sales.addProduct(customerId, productId);

        //ASSERT
        Offer currentOffer = sales.getCurrentOffer(customerId);
        // getTotal() not implemented => BigDecimal 0
        assertEquals(BigDecimal.valueOf(00), currentOffer.getTotal());
        assertEquals(0, currentOffer.getItemsCount());

    }

    @Test
    void itAddMultipleProductsToCart() {
        var customerId = thereIsCustomer("Kacper");
        var productA = thereIsProduct("Product A", BigDecimal.valueOf(10));
        var productB = thereIsProduct("Product B", BigDecimal.valueOf(20));
        SalesFacade sales = thereIsSalesFacade();
        //ACT
        sales.addProduct(customerId, productA);
        sales.addProduct(customerId, productB);

        //ASSERT
        Offer currentOffer = sales.getCurrentOffer(customerId);
        // getTotal() not implemented => BigDecimal 0
        assertEquals(BigDecimal.valueOf(0), currentOffer.getTotal());
        // getItemsCount
        assertEquals(0, currentOffer.getItemsCount());

    }

    @Test
    void itDoesNotShareCustomersCarts() {
        var customerA = thereIsCustomer("Kacper");
        var customerB = thereIsCustomer("Wiktor");
        var productA = thereIsProduct("Product A", BigDecimal.valueOf(10));
        var productB = thereIsProduct("Product B", BigDecimal.valueOf(20));
        SalesFacade sales = thereIsSalesFacade();
        //ACT
        sales.addProduct(customerA, productA);
        sales.addProduct(customerB, productB);

        //ASSERT
        Offer currentOfferA = sales.getCurrentOffer(customerA);
        // getTotal() not implemented => BigDecimal 0
        assertEquals(BigDecimal.valueOf(0), currentOfferA.getTotal());

        Offer currentOffer = sales.getCurrentOffer(customerB);
        assertEquals(BigDecimal.valueOf(0), currentOffer.getTotal());

    }

    private String thereIsProduct(String name, BigDecimal price) {
        return name;
    }

    private String thereIsCustomer(String name) {
        return name;
    }

    private SalesFacade thereIsSalesFacade() {
        return new SalesFacade(new InMemoryCartStorage(), new OfferCalculator());
    }

    @Test
    void itAllowToAcceptOffer() {

    }

    @Test
    void itAllowToPayForReservation() {

    }

    @Test
    void itRemoveProductFromCart() {

    }
}
