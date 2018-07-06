package com.example.vivekkumarsengar.database1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class UpdateActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
Databasess databasess;
STUDENTINFO studentinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        e1=findViewById(R.id.editText5);
        e2=findViewById(R.id.editText6);
        e3=findViewById(R.id.editText7);
        e4=findViewById(R.id.editText8);
        //Get the positoin of the adapte class it is come to intnet
        int position=getIntent().getIntExtra("pos",0);
        databasess =new Databasess(this);
        List<STUDENTINFO> list = databasess.getdata();

            studentinfo =list.get(position);
            e1.setText((studentinfo.getName()));
            e2.setText((studentinfo.getPassword()));
            e3.setText((studentinfo.getEmail()));
            e4.setText((studentinfo.getPhone()));






    }

    public void update(View view) {
        String Name=e1.getText().toString();
        String Password=e2.getText().toString();
        String Email=e3.getText().toString();
        String Phone=e4.getText().toString();
        studentinfo.setName(Name);
        studentinfo.setPassword(Password);
        studentinfo.setEmail(Email);
        studentinfo.setPhone(Phone);
        databasess.updateData(studentinfo);
        startActivity(new Intent(this,Submit.class));



    }
}
