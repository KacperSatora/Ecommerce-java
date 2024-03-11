package pl.ksatora.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal creditLimit;

    public void assignCredit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
        try {

        } catch (Exception exception) {

        }
    }

    public BigDecimal getBalance() {
        return creditLimit;
    }
}
