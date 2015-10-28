package com.yanbin.tddhomework2;

import com.yanbin.tddhomework2.shoppingcart.Book;
import com.yanbin.tddhomework2.shoppingcart.BookBucket;
import com.yanbin.tddhomework2.shoppingcart.BookFactory;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hungyanbin on 2015/10/27.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(manifest = "app/src/main/AndroidManifest.xml", constants = BuildConfig.class, sdk = 21)
public class BookBucketTest {

    @Test
    public void putBook_harryPotter_1_1_2_should_have_2_harryPotter1(){
        //arrange
        BookBucket target = new BookBucket();
        int expectBookCount = 2;

        //act
        target.putBook(BookFactory.harryPotter(1));
        target.putBook(BookFactory.harryPotter(1));
        target.putBook(BookFactory.harryPotter(2));

        //assert
        Assert.assertEquals(expectBookCount, target.getBookCount(BookFactory.harryPotter(1)));
    }

    @Test
    public void putBook_harryPotter_3_2_2_3_1_minBookCount_should_be_1(){
        //arrange
        BookBucket target = new BookBucket();
        int expectMinBookCount = 1;

        //act
        target.putBook(BookFactory.harryPotter(3));
        target.putBook(BookFactory.harryPotter(2));
        target.putBook(BookFactory.harryPotter(2));
        target.putBook(BookFactory.harryPotter(3));
        target.putBook(BookFactory.harryPotter(1));

        //assert
        Assert.assertEquals(expectMinBookCount, target.getMinBookCount());
    }

    @Test
    public void putBook_harryPotter_3_2_1_3_bucketSize_should_be_3(){
        //arrange
        BookBucket target = new BookBucket();
        int expectBucketSize = 3;

        //act
        target.putBook(BookFactory.harryPotter(3));
        target.putBook(BookFactory.harryPotter(2));
        target.putBook(BookFactory.harryPotter(1));
        target.putBook(BookFactory.harryPotter(3));

        //assert
        Assert.assertEquals(expectBucketSize, target.getBucketSize());
    }

    @Test
    public void putBook_harryPotter_2_2_1_popBookSet_should_have_harryPotter_1_2(){
        //arrange
        BookBucket target = new BookBucket();
        Set<Book> expectBookSet = new HashSet<>();
        expectBookSet.add(BookFactory.harryPotter(1));
        expectBookSet.add(BookFactory.harryPotter(2));

        //act
        target.putBook(BookFactory.harryPotter(2));
        target.putBook(BookFactory.harryPotter(2));
        target.putBook(BookFactory.harryPotter(1));
        Set<Book> actualBookSet = target.popBookSet(1);

        //assert
        Assert.assertEquals(expectBookSet, actualBookSet);
    }

    @Test
    public void popBookSet_bucketSize_should_change_from_2_to_1(){
        BookBucket target = new BookBucket();
        int expectOriginalSize = 2;
        int expectBucketSizeAfterPop = 1;
        target.putBook(BookFactory.harryPotter(2));
        target.putBook(BookFactory.harryPotter(2));
        target.putBook(BookFactory.harryPotter(1));

        Assert.assertEquals(expectOriginalSize, target.getBucketSize());

        target.popBookSet(1);

        Assert.assertEquals(expectBucketSizeAfterPop, target.getBucketSize());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void over_popBookSet_should_catch_IndexOutOfBoundsException(){
        BookBucket target = new BookBucket();
        target.putBook(BookFactory.harryPotter(3));
        target.putBook(BookFactory.harryPotter(3));
        target.putBook(BookFactory.harryPotter(2));
        target.putBook(BookFactory.harryPotter(1));

        target.popBookSet(1);
    }
}

