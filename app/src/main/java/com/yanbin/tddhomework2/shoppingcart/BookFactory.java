package com.yanbin.tddhomework2.shoppingcart;

/**
 * Created by hungyanbin on 2015/10/27.
 */
public class BookFactory {

    public static Book harryPotter(int volume){
        switch(volume){
            case 1:
                return new Book("Harry Potter and the Philosopher's Stone", 100);
            case 2:
                return new Book("Harry Potter and the Chamber of Secrets", 100);
            case 3:
                return new Book("Harry Potter and the Prisoner of Azkaban", 100);
            case 4:
                return new Book("Harry Potter and the Goblet of Fire", 100);
            case 5:
                return new Book("Harry Potter and the Order of the Phoenix", 100);
        }
        throw new IllegalArgumentException("Invalid number of volume:" + volume);
    }

}
