package com.yanbin.tddhomework2;

import com.yanbin.tddhomework2.shoppingcart.Book;
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
public class ShoppingCartTest {

    @Test
    public void order_1_book_subtotals_should_be_100(){
        //arrange
        ShoppingCart target = new ShoppingCart();
        Book harryPotter1 = getHarryPotter1();
        int expectSubtotal = 100;

        //act
        target.order(harryPotter1);

        //assert
        Assert.assertEquals(expectSubtotal, target.getSubtotal());
    }

    @Test
    public void order_2_different_books_subtotals_should_be_190(){
        //arrange
        ShoppingCart target = new ShoppingCart();
        Book harryPotter1 = getHarryPotter1();
        Book harryPotter2 = getHarryPotter2();
        int expectSubtotal = 190;

        //act
        target.order(harryPotter1);
        target.order(harryPotter2);

        //assert
        Assert.assertEquals(expectSubtotal, target.getSubtotal());
    }

    private Book getHarryPotter1(){
        return new Book("Harry Potter and the Philosopher's Stone");
    }

    private Book getHarryPotter2(){
        return new Book("Harry Potter and the Chamber of Secrets");
    }

}
