package com.example.vivekkumarsengar.database1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
//String name,phone,email,password;
Databasess db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        e4=findViewById(R.id.editText4);
        db = new Databasess(this);

    }

    public void Submit(View view) {

        String Name=e1.getText().toString();
        String   Password=e2.getText().toString();
        String  Email=e3.getText().toString();
        String Phone=e4.getText().toString();
        db.insertdata(new STUDENTINFO(Name,Password,Email,Phone));
        Toast.makeText(getApplicationContext(),"data saved",Toast.LENGTH_SHORT).show();
    }

    public void Showdata(View view) {
        startActivity(new Intent(this,Submit.class));

    }
}
