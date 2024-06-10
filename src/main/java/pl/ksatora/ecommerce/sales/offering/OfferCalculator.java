package pl.ksatora.ecommerce.sales.offering;

import java.math.BigDecimal;

public class OfferCalculator {
    public Offer calculate(List<CartLine> lines) {
        return new Offer (
                BigDecimal.valueOf(10).multiply(new BigDecimal(lines.size())),
                lines.size()
        );
    }
}
