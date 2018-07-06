package com.example.vivekkumarsengar.database1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Submit extends AppCompatActivity {
ListView l;
Databasess db;
ArrayList arrayList = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        l = findViewById(R.id.listview);
        db = new Databasess(this);
        List<STUDENTINFO> list = db.getdata();
      /*  if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                STUDENTINFO studentinfo = list.get(i);
                String name = studentinfo.getName();
                String Password = studentinfo.getPassword();
                String Email = studentinfo.getEmail();
                String Phone = studentinfo.getPhone();
                arrayList.add(name);
                arrayList.add(Email);
                arrayList.add(Password);
                arrayList.add(Phone);

            }
        }*/
       /* ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        l.setAdapter(arrayAdapter);
    }*/
CUSTOMLIST customlist =new CUSTOMLIST(this,list);
l.setAdapter(customlist);

    }


}
