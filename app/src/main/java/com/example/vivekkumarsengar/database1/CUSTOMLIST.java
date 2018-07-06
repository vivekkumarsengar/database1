package com.example.vivekkumarsengar.database1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CUSTOMLIST extends BaseAdapter {
    List<STUDENTINFO> list;
    Context context;
    public CUSTOMLIST(Submit submit, List<STUDENTINFO> list) {
        this.list=list;
        this.context=submit;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.custom,null);
        TextView tv1=view.findViewById(R.id.textView6);
        TextView tv2=view.findViewById(R.id.textView7);
        TextView tv3=view.findViewById(R.id.textView8);
        TextView tv4=view.findViewById(R.id.textView9);
        final STUDENTINFO studentinfo=list.get(i);  //get the list position and assign into class.
        tv1.setText(studentinfo.getName());
        tv2.setText(studentinfo.getPassword());
        tv3.setText(studentinfo.getEmail());
        tv4.setText(studentinfo.getPhone());
        ImageView view1=view.findViewById(R.id.imageView1);// edit purpose
        ImageView view2=view.findViewById(R.id.imageView);//delete Purpose
        final Databasess databasess =new Databasess(context);//this is not there
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,UpdateActivity.class);
                intent.putExtra("pos",i);
                context.startActivity(intent);


            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasess.deleteItem(studentinfo);
                Toast.makeText(context,"delete succes",Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }
}
