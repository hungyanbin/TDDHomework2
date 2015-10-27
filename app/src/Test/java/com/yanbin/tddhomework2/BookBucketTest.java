package com.yanbin.tddhomework2;

import com.yanbin.tddhomework2.shoppingcart.BookBucket;
import com.yanbin.tddhomework2.shoppingcart.BookFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

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

}

