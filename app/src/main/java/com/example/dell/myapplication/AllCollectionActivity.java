package com.example.dell.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class AllCollectionActivity extends AppCompatActivity {
    ListView collectionlst;
    ArrayList<collection> mArrayList;
    AsyncHttpClient mClient;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

       // MenuInflater inflat=getMenuInflater();
//        inflat.inflate();
        //getMenuInflater().inflate();
        menu.setHeaderTitle("Select the action");
        menu.add("Delete");
        menu.add("Edit");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final collection selectedItem=mArrayList.get(info.position);
        mClient=new AsyncHttpClient();

        if(item.getTitle()=="Delete"){

            JSONObject mJsonObject=new JSONObject();
            StringEntity entity=null;
            try {

                mJsonObject.put("description", "Inspired by science fictional depictions of arid worlds and the cultural practices that develop around water scarcity, this piece envisions a propositional social ritual that has developed in response to the growing threat of water scarcity in California. Through a combination of diegetic prototypes");
                entity=new StringEntity(mJsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            mClient.delete("https://reunirbackend.herokuapp.com/collection/"+selectedItem.getColl_id(),new JsonHttpResponseHandler(){

                ProgressDialog mProgress;

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                    mArrayList.remove(selectedItem);
                    collectionlst.setAdapter(new collection_custom_adapter(AllCollectionActivity.this,mArrayList));
                   // Toast.makeText(AllCollectionActivity.this,"Deleted",Toast.LENGTH_LONG).show();
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
                    }}

            });
            //mClient.post(LoginActivity.this,"https://reunirbackend.herokuapp.com/collection",entity,"application/json",new JsonHttpResponseHandler(){

            Toast.makeText(AllCollectionActivity.this,selectedItem.getColl_name(),Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(AllCollectionActivity.this,"Edit",Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_collection);
        collectionlst= (ListView) findViewById(R.id.listcollection);
        mArrayList=new ArrayList<collection>();

        mClient=new AsyncHttpClient();
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
               registerForContextMenu(collectionlst);


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

        collectionlst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                collection mCollection= (collection) parent.getItemAtPosition(position);
                //Toast.makeText(AllCollectionActivity.this,mCollection.getColl_name()+"",Toast.LENGTH_LONG).show();
                Intent it=new Intent(AllCollectionActivity.this,CollectionDetailActivity.class);
                it.putExtra("coll_name",mCollection.getColl_name());
                it.putExtra("coll_id",mCollection.getColl_id()+"");
                it.putExtra("date",mCollection.getDate());
                startActivity(it);


            }
        });
    }
}
