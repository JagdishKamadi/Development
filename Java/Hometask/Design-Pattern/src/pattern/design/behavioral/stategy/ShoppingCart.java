package pattern.design.behavioral.stategy;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;

    ShoppingCart()
    {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product)
    {
        productList.add(product);
    }

    public void removeProduct(Product product)
    {
        productList.remove(product);
    }

    private double calculateTotalPrice() {
        Double reduce = productList.stream()
                .map(Product::getPrice)
                .reduce((double) 0, (a, b) -> a + b);

        return reduce;
    }

    public void payment(PaymentMethod paymentMethod)
    {
         paymentMethod.pay(calculateTotalPrice());
    }
}
