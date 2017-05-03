package com.example.hong.practice9;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by hong on 2017-05-03.
 */


public class GridItem extends LinearLayout {
    ImageView img;
    TextView t1,t2;

    public GridItem(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.griditem, this);
        img = (ImageView)findViewById(R.id.image);
        t1 = (TextView)findViewById(R.id.fruit_name);
        t2 = (TextView)findViewById(R.id.fruit_price);

    }

    public void setData(fruit_info one) {
        img.setImageResource(fruit_info.imglist[one.imgno]);
        t1.setText(one.name);
        t2.setText(one.price);
    }
}