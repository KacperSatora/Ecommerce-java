package pl.ksatora.ecommerce.sales.offering;

import pl.ksatora.ecommerce.sales.cart.CartItem;

import java.math.BigDecimal;
import java.util.List;

public class OfferCalculator {
    public Offer calculate(List<CartItem> items) {
        BigDecimal basePrice = BigDecimal.valueOf(10); // Cena bazowa

        BigDecimal totalPrice = basePrice.multiply(new BigDecimal(items.size())); // Obliczenie całkowitej ceny

        // Obliczenie rabatu
        int productCount = items.size();
        BigDecimal discount = BigDecimal.ZERO;

        if (productCount == 2) {
            discount = totalPrice.multiply(BigDecimal.valueOf(0.20)); // 20% rabatu
        } else if (productCount >= 3) {
            discount = totalPrice.multiply(BigDecimal.valueOf(0.30)); // 30% rabatu
        }

        BigDecimal finalPrice = totalPrice.subtract(discount); // Cena końcowa po uwzględnieniu rabatu

        return new Offer(finalPrice, productCount);
    }


}
