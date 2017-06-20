package com.example.dell.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btncalc,btnlogin,btnsignup,btnStudent,btnCollection,
            btnStrAdapter,btnLoginActive,btnLogout,btnSession,btnSharePhone;
    Button btnShareWA,btnShareFB,btnShareMail;
    private static final String MyPREFERENCES ="MyPrefs" ;
    EditText et1;
    SharedPreferences sharedpreferences ;
    SharedPreferences.Editor editor;


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
    public void onBackPressed() {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setMessage("Are you sure you want to exit?");
        alert.setCancelable(false);
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.create().show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setTitle("Home Page");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAccent)));


        btncalc= (Button) findViewById(R.id.btnmain2calc);
        btnlogin= (Button) findViewById(R.id.btnmain2login);
        btnsignup= (Button) findViewById(R.id.btnmain2signup);
        btnStudent= (Button) findViewById(R.id.btnStudentDemo);
        btnCollection= (Button) findViewById(R.id.btnCollectionDemo);
        btnStrAdapter= (Button) findViewById(R.id.btnStrAdapter);
        btnLoginActive= (Button) findViewById(R.id.btnLogin);
        btnLogout= (Button) findViewById(R.id.btnLogout);
        btnSession= (Button) findViewById(R.id.btnMain2Session);
        btnSharePhone= (Button) findViewById(R.id.btnMain2SharePhone);
        btnShareWA= (Button) findViewById(R.id.btnMain2ShareWA);
        btnShareFB= (Button) findViewById(R.id.btnMain2ShareFB);
        btnShareMail= (Button) findViewById(R.id.btnMain2ShareMAIL);
        et1= (EditText) findViewById(R.id.txtmain2demo);

        btnShareMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(Intent.ACTION_SENDTO);
                it1.setData(Uri.parse("mailto:jinalshah999@gmail.com"));
                it1.putExtra(Intent.EXTRA_SUBJECT,"how r u");
                it1.putExtra(Intent.EXTRA_TEXT,"hello");
                startActivity(it1);
            }
        });

        btnShareWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_TEXT,"This my text to send");
                it.setType("text/plain");
                startActivity(it);

            }
        });

        btnShareFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlToShare = "https://play.google.com/store/apps/details?id=com.facebook.katana&hl=en";
                try {
                    Intent mIntentFacebook = new Intent();
                    mIntentFacebook.setClassName("com.facebook.katana", "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias");
                    mIntentFacebook.setAction("android.intent.action.SEND");
                    mIntentFacebook.setType("text/plain");
                    mIntentFacebook.putExtra("android.intent.extra.TEXT", urlToShare);
                    startActivity(mIntentFacebook);
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent mIntentFacebookBrowser = new Intent(Intent.ACTION_SEND);
                    String mStringURL = "https://www.facebook.com/sharer/sharer.php?u=" + urlToShare;
                    mIntentFacebookBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(mStringURL));
                    startActivity(mIntentFacebookBrowser);
                }

            }
        });

        btnSharePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:"+"8460965787"));
                startActivity(it);

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                sharedpreferences=getApplicationContext().getSharedPreferences(MyPREFERENCES,0);
                editor=sharedpreferences.edit();
                editor.clear();
                Intent it=new Intent(Main2Activity.this,LoginActivity.class);
                startActivity(it);

            }
        });
        btnStrAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it5=new Intent(Main2Activity.this,StrAdapterDemo.class);
                startActivity(it5);
            }
        });
        btnSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpreferences=getSharedPreferences(MyPREFERENCES,0);
                String name=sharedpreferences.getString("uname",null).toString();
                Toast.makeText(Main2Activity.this,name,Toast.LENGTH_LONG).show();
            }
        });
        btnLoginActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itlogin=new Intent(Main2Activity.this,ActiveSessionActivity.class);
                startActivity(itlogin);
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
