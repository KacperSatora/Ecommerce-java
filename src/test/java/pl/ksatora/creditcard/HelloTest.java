package pl.ksatora.creditcard;

import org.junit.jupiter.api.Test;

public class HelloTest {
    @Test
    void helloWorldTest() {
        //AAA
        //Arrange // Given
        int a = 2, b = 4;
        //Act // When
        int result = a + b;
        //Assert // Then / Expected
        assert result == 6;

    }

    @Test
    void itShowsHello() {
        String hello = "Hello Kacper";

    }
}
