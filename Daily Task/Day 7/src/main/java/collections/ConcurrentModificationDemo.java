
package collections;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ConcurrentModificationDemo {

    public static void main(String[] args) {

        List<String> books = new ArrayList<>(
                List.of("Java", "DBMS", "Spring Boot")
        );

        System.out.println("Original books: " + books);

        try {
            for (String book : books) {
                System.out.println("Reading: " + book);

                if (book.equals("Java")) {
                    books.remove(book);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException occurred!");
            System.out.println(
                    "Use Iterator.remove() to remove elements safely."
            );
        }

        System.out.println("Final books: " + books);
    }
}
