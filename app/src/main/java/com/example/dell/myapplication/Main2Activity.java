package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    Button btncalc;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btncalc= (Button) findViewById(R.id.btnmain2calc);
        et1= (EditText) findViewById(R.id.txtmain2demo);
        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Main2Activity.this,MainActivity.class);
                it.putExtra("name",et1.getText()+"");
                startActivity(it);
            }
        });
    }
}
