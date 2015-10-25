package com.yanbin.tddhomework2.shoppingcart;

/**
 * Created by hungyanbin on 2015/10/25.
 */
public class Book {

    private String bookName;

    public Book(String bookName){
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return bookName.equals(book.bookName);

    }

    @Override
    public int hashCode() {
        return bookName.hashCode();
    }
}
