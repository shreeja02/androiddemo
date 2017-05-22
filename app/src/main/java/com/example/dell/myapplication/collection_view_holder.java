package com.example.dell.myapplication;

import android.widget.TextView;

/**
 * Created by Dell on 22-05-2017.
 */

public class collection_view_holder {

    TextView txtcoll_name;

    public TextView getTxtcoll_name() {
        return txtcoll_name;
    }

    public void setTxtcoll_name(TextView txtcoll_name) {
        this.txtcoll_name = txtcoll_name;
    }

    public collection_view_holder(TextView txtcoll_name) {
        this.txtcoll_name = txtcoll_name;
    }
}
