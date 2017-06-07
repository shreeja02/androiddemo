package com.example.dell.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class EditTextOnSamePage extends AppCompatActivity {
    EditText ed;
    Button btn1;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ed= (EditText) findViewById(R.id.lblEditTextOnSamePage);
        btn1= (Button) findViewById(R.id.btnEditDemo);
        ed.setVisibility(View.INVISIBLE);
        btn1.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_on_same_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ed= (EditText) findViewById(R.id.lblEditTextOnSamePage);
        btn1= (Button) findViewById(R.id.btnEditDemo);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
              ed.setVisibility(view.VISIBLE);
                btn1.setVisibility(view.VISIBLE);
                ed.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final AlertDialog.Builder alert=new AlertDialog.Builder(EditTextOnSamePage.this);
                        alert.setMessage(ed.getText()+"");
                        alert.setCancelable(false);
                        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alert.create().show();
                    }
                });
            }

        });

    }

}
