package pl.ksatora.ecommerce.sales;

import pl.ksatora.ecommerce.sales.cart.Cart;
import pl.ksatora.ecommerce.sales.cart.InMemoryCartStorage;
import pl.ksatora.ecommerce.sales.offering.AcceptOfferRequest;
import pl.ksatora.ecommerce.sales.offering.Offer;
import pl.ksatora.ecommerce.sales.offering.OfferCalculator;
import pl.ksatora.ecommerce.sales.reservation.ReservationDetail;

public class SalesFacade {

    private InMemoryCartStorage cartStorage;
    private OfferCalculator offerCalculator;

    public SalesFacade(InMemoryCartStorage cartStorage, OfferCalculator calculator) {
        this.cartStorage = cartStorage;
        this.offerCalculator = calculator;

    }

    public void addProduct(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);
        cart.addProduct(productId);
        cartStorage.save(customerId, cart);
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = loadCartForCustomer(customerId);
        return offerCalculator.calculate(cart.getItems());
    }

    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetail();
    }

    private Cart loadCartForCustomer(String customerId) {
        return cartStorage.findByCustomer(customerId)
                .orElse(Cart.empty());
    }

}
