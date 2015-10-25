package com.yanbin.tddhomework2.shoppingcart;

/**
 * Created by hungyanbin on 2015/10/25.
 */
public class Book {

    private String bookName;
    private int price;

    public Book(String bookName, int price){
        this.bookName = bookName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (price != book.price) return false;
        return bookName.equals(book.bookName);

    }

    @Override
    public int hashCode() {
        int result = bookName.hashCode();
        result = 31 * result + price;
        return result;
    }
}
