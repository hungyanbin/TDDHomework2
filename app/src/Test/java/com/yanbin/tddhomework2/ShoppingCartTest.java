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
        int expectSubtotal = 100;

        //act
        target.order(getHarryPotter1());

        //assert
        Assert.assertEquals(expectSubtotal, target.getSubtotal());
    }

    @Test
    public void order_2_different_books_subtotals_should_be_190(){
        //arrange
        ShoppingCart target = new ShoppingCart();
        int expectSubtotal = 190;

        //act
        target.order(getHarryPotter1());
        target.order(getHarryPotter2());

        //assert
        Assert.assertEquals(expectSubtotal, target.getSubtotal());
    }

    @Test
    public void order_3_different_books_subtotals_should_be_270(){
        //arrange
        ShoppingCart target = new ShoppingCart();
        int expectSubtotal = 270;

        //act
        target.order(getHarryPotter1());
        target.order(getHarryPotter2());
        target.order(getHarryPotter3());

        //assert
        Assert.assertEquals(expectSubtotal, target.getSubtotal());
    }

    @Test
    public void order_4_different_books_subtotals_should_be_320(){
        //arrange
        ShoppingCart target = new ShoppingCart();
        int expectSubtotal = 320;

        //act
        target.order(getHarryPotter1());
        target.order(getHarryPotter2());
        target.order(getHarryPotter3());
        target.order(getHarryPotter4());

        //assert
        Assert.assertEquals(expectSubtotal, target.getSubtotal());
    }

    @Test
    public void order_5_different_books_subtotals_should_be_375(){
        //arrange
        ShoppingCart target = new ShoppingCart();
        int expectSubtotal = 375;

        //act
        target.order(getHarryPotter1());
        target.order(getHarryPotter2());
        target.order(getHarryPotter3());
        target.order(getHarryPotter4());
        target.order(getHarryPotter5());

        //assert
        Assert.assertEquals(expectSubtotal, target.getSubtotal());
    }

    @Test
    public void order_4_books_subtotals_should_be_370(){
        //arrange
        ShoppingCart target = new ShoppingCart();
        int expectSubtotal = 375;

        //act
        target.order(getHarryPotter1());
        target.order(getHarryPotter2());
        target.order(getHarryPotter3());
        target.order(getHarryPotter3());

        //assert
        Assert.assertEquals(expectSubtotal, target.getSubtotal());
    }

    private Book getHarryPotter1(){
        return new Book("Harry Potter and the Philosopher's Stone", 100);
    }

    private Book getHarryPotter2(){
        return new Book("Harry Potter and the Chamber of Secrets", 100);
    }

    private Book getHarryPotter3(){
        return new Book("Harry Potter and the Prisoner of Azkaban", 100);
    }

    private Book getHarryPotter4(){
        return new Book("Harry Potter and the Goblet of Fire", 100);
    }

    private Book getHarryPotter5(){
        return new Book("Harry Potter and the Order of the Phoenix", 100);
    }

}
