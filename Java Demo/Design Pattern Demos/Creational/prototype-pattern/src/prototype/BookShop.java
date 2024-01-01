package prototype;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BookShop implements Cloneable {
    private String bookShopName;
    public List<Book> books = new ArrayList<>();

    public BookShop() {
    }

    public String getBookShopName() {
        return bookShopName;
    }

    public void setBookShopName(String bookShopName) {
        this.bookShopName = bookShopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadData() {
        IntStream.range(0, 5)
                .forEach(i -> {
                    books.add(new Book(i, "Book : " + i));
                });
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "bookShopName='" + bookShopName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public BookShop clone() throws CloneNotSupportedException {
        BookShop bookShop = new BookShop();

        for (int i = 0; i < this.getBooks().size(); i++) {
            bookShop.getBooks().add(this.books.get(i));
        }

        return bookShop;
    }
}
