package com.yanbin.tddhomework2.shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hungyanbin on 2015/10/25.
 */
public class ShoppingCart {

    private static final int BOOK_PRICE = 100;

    private static final int DISCOUNT_TWO_BOOKS = 95;

    private Map<Book, Integer> bookBuckets = new HashMap<>();
    private int totalBookCount = 0;

    public void order(Book book){
        if(bookBuckets.containsKey(book)){
            int bookCount = bookBuckets.get(book);
            bookBuckets.put(book, bookCount + 1);
        }else
            bookBuckets.put(book, 1);
        totalBookCount++;
    }

    public int getSubtotal(){
        int bookBucketCount = bookBuckets.size();

        if(bookBucketCount > 1)
            return totalBookCount * DISCOUNT_TWO_BOOKS;
        else    
            return totalBookCount * BOOK_PRICE;
    }
}
