import source_class.Product;
import java.util.ArrayList;
import java.util.List;

public class GetProduct {
    public static void main(String[] args) {

        // create the list which takes the product object
        List<Product> productList = new ArrayList<>();

        // add the product values
        productList.add(new Product("Fan", 1200d, "Electrical", "Type-B"));
        productList.add(new Product("Air Conditioners", 22000d, "Electrical", "Type-A"));
        productList.add(new Product("TV", 15000d, "Electronics", "Type-A"));
        productList.add(new Product("Laptop", 32000d, "Electronics", "Type-A"));
        productList.add(new Product("Dryer", 500d, "Electrical", "Type-C"));
        productList.add(new Product("LED-Light", 100d, "Electronics", "Type-B"));
        productList.add(new Product("Bike", 82000d, "Machine", "Type-A"));
        productList.add(new Product("Earphones", 900d, "Electronics", "Type-C"));
        productList.add(new Product("Mobiles", 10000d, "Auto-Mobiles", "Type-B"));

        // call method based on price
        System.out.println("Product based on Price");
        DesiredProduct.showProductByPrice(productList);
        System.out.println();

        // call method based on category
        System.out.println("Product based on Category");
        DesiredProduct.showProductByCategory(productList);
        System.out.println();

        // call method based on Price and Category
        System.out.println("Product based on Price and Category");
        DesiredProduct.showProductByPriceAndCategory(productList);
        System.out.println();

        // call method based on  category
        System.out.println("Product count based on Category");
        DesiredProduct.showProductCountByCategory(productList);


    }
}