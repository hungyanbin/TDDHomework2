package com.yanbin.tddhomework2.shoppingcart;

import android.util.SparseArray;

import java.util.Set;

public class ShoppingCart {

    private BookBucket bookBucket= new BookBucket();

    public void order(Book book){
        bookBucket.putBook(book);
    }

    public int getSubtotal(){
        int subTotal = 0;

        int nextBookSetCount = bookBucket.getMinBookCount();
        while(nextBookSetCount != 0){
            float discount = getDiscountByBucketCount(bookBucket.getBucketSize());
            int bookSetPrice = getBookSetPrice(nextBookSetCount);

            subTotal +=  bookSetPrice * discount;
            nextBookSetCount = bookBucket.getMinBookCount();
        }

        return subTotal;
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
        Set<Book> bookSet = bookBucket.popBookSet(bookCount);
        for(Book book: bookSet){
            int bookPrice = book.getPrice();
            sum += bookPrice * bookCount;
        }

        return sum;
    }
}
