package com.example.dell.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class LoginActivity extends AppCompatActivity {
    private static final String MYPREFERENCES ="MyPrefs" ;
    String name="";
    EditText txtColl_name,txtname;
    Button btnLoginAdd,login;
    SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtColl_name= (EditText) findViewById(R.id.txtLoginColl_name);
        btnLoginAdd= (Button) findViewById(R.id.btnLoginAdd);
        login= (Button) findViewById(R.id.btnLoginStart);
        txtname= (EditText) findViewById(R.id.txtLoginName);
        sharedPreferences=getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        name=txtname.getText()+"";
                        /*editor.putString("name",name);
                        editor.commit();*/
                sharedPreferences=getApplicationContext().getSharedPreferences(MYPREFERENCES,0);
                editor=sharedPreferences.edit();
                editor.putString("uname",name);
                editor.commit();
                Intent it=new Intent(LoginActivity.this,Main2Activity.class);
                startActivity(it);
            }
        });

        btnLoginAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coll_name=txtColl_name.getText()+"";
                AsyncHttpClient mClient=new AsyncHttpClient();
                JSONObject mJsonObject=new JSONObject();
                StringEntity entity=null;
                try {
                    mJsonObject.put("coll_id","");
                    mJsonObject.put("coll_name",coll_name);
                    mJsonObject.put("profile_photo", "/images/collection/profile_photos/j12BG243759.png");
                    mJsonObject.put("cover_photo","/images/collection/cover_photos/kBtkB243759.png");
                    mJsonObject.put("date", "24/4/2017");
                    mJsonObject.put("description", "Inspired by science fictional depictions of arid worlds and the cultural practices that develop around water scarcity, this piece envisions a propositional social ritual that has developed in response to the growing threat of water scarcity in California. Through a combination of diegetic prototypes");
                    entity=new StringEntity(mJsonObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                mClient.post(LoginActivity.this,"https://reunirbackend.herokuapp.com/collection",entity,"application/json",new JsonHttpResponseHandler(){

                    ProgressDialog mProgress;

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        super.onSuccess(statusCode, headers, response);
                        Toast.makeText(LoginActivity.this,"added",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mProgress=ProgressDialog.show(LoginActivity.this,"Loading","Please Wait",true,false);

                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if(mProgress.isShowing()){
                            mProgress.dismiss();
                        }
                    }

                });
            }
        });
    }
}
