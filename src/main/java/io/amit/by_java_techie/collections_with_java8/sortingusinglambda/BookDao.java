package io.amit.by_java_techie.collections_with_java8.sortingusinglambda;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(101,"core java",400));
        books.add(new Book(102,"hibernate",180));
        books.add(new Book(103,"spring",200));
        books.add(new Book(104,"webservices",300));
        return books;
    }
}
