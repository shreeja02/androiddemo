package com.example.dell.myapplication;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Dell on 22-05-2017.
 */

public class collection_view_holder {

    TextView txtcoll_name;
    ImageView imgProfile_photo;

    public TextView getTxtcoll_name() {
        return txtcoll_name;
    }

    public ImageView getImgProfile_photo() {
        return imgProfile_photo;
    }

    public void setImgProfile_photo(ImageView imgProfile_photo) {
        this.imgProfile_photo = imgProfile_photo;
    }

    public collection_view_holder(TextView txtcoll_name, ImageView imgProfile_photo) {
        this.txtcoll_name = txtcoll_name;
        this.imgProfile_photo = imgProfile_photo;
    }

    public void setTxtcoll_name(TextView txtcoll_name) {
        this.txtcoll_name = txtcoll_name;
    }


}
