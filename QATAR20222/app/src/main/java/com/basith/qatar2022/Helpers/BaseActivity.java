package com.basith.qatar2022.Helpers;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    ProgressDialog progress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        progress = new ProgressDialog(this);
        progress.setMessage("Loading..");
    }

    protected abstract int getLayoutResourceId();

    public void showLoader(){
        progress.show();
    }

    public void dismissLoader(){
        progress.dismiss();
    }
}
