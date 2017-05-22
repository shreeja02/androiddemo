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

public class student_custom_adapter extends BaseAdapter {
    Context mContext;
    ArrayList<student> mArrayList;
    LayoutInflater mLayoutInflater;

    public student_custom_adapter(Context mContext, ArrayList<student> mArrayList) {
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
    public View getView(int i, View view, ViewGroup parent) {
        student_view_holder mItem;
        if(view==null)
        {
            view=mLayoutInflater.inflate(R.layout.student_view_holder,null);
            mItem=new student_view_holder((TextView)view.findViewById(R.id.txtrno),(TextView)view.findViewById(R.id.txtfees),(TextView)view.findViewById(R.id.txtname));
            view.setTag(mItem);
        }
        else
        {
            mItem=(student_view_holder) view.getTag();
        }

       // mItem.txtFees.setText(mArrayList.get(i).getFees()+"");
        mItem.txtName.setText(mArrayList.get(i).getName()+"");

        return view;
    }
}
