package pattern.design.behavioral.stategy;

import java.util.Arrays;
import java.util.List;

public class PaymentTest {
    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product("Milk","123",50d));
        shoppingCart.addProduct(new Product("Sugar","126",40d));
        shoppingCart.addProduct(new Product("Kaju","12",820d));

        shoppingCart.payment(new PhonePay("Jagdish Kamadi","jagadishkamadi@gmail.com","Jagdish@99"));

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.addProduct(new Product("Soap","156",120));
        shoppingCart1.addProduct(new Product("Shampoo","189",100));
        shoppingCart1.payment(new Creditcard("Jagdish Kamadi","2364 1615 4907 8888","235","23/12/26"));
    }
}
