package com.example.dell.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 22-05-2017.
 */

public class collection_custom_adapter extends BaseAdapter {

    Context mContext;
    ArrayList<collection> mArrayList;
    LayoutInflater mLayoutInflater;

    public collection_custom_adapter(Context mContext, ArrayList<collection> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
        this.mLayoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        collection_view_holder mitem;
        if(convertView==null){

            convertView=mLayoutInflater.inflate(R.layout.collection_view_holder,null);
            mitem=new collection_view_holder((TextView) convertView.findViewById(R.id.txtcoll_name));
            convertView.setTag(mitem);
        }
        else {
            mitem= (collection_view_holder) convertView.getTag();
        }
        mitem.txtcoll_name.setText(mArrayList.get(position).getColl_name());

        return convertView;
    }
}


