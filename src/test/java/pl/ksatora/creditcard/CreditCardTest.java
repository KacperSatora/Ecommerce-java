package pl.ksatora.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void itAllowsAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1500));
        //Assert
        assertEquals(
                BigDecimal.valueOf(1500),
                card.getBalance());
    }

    @Test
    void itDenyCreditLimitBelowTreshold() {
        CreditCard card = new CreditCard();
        try {
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Exception should be raised");
        } catch (CreditBelowTresholdException e) {
            assertTrue(true);

        }
    }
}
