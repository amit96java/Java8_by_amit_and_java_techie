package io.amit.old.by_online.sortingusinglambda;

import java.util.Comparator;

public class MyComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o2.getName().compareTo(o1.getName());
    }
    
}
