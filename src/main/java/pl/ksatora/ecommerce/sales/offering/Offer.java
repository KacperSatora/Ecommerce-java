package pl.ksatora.ecommerce.sales.offering;

import java.math.BigDecimal;

public class Offer {

    BigDecimal total;
    Integer itemsCount;

    public Offer(BigDecimal total, Integer itemsCount) {
        this.total = total;
        this.itemsCount = itemsCount;
    }

    public Offer() {
    }

    public BigDecimal getTotal() {
        return BigDecimal.ZERO;
    }

    public Integer getItemsCount() {
        return 0;
    }
}
