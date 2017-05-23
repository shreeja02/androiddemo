package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    Button btncalc,btnlogin,btnsignup,btnStudent,btnCollection;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btncalc= (Button) findViewById(R.id.btnmain2calc);
        btnlogin= (Button) findViewById(R.id.btnmain2login);
        btnsignup= (Button) findViewById(R.id.btnmain2signup);
        btnStudent= (Button) findViewById(R.id.btnStudentDemo);
        btnCollection= (Button) findViewById(R.id.btnCollectionDemo);
        et1= (EditText) findViewById(R.id.txtmain2demo);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Main2Activity.this,MainActivity.class);
                it.putExtra("name",et1.getText()+"");
                startActivity(it);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(it1);
            }
        });

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2=new Intent(Main2Activity.this,AllStudentActivity.class);
                startActivity(it2);
            }
        });
        btnCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it3=new Intent(Main2Activity.this,AllCollectionActivity.class);
                startActivity(it3);
            }
        });

    }
}
