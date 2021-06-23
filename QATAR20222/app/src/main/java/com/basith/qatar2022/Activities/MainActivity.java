package com.basith.qatar2022.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.basith.qatar2022.Activities.DashboardActivity.DashboardActivity;
import com.basith.qatar2022.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                myTask();
            }
        }, 1000);
    }

    public void myTask(){
        Intent i = new Intent(MainActivity.this, DashboardActivity.class);
        startActivity(i);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        myTask();
    }
}