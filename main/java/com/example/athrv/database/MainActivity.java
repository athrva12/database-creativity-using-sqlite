package com.example.athrv.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db= openOrCreateDatabase("KNSULTANPUR",MODE_PRIVATE,null);
        Toast.makeText(this,"Database..created..", Toast.LENGTH_LONG).show();


        Toast.makeText(this,"Database..created..", Toast.LENGTH_LONG).show();

        db.execSQL("create table if not exists Knit(name varchar,phone varchar)");

        Toast.makeText(this, "table created&record inserted.",Toast.LENGTH_LONG).show();
        String n="vikash";

        db.execSQL("insert into Knit values('"+n+"','12332445')");
        db.execSQL("insert into Knit values('katrina','123324235')");
        db.execSQL("insert into Knit values('ashish','14234545')");
        db.execSQL("insert into Knit values('pappu','124234545')");

        Toast.makeText(this, "table created&record inserted.",Toast.LENGTH_LONG).show();


        TableLayout t1=(TableLayout)findViewById(R.id.tableLayout1);
        TableRow tr;
        tr=(TableRow)findViewById(R.id.tabRow1);
        String q ="select * from Knit";
        Cursor c=db.rawQuery(q,null);
        String name,phone;
        while(c.moveToNext())
        {
            name=c.getString(0);
            phone=c.getString(1);
            tr=new TableRow(this);
            TextView td1=new TextView(this);
            td1.setText(name);
            TextView td2= new TextView(this);
            td2.setText(phone);
            tr.addView(td1);
            tr.addView(td2);
            t1.addView(tr);
        }
        db.close();

    }
}
