package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btncalc,btnlogin,btnsignup,btnStudent,btnCollection,btnStrAdapter;
    EditText et1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudemo,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAdd:
                Toast.makeText(Main2Activity.this,"Add",Toast.LENGTH_LONG).show();
                break;

            case R.id.help:
                Toast.makeText(Main2Activity.this,"Help",Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        btncalc= (Button) findViewById(R.id.btnmain2calc);
        btnlogin= (Button) findViewById(R.id.btnmain2login);
        btnsignup= (Button) findViewById(R.id.btnmain2signup);
        btnStudent= (Button) findViewById(R.id.btnStudentDemo);
        btnCollection= (Button) findViewById(R.id.btnCollectionDemo);
        btnStrAdapter= (Button) findViewById(R.id.btnStrAdapter);
        et1= (EditText) findViewById(R.id.txtmain2demo);


        btnStrAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it5=new Intent(Main2Activity.this,StrAdapterDemo.class);
                startActivity(it5);
            }
        });

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
