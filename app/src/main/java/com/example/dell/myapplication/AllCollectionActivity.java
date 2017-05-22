package com.example.dell.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class AllCollectionActivity extends AppCompatActivity {
    ListView collectionlst;
    ArrayList<collection> mArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_collection);
        collectionlst= (ListView) findViewById(R.id.listcollection);
        mArrayList=new ArrayList<collection>();

        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.get(AllCollectionActivity.this,"https://reunirbackend.herokuapp.com/collection/",new JsonHttpResponseHandler(){

            ProgressDialog mProgress;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {
                JSONArray mJsonArray=response;
                JSONObject mJsonObject;
                for(int i=0;i<mJsonArray.length();i++){

                        mJsonObject=mJsonArray.getJSONObject(i);
                        mArrayList.add(new collection(Integer.parseInt(mJsonObject.getString("coll_id")),mJsonObject.getString("coll_name"),mJsonObject.getString("profile_photo"),mJsonObject.getString("cover_photo"),mJsonObject.getString("date"),mJsonObject.getString("description")));

                }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                collectionlst.setAdapter(new collection_custom_adapter(AllCollectionActivity.this,mArrayList));

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onStart() {
                super.onStart();
                mProgress=ProgressDialog.show(AllCollectionActivity.this,"Loading","Please Wait",true,false);

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
}
