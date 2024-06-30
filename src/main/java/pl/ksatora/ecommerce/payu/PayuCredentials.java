package pl.ksatora.ecommerce.payu;

public class PayuCredentials {
    static String clientId;
    static String clientSecret;
    boolean sandbox;

    public PayuCredentials(String clientId, String clientSecret, boolean sandbox) {
        PayuCredentials.clientId = clientId;
        PayuCredentials.clientSecret = clientSecret;
        this.sandbox = sandbox;
    }

    public static PayuCredentials sandbox(String clientId, String clientSecret) {
        return new PayuCredentials(clientId, clientSecret, true);
    }

    public static String getClientId() {
        return clientId;
    }

    public static String getClientSecret() {
        return clientSecret;
    }

    public String getBaseUrl() {
        if (sandbox) {
            return "https://secure.snd.payu.com";
        } else {
            return "https://secure.payu.com";
        }
    }
}
