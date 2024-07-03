package pl.ksatora.ecommerce.sales.cart;

import java.math.BigDecimal;

public class CartItem {
    private String productId;
    private Integer qty;
    private BigDecimal productPrice;

    public CartItem(String productId, Integer qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public CartItem(String productId, Integer qty, BigDecimal productPrice) {
        this.productId = productId;
        this.qty = qty;
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return qty;
    }
}
