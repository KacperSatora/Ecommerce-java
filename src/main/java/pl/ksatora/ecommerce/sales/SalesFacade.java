package pl.ksatora.ecommerce.sales;

import pl.ksatora.ecommerce.sales.offering.AcceptOfferRequest;
import pl.ksatora.ecommerce.sales.offering.Offer;
import pl.ksatora.ecommerce.sales.reservation.ReservationDetail;

//public class SalesFacade {
//    private inMemoryCartStorage cartStorage;
//    private OfferCalculator offerCalculator;
//
//    public Offer getCurrentOffer(String customerId) {
//        Cart cart = loadCartforCustomer(customerId);
//
//        Offer currentOffer = offerCalculator.calculate(cart.getLines());
//
//        return currentOffer;
//    }
//
//    private Cart loadCartforCustomer(String customerId) {
//        return null;
//    }
//
//    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
//        return new ReservationDetail();
//    }
//
//    public void addToCart(String customerId, String productId) {
//
//    }
//
////    public void addToCart(String customerId, String productId){
////        Cart cart = loadCartForCustomer(customerId);
////
////        cart.addProduct(productId);
////    }
////    TODO: fix
////    private Cart loadCartForCustomer(String customerId) {
////        return cartStorage.findByCustomer(customerId)
////                .orElse(Cart.empty());
////    }
//}
public class SalesFacade {
    public Offer getCurrentOffer(String customerId) {
        return new Offer();
    }

    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetail();
    }

    public void addToCart(String customerId, String productId) {

    }
}
