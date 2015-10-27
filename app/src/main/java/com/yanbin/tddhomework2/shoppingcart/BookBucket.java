package com.yanbin.tddhomework2.shoppingcart;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hungyanbin on 2015/10/27.
 */
public class BookBucket {

    private Map<Book, Integer> bucketMap = new HashMap<>();
    private int minBookCount = 0;

    public void putBook(Book book){
        if(bucketMap.containsKey(book)){
            int bookCount = bucketMap.get(book);
            bucketMap.put(book, bookCount + 1);
        }else
            bucketMap.put(book, 1);
    }

    public int getBookCount(Book book){
        for(Map.Entry<Book, Integer> bucket : bucketMap.entrySet()){
            Book currentBook = bucket.getKey();
            if(currentBook.equals(book))
                return bucket.getValue();
        }
        return 0;
    }

    public int getMinBookCount() {
        return minBookCount;
    }
}
