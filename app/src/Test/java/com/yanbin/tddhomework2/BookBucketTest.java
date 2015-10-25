package com.yanbin.tddhomework2;

import com.yanbin.tddhomework2.shoppingcart.Book;
import com.yanbin.tddhomework2.shoppingcart.BookBucket;
import com.yanbin.tddhomework2.shoppingcart.ShoppingCart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by hungyanbin on 2015/10/25.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(manifest = "app/src/main/AndroidManifest.xml", constants = BuildConfig.class, sdk = 21)
public class BookBucketTest {

    @Test
    public void init_bookBucket_bookCount_should_be_1(){
        //arrange
        int expectBookCount = 1;
        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone");

        //act
        BookBucket target = new BookBucket(harryPotter1);

        //assert
        Assert.assertEquals(expectBookCount, target.getBookCount());
    }

    @Test
    public void addBook_2_times_bookCount_should_be_3(){
        //arrange
        int expectBookCount = 3;
        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone");

        //act
        BookBucket target = new BookBucket(harryPotter1);
        target.addBook();
        target.addBook();

        //assert
        Assert.assertEquals(expectBookCount, target.getBookCount());
    }
}
