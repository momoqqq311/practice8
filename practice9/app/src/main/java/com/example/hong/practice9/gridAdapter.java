package com.example.hong.practice9;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by hong on 2017-04-27.
 */

public class gridAdapter extends BaseAdapter {
    final static int imglist[] = {R.drawable.abocado, R.drawable.cherry, R.drawable.banana,
            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};
    Context context;
    ArrayList<fruit_info> fruit;
    boolean checkbox = false;

    public gridAdapter(Context context, ArrayList<fruit_info> fruit) {
        this.context = context;
        this.fruit = fruit;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int position) {
        return fruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = new GridItem(context);
        }
        ((GridItem)convertView).setData(fruit.get(position));
        TextView t1 = (TextView) ((GridItem)convertView).findViewById(R.id.fruit_name);
        TextView t2 = (TextView) ((GridItem)convertView).findViewById(R.id.fruit_price);
        if(checkbox){
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
        }else{
            t1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }public void setCheckbox(){
        if(checkbox){
            checkbox=false;
        }else{
            checkbox=true;
        }
    }

}
