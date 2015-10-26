package com.yanbin.tddhomework2.shoppingcart;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        int subTotal = 0;

        int nextBookSetCount = getNextBookSetCount();
        while(nextBookSetCount != Integer.MAX_VALUE){
            float discount = getDiscountByBucketCount(bookBuckets.size());
            int bookSetPrice = getBookSetPrice(nextBookSetCount);

            subTotal +=  bookSetPrice * discount;
            nextBookSetCount = getNextBookSetCount();
        }

        return subTotal;
    }

    private int getNextBookSetCount(){
        int minBookCount = Integer.MAX_VALUE;
        for(Integer bookCount:bookBuckets.values()){
            if(bookCount < minBookCount)
                minBookCount = bookCount;
        }
        return minBookCount;
    }

    private float getDiscountByBucketCount(int bucketCount){
        SparseArray<Float> priceTable = new SparseArray<>();
        priceTable.append(1, 1f);
        priceTable.append(2, 0.95f);
        priceTable.append(3, 0.9f);
        priceTable.append(4, 0.8f);
        priceTable.append(5, 0.75f);

        return priceTable.get(bucketCount);
    }

    private int getBookSetPrice(int bookCount){
        int sum = 0;
        List<Book> emptyBooks = new ArrayList<>();
        for(Map.Entry<Book, Integer> bookBucket : bookBuckets.entrySet()){
            Book book = bookBucket.getKey();
            int count = bookBucket.getValue();

            int bookPrice = book.getPrice();
            int restCount = count - bookCount;
            //do not calculate empty bucket
            if(restCount == 0)
                emptyBooks.add(book);

            bookBuckets.put(book, restCount);
            sum += bookPrice * bookCount;
        }

        for(int i=0;i<emptyBooks.size();i++)
            bookBuckets.remove(emptyBooks.get(i));

        return sum;
    }
}
