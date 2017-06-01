package com.example.dell.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StringAdapter extends AppCompatActivity {

    String[] countires=new String[]{
            "India","Pakistan","Bangladesh"
    };
    ListView lst1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_adapter);
        lst1= (ListView) findViewById(R.id.lstStringAdapter);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(StringAdapter.this,android.R.layout.simple_list_item_1,countires);
        lst1.setAdapter(adapter);
    }


}
