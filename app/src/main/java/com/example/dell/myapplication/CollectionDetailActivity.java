package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CollectionDetailActivity extends AppCompatActivity {
    TextView txtColl_id,txtColl_name,txtColl_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_detail);
        txtColl_id= (TextView) findViewById(R.id.CollectionDetailtxtColl_id);
        txtColl_name= (TextView) findViewById(R.id.CollectionDetailtxtColl_name);
        txtColl_date= (TextView) findViewById(R.id.CollectionDetailtxtColl_date);

        Intent it=getIntent();
        String name=it.getStringExtra("coll_name");
        String id=it.getStringExtra("coll_id");
        String date=it.getStringExtra("date");
        txtColl_id.setText(id);
        txtColl_name.setText(name);
        txtColl_date.setText(date);


    }
}
