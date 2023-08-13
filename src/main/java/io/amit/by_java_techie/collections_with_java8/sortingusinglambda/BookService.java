package io.amit.by_java_techie.collections_with_java8.sortingusinglambda;

import java.util.Collections;
import java.util.List;

public class BookService {
    /**
     * with conventional way
     */
//    public List<Book> getBooksinsort() {
//        List<Book> books = new BookDao().getBooks();
//
//        Collections.sort(books, new MyComparator());
//
//        return books;
//    }

    /**********************************************************************/

    /**
     * with-out MyComparator class
     */

//    public List<Book> getBooksinsort() {
//        List<Book> books = new BookDao().getBooks();
//
//        Collections.sort(books, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//        return books;
//    }

    /**********************************************************************/

    /**
     * with lambda expression.
     */

    public List<Book> getBooksinsort() {
        List<Book> books = new BookDao().getBooks();
        Collections.sort(books, ((o1, o2) -> o2.getName().compareTo(o1.getName())));
        return books;
    }
}
