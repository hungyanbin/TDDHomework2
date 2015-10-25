package com.yanbin.tddhomework2.shoppingcart;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Book, Integer> bookBuckets = new HashMap<>();

    public void order(Book book){
        if(bookBuckets.containsKey(book)){
            int bookCount = bookBuckets.get(book);
            bookBuckets.put(book, bookCount + 1);
        }else
            bookBuckets.put(book, 1);
    }

    public int getSubtotal(){
        int bookBucketCount = bookBuckets.size();

        return (int)(getTotalBookPrice() * getDiscountByBucketCount(bookBucketCount));
    }

    private float getDiscountByBucketCount(int bucketCount){
        SparseArray<Float> priceTable = new SparseArray<>();
        priceTable.append(1, 1f);
        priceTable.append(2, 0.95f);
        priceTable.append(3, 0.9f);

        return priceTable.get(bucketCount);
    }

    private int getTotalBookPrice(){
        int sum = 0;
        for(Map.Entry<Book, Integer> bookBucket : bookBuckets.entrySet()){
            Book book = bookBucket.getKey();
            int count = bookBucket.getValue();
            int bookPrice = book.getPrice();

            sum += bookPrice * count;
        }

        return sum;
    }
}
