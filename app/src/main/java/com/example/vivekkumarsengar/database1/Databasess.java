package com.example.vivekkumarsengar.database1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Databasess extends SQLiteOpenHelper {
    public static final String DB_NAME="STUDENTINFO";
    public static final String TABLE_NAME="STUDENT";

    //Table feld
    public static final String NAME="Name";
    public static final String PASSWORD="Password";
    public static final String EMAIL="Email";
    public static final String  PHONE="Phone";
    public  static  final  String ID="id";

    public Databasess(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table  STUDENT"+"(ID Integer primary key,Name text,Password text,Email text,Phone text )");  //creating the variable using the value.

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }
public void insertdata(STUDENTINFO studentinfo)
{
    SQLiteDatabase sqLiteDatabase =getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put(NAME,studentinfo.getName());
    contentValues.put(PASSWORD,studentinfo.getPassword());
    contentValues.put(EMAIL,studentinfo.getEmail());
    contentValues.put(PHONE,studentinfo.getPhone());
    sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
}
public List<STUDENTINFO>getdata()
        {
                List<STUDENTINFO> list=new ArrayList();
                SQLiteDatabase sqLiteDatabase=getReadableDatabase() ;
                Cursor cursor= sqLiteDatabase.rawQuery("Select * from STUDENT",null);  //Return to Cursor class
                if(cursor.moveToFirst())
                {
                    do
                        {
                            STUDENTINFO studentinfo=new STUDENTINFO();
                            studentinfo.setId(Integer.parseInt(cursor.getString(0)));/*create the set id then go to the studentinfo and make variable and generate getter and setter then come here and click on bilb
                            then typecast usnig the wrapper using.*/
                            studentinfo.setName(cursor.getString(1));
                            studentinfo.setPassword(cursor.getString(2));
                            studentinfo.setEmail(cursor.getString(3));
                            studentinfo.setPhone(cursor.getString(4));
                            list.add(studentinfo);

                    }while(cursor.moveToNext());
            }
            return list;
        }
        //delete all data
    public void deleteAll()
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,null,null);

    }
    //delete single item
    public void deleteItem(STUDENTINFO studentinfo)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,ID + "=?",new String[]{String.valueOf(studentinfo.getId())});
    }

    public void updateData(STUDENTINFO studentinfo){
        SQLiteDatabase sqLiteDatabase =getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,studentinfo.getName());
        contentValues.put(PASSWORD,studentinfo.getPassword());
        contentValues.put(EMAIL,studentinfo.getEmail());
        contentValues.put(PHONE,studentinfo.getPhone());
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + "=?",new String[]{String.valueOf(studentinfo.getId())});

    }



}
