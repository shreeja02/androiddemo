package com.example.dell.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AllStudentActivity extends AppCompatActivity {

    ListView lst;
    ArrayList <student> mArraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_student);
        lst= (ListView) findViewById(R.id.listStudent);
        mArraylist=new ArrayList<student>();
        mArraylist.add(new student(1,"shreeja",3000));
        mArraylist.add(new student(2,"shreenil",4000));
        mArraylist.add(new student(3,"aditi",5000));
        lst.setAdapter(new student_custom_adapter(AllStudentActivity.this,mArraylist));

    }
}
