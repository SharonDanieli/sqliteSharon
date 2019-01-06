package com.example.user.sqlitesharon;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static com.example.user.sqlitesharon.Table1.TABLE_TABLE1;
import static com.example.user.sqlitesharon.Table2.TABLE_TABLE2;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    HelperDB hlp;
    EditText table1et1, table1et2, table2et1, table2et2, table2et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table1et1 = findViewById(R.id.table1et1);
        table1et2 = findViewById(R.id.table1et2);
        table2et1 = findViewById(R.id.table2et1);
        table2et2 = findViewById(R.id.table2et2);
        table2et3 = findViewById(R.id.table2et3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.enterData){
            //go to the main activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if (id == R.id.showData){
            //go to the second activity
            Intent intent = new Intent(this,secondActivity.class);
            startActivity(intent);
        }

        if (id == R.id.credits){
            //go to the credits activity
            Intent intent = new Intent(this,Cradits.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    public void addData1(View view) {
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Table1.NAMEHOME, table1et1.getText().toString());
        cv.put(Table1.NAMEGUEST, table1et2.getText().toString());
        db.insert(TABLE_TABLE1, null, cv);

        db.close();
    }

    public void addData2(View view) {

        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Table2.NAMETEAM, table2et1.getText().toString());
        cv.put(Table2.NUMBERVICTORIES, table2et2.getText().toString());
        cv.put(Table2.NUMBERLOSSES, table2et3.getText().toString());
        db.insert(TABLE_TABLE2, null, cv);

        db.close();

    }
}