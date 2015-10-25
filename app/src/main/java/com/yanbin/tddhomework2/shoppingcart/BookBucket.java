package com.yanbin.tddhomework2.shoppingcart;

/**
 * Created by hungyanbin on 2015/10/25.
 */
public class BookBucket {

    private Book book;
    private int bookCount;

    public BookBucket(Book book) {
        this.book = book;
        this.bookCount = 1;
    }

    public void addBook(){
        bookCount ++;
    }

    public Book getBook() {
        return book;
    }

    public int getBookCount() {
        return bookCount;
    }
}
