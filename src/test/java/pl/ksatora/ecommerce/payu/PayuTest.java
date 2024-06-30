package pl.ksatora.ecommerce.payu;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import pl.ksatora.ecommerce.catalog.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PayuTest {
    @Test
    void creatingNewPayment() {
        Payu payu = thereIsPayU();

        OrderCreateRequest orderCreateRequest = createExampleOrderCreateRequest();

        OrderCreateResponse response = payu.handle(orderCreateRequest);

        assertNotNull(response.getRedirectUri()); // Where to redirect customer
        assertNotNull(response.getOrderId()); // transaction id
    }

    private OrderCreateRequest createExampleOrderCreateRequest() {
        OrderCreateRequest createRequest = new OrderCreateRequest();
        createRequest
                .setNotifyUrl("https://my.example.shop.ksatora.pl/api/order")
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("300746")
                .setDescription("My ebook")
                .setCurrencyCode("PLN")
                .setTotalAmount(21000)
                .setExtOrderId(UUID.randomUUID().toString())
                .setBuyer((new Buyer())
                        .setEmail("john.doe.example.com")
                        .setFirstName("John").setLastName("Doe")
                        .setLanguage("pl")
                )
                .setProducts(Arrays.asList(new Product()
                        .setId("")
                        .setPrice(BigDecimal.valueOf(0))
                        .setName("")
                        .setDescription("")
                ));
        return  createRequest;
    }

    private Payu thereIsPayU() {
        return new Payu(new RestTemplate(), PayuCredentials.sandbox("123", "456"));
    }

//    {
//        "notifyUrl": "https://your.eshop.com/notify",
//            "customerIp": "127.0.0.1",
//            "merchantPosId": "145227",
//            "description": "RTV market",
//            "currencyCode": "PLN",
//            "totalAmount": "21000",
//            "extOrderId":"2uikc6gjd99b4lxc75ip4k",
//            "buyer": {
//        "email": "john.doe@example.com",
//                "phone": "654111654",
//                "firstName": "John",
//                "lastName": "Doe",
//                "language": "pl"
//    },
//        "products": [
//        {
//            "name": "Wireless Mouse for Laptop",
//                "unitPrice": "15000",
//                "quantity": "1"
//        },
//        {
//            "name": "HDMI cable",
//                "unitPrice": "6000",
//                "quantity": "1"
//        }
//        ]
//    }


}
