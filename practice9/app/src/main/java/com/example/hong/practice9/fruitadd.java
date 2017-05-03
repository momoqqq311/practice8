package com.example.hong.practice9;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hong on 2017-05-03.
 */

public class fruitadd extends LinearLayout {

    AutoCompleteTextView autotv;
    Button b1, b2;
    ImageView image;
    EditText et;
    int imgno = 0;

    public fruitadd(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fruitadd, this);
        b1 = (Button) findViewById(R.id.next);
        b2 = (Button) findViewById(R.id.add);
        image = (ImageView) findViewById(R.id.image);
        autotv = (AutoCompleteTextView)findViewById(R.id.fruit_name);
        et = (EditText)findViewById(R.id.fruit_price);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgno = imgno + 1;
                if (imgno == fruit_info.imglist.length) {
                    imgno = 0;
                }
                image.setImageResource(fruit_info.imglist[imgno]);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b2.getText().toString().equals("M")) {
                    onaddListener.onEdit(autotv.getText().toString(),imgno,et.getText().toString());
                    b2.setText("add");
                }else{
                    onaddListener.onAdd(autotv.getText().toString(),imgno,et.getText().toString());
                }
            }
        });
    }
    void setview(fruit_info one) {
        b2.setText("M");
        autotv.setText(one.name);
        et.setText(one.price);
        image.setImageResource(fruit_info.imglist[one.imgno]);
        imgno=one.imgno;
    }
    interface onaddListener{
        void onAdd(String name, int imgno, String price);
        void onEdit(String name, int imgno,String price);
    }
    public onaddListener onaddListener;

    public void setOnaddListener(onaddListener onaddListener){
        this.onaddListener = onaddListener;
    }
}
