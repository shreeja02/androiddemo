package com.example.dell.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

/**
 * Created by Dell on 02-06-2017.
 */

public class Splash extends Activity {
    private static final String MyPREFERENCES ="MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        int seconds = 2;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*sharedpreferences=getSharedPreferences(MyPREFERENCES,0);
                if(sharedpreferences!=null){
                String name=sharedpreferences.getString("uname",null).toString();*/
                    Intent it = new Intent(Splash.this, LoginActivity.class);
                    startActivity(it);
                    finish();
                /*}
                else
                {
                Intent it = new Intent(Splash.this, Main2Activity.class);
                startActivity(it);
                finish();
            }*/

            }
        }, seconds * 1000);
    }
}



