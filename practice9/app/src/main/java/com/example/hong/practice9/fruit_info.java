package com.example.hong.practice9;

/**
 * Created by hong on 2017-04-27.
 */

public class fruit_info {
    final static int imglist[] = {R.drawable.abocado, R.drawable.cherry, R.drawable.banana,
            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};
    final String fruit_name[] = {"abocado", "cherry", "banana",
            "cranberry", "grape", "kiwi",
            "orange", "watermelon"};
    String name;
    String price;
    int imgno;

    public fruit_info(String name, String price, int imgno) {
        this.name = name;
        this.price = price;
        this.imgno = imgno;

    }
}
