package com.example.user.sqlitesharon;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;

public class secondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ListView lv;
    ArrayAdapter adp;
    String [] whichTable = {"table1", "table2"};
    SQLiteDatabase db;
    HelperDB tables;
    ArrayList<String>data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, whichTable);
        spinner.setAdapter(adp);
        spinner.setOnItemSelectedListener(this);

        lv = findViewById(R.id.lv);

        tables = new HelperDB(this);

        //showData(0);
    }

    public void showData (int position) {
        db = tables.getWritableDatabase();

        data.clear();

        Cursor c;
        if (position == 0) {
            c = db.query(Table1.TABLE_TABLE1, null, null, null, null, null, null);
            int[] col = new int[3];
            col[0] = c.getColumnIndex("_id");
            col[1] = c.getColumnIndex("NameHome");
            col[2] = c.getColumnIndex("NameGuest");

            c.moveToFirst();

            while (!c.isAfterLast()) {
                String nameHome = c.getString(col[1]);
                String nameGuest = c.getString(col[2]);

                String tmp = nameHome + ", " + nameGuest;
                data.add(tmp);

                c.moveToNext();

                adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
                lv.setAdapter(adp);
            }
        }
        else
        {
            c = db.query(Table2.TABLE_TABLE2, null, null, null, null, null, null);
            int[] col2 = new int[4];
            col2[0] = c.getColumnIndex("_id");
            col2[1] = c.getColumnIndex("NameTeam");
            col2[2] = c.getColumnIndex("NumberVictories");
            col2[3] = c.getColumnIndex("NumberLossess");

            c.moveToFirst();

            while (!c.isAfterLast()) {
                String nameTeam = c.getString(col2[1]);
                String nameVictories = c.getString(col2[2]);
                String nameLossess = c.getString(col2[3]);

                String tmp = nameTeam + ", " + nameVictories + ", " + nameLossess;
                data.add(tmp);

                c.moveToNext();

                adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
                lv.setAdapter(adp);
            }
        }
        c.close();
    }
    
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        showData(position);
        //else Toast.makeText(secondActivity.this,"please select which table data to show",Toast.LENGTH_LONG);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
            Intent intent = new Intent(this,secondActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}