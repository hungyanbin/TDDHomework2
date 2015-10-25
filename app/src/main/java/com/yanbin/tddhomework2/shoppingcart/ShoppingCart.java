package com.yanbin.tddhomework2.shoppingcart;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Book, Integer> bookBuckets = new HashMap<>();
    private int totalBookCount = 0;

    private static final int BOOK_PRICE = 100;

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

        return totalBookCount * (int)(BOOK_PRICE * getDiscountByBucketCount(bookBucketCount));
    }

    private float getDiscountByBucketCount(int bucketCount){
        SparseArray<Float> priceTable = new SparseArray<>();
        priceTable.append(1, 1f);
        priceTable.append(2, 0.95f);
        priceTable.append(3, 0.9f);

        return priceTable.get(bucketCount);
    }
}
