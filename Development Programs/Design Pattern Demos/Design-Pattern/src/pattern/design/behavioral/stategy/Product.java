package pattern.design.behavioral.stategy;

public class Product {
    final private String productName;
    final private String upcCode;
    final private double price;

    public Product(String productName, String upcCode, double price) {
        this.productName = productName;
        this.upcCode = upcCode;
        this.price = price;
    }

    public double getPrice()
    {
        return this.price;
    }

}
