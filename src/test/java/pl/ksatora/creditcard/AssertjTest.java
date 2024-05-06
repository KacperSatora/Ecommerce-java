package pl.ksatora.creditcard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertjTest {

    @Test
    void helloAssertJ() {
        var hello = "123";

        assertThat(hello).containsOnlyDigits();
    }

    @Test
    void testSomeListExpression() {
        var names = Collections.singleton("Jakub");

        assertThat(names)
                .isUnmodifiable()
                .hasSize(1)
                .containsAll(Arrays.asList("Jakub"/*, "Michal"*/));
    }
}
