package com.yanbin.tddhomework2.shoppingcart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hungyanbin on 2015/10/27.
 */
public class BookBucket {

    private Map<Book, Integer> bucketMap = new HashMap<>();

    public void putBook(Book book){
        if(bucketMap.containsKey(book)){
            int bookCount = bucketMap.get(book);
            bucketMap.put(book, bookCount + 1);
        }else {
            bucketMap.put(book, 1);
        }
    }

    public Set<Book> popBookSet(int popSize){
        Set<Book> bookSet = new HashSet<>();
        Set<Book> emptyBucket = new HashSet<>();
        for (Map.Entry<Book, Integer> bucket : bucketMap.entrySet()){
            Book book = bucket.getKey();
            int countAfterPop = bucket.getValue() - popSize;
            bookSet.add(book);

            bucketMap.put(book, countAfterPop);
            if(countAfterPop == 0)
                emptyBucket.add(book);
            else if(countAfterPop < 0)
                throw new IndexOutOfBoundsException("popSize is too large : " + popSize + ",  you should call getMinBookCount() first to check size." );
        }

        removeEmptyBucket(emptyBucket);

        return bookSet;
    }

    private void removeEmptyBucket(Set<Book> emptyBucket){
        for(Book book:emptyBucket){
            bucketMap.remove(book);
        }
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
        int minBookCount = Integer.MAX_VALUE;
        for(Integer bookCount : bucketMap.values()){
            if(bookCount < minBookCount)
                minBookCount = bookCount;
        }

        if(minBookCount == Integer.MAX_VALUE)
            return 0;

        return minBookCount;
    }

    public int getBucketSize(){
        return bucketMap.size();
    }
}
