package pl.ksatora.creditcard;

public class Main {
    public static void main(String[] args) {

        String name = "Kacper";
        double digit = 2.2;

        greet(name);
    }

    static void greet(String name) {
        System.out.printf(String.format("Hello %s", name));
    }
}