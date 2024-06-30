package pl.ksatora.ecommerce.sales;

import pl.ksatora.ecommerce.sales.cart.Cart;
import pl.ksatora.ecommerce.sales.cart.CartStorage;
import pl.ksatora.ecommerce.sales.offering.AcceptOfferRequest;
import pl.ksatora.ecommerce.sales.offering.Offer;
import pl.ksatora.ecommerce.sales.offering.OfferCalculator;
import pl.ksatora.ecommerce.sales.reservation.ReservationDetail;

public class SalesFacade {
    private CartStorage cartStorage;
    private OfferCalculator offerCalculator;

    public SalesFacade(CartStorage cartStorage, OfferCalculator offerCalculator) {
        this.cartStorage = cartStorage;
        this.offerCalculator = offerCalculator;
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = cartStorage.loadForCustomer(customerId).orElse(Cart.empty());

        return offerCalculator.calculate(cart.getItems());
    }

    public void addProduct(String customerId, String productId) {
        Cart cart = cartStorage.loadForCustomer(customerId).orElse(Cart.empty());

        cart.addProduct(productId);
    }

    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetail();
    }


}
