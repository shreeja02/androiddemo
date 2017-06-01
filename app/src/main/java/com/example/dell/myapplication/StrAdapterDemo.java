package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class StrAdapterDemo extends AppCompatActivity {

ListView lstStrContentDemo;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Action");
        menu.add("Delete");
        menu.add("Edit");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle()=="Delete"){
            Toast.makeText(StrAdapterDemo.this,"Delete pressed",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(StrAdapterDemo.this,"Edit pressed",Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_str_adapter_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        lstStrContentDemo= (ListView) findViewById(R.id.lstStrContentDemo);
        String arrDemo[]=new String[]{"Het","Jinal","Thakkar","meetyo"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(StrAdapterDemo.this,android.R.layout.simple_list_item_1,arrDemo);
        lstStrContentDemo.setAdapter(arrayAdapter);


        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        registerForContextMenu(lstStrContentDemo);



    }

}
