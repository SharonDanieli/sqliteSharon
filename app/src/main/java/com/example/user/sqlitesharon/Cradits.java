package com.example.user.sqlitesharon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Cradits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cradits);
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
