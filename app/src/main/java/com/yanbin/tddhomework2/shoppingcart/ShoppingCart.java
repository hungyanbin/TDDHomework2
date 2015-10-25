package com.yanbin.tddhomework2.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungyanbin on 2015/10/25.
 */
public class ShoppingCart {

    private static final int BOOK_PRICE = 100;

    private List<Book> books = new ArrayList<>();

    public void order(Book book){
        books.add(book);
    }

    public int getSubtotal(){
       return books.size() * BOOK_PRICE;
    }
}
