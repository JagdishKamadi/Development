import builders.Book;
import builders.Genre;

import java.time.Year;

public class Demo {
    public static void main(String[] args) {

        Book book1 = new Book.Builder("0-12-345678-9", "Jagdish")
                .build();

        System.out.println(book1);

        Book book2 = new Book.Builder("0-12-345678-8", "Pravin")
                .genre(Genre.THRILLER)
                .author("Rajkumar Hirani")
                .published(Year.of(2021))
                .description("The book is the sailor Ishmael's narrative of the obsessive quest of "
                        + "Ahab, captain of the whaling ship Pequod, for revenge on Moby Dick, "
                        + "the giant white sperm whale that on the ship's previous voyage bit "
                        + "off Ahab's leg at the knee.")
                .build();

        System.out.println(book2);

        Book book3 = new Book.Builder("0-12-345678-7", "Madhur")
                .genre(Genre.SCI_FI)
                .author("Jagdish Kamadi")
                .build();

        System.out.println(book3);
    }
}