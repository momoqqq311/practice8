package com.example.hong.practice9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.hong.practice9.R.id.fruitadd;
import static com.example.hong.practice9.R.id.parent;
import static com.example.hong.practice9.R.styleable.View;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Adapter adapter;
    Button b1;
    CheckBox cb;
    int p;
    final static int imglist[] = {R.drawable.abocado, R.drawable.cherry, R.drawable.banana,
            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};
    ArrayList<fruit_info> fruit = new ArrayList<fruit_info>();
    ArrayList<fruit_info> cartfruit = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.grid);
        b1 = (Button)findViewById(R.id.button);
        cb = (CheckBox)findViewById(R.id.checkBox);
        final fruitadd fruitadd = (fruitadd)findViewById(R.id.fruitadd);
        fruit.add(new fruit_info("abocado","1000원",0));
        fruit.add(new fruit_info("cherry","2000원",1));
        fruit.add(new fruit_info("banana","3000원",2));
        fruit.add(new fruit_info("cranberry","4000원",3));
        fruit.add(new fruit_info("grape","5000원",4));

        adapter = new gridAdapter(this,fruit);
        gridView.setAdapter((gridAdapter) adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fruitadd.setview(fruit.get(position));
                cartfruit.add(fruit.get(position));
                Toast.makeText(getApplicationContext(),
                        fruit.get(position).name+"이 카트에 담겼습니다.",Toast.LENGTH_SHORT).show();
                p=position;
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg="";
                for(int i=0; i<cartfruit.size();i++){
                    msg = msg+cartfruit.get(i).name+" ";
                }
                Toast.makeText(getApplicationContext(),"카트에 "+msg+"가 담겨있습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((gridAdapter) adapter).setCheckbox();
                ((gridAdapter) adapter).notifyDataSetChanged();
            }
        });
        fruitadd.setOnaddListener(new fruitadd.onaddListener() {
            @Override
            public void onAdd(String name, int imgno, String price) {
                if(contains(imgno)){
                    fruit.add(new fruit_info(name,price,imgno));
                    ((gridAdapter) adapter).notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(),"추가되었습니다.",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"이미 존재하는 과일입니다.",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onEdit(String name, int imgno, String price) {
                fruit.get(p).name=name;
                fruit.get(p).price=price;
                ((gridAdapter) adapter).notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"수정되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });


    }boolean contains(int imgno){
        for(int i=0;i<fruit.size();i++){
            if(imgno==fruit.get(i).imgno){
                return false;
            }
        }
        return true;
    }
}
