import prototype.BookShop;

import java.io.PrintStream;

public class Demo {
    private static final PrintStream OP = System.out;

    public static void main(String[] args) throws Exception {
        BookShop bookShop1 = new BookShop();
        bookShop1.setBookShopName("Gandhi Book Depo");
        bookShop1.loadData();
        OP.println(bookShop1);

        BookShop bookShop2 = bookShop1.clone();
        bookShop2.setBookShopName("Saraswati Book Demo");
        bookShop1.getBooks().remove(1);
        OP.println(bookShop1);
        OP.println(bookShop2);
    }
}