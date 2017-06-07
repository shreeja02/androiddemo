package com.example.dell.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

/**
 * Created by Dell on 02-06-2017.
 */

public class Splash extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        int seconds = 2;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(Splash.this, Main2Activity.class);
                startActivity(it);
                finish();
            }
        }, seconds * 1000);
    }
}



