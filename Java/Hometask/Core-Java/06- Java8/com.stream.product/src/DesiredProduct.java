/*
   All method declare and defined here in this class
 */
import source_class.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DesiredProduct {

    // method gives the product base on price
    public static void showProductByPrice(List<Product> productList)
    {

        /*
            1) Convert into stream first
            2) apply filter
            3) and store the result
         */
        List<Product> newProductList= productList.stream()
                .filter(p->p.getPrice()>1000)
                .toList();

        // print the final product list
        System.out.println(newProductList);
    }

    // method gives the product base on category
    public static void showProductByCategory(List<Product> productList)
    {
        /*
            1) Convert into stream first
            2) apply filter
            3) and store the result
            4) Use optional to store the result
         */
        Optional<List<Product>> newProductList = Optional.ofNullable(productList.stream()
                .filter(p->p.getCategory().equals("Electronics"))
                .collect(Collectors.toList()));

        System.out.println(newProductList);
    }

    // method gives the product base on price & category
   public static void showProductByPriceAndCategory(List<Product> productList)
    {

           /* 1) Convert into stream first
            2) apply filter
            3) and store the result
            4) Use optional to store the result
            */
//        Optional<List<Product>> newProductList = Optional.of(productList.stream()
//                .filter(p-> p.getPrice() > 1000 && p.getCategory().equals("Electronics"))
//
//                .collect(Collectors.toList()));
        // This is an important part 
        List<Product> newProductList = productList.stream()
                .filter(p -> p.getPrice() > 1000 && p.getCategory().equals("Electronics"))
                .map(i ->   {
                                i.setName(i.getName().toUpperCase());
                                return i;
                            })
                .toList();

        System.out.println( newProductList);
    }

    // count the number of electronic product
    public static void showProductCountByCategory(List<Product> productList)
    {

        long count = productList.stream()
                .filter(p->p.getCategory().equals("Electronics"))
                .count();

        System.out.println(count);
    }


}
