package com.example.dell.myapplication;

import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Dell on 22-05-2017.
 */

public class student_view_holder {
    TextView txtRno,txtFees,txtName;

    public student_view_holder(TextView txtRno, TextView txtFees, TextView txtName) {
        this.txtRno = txtRno;
        this.txtFees = txtFees;
        this.txtName = txtName;
    }

    public TextView getTxtRno() {
        return txtRno;
    }

    public void setTxtRno(TextView txtRno) {
        this.txtRno = txtRno;
    }

    public TextView getTxtFees() {
        return txtFees;
    }

    public void setTxtFees(TextView txtFees) {
        this.txtFees = txtFees;
    }

    public TextView getTxtName() {
        return txtName;
    }

    public void setTxtName(TextView txtName) {
        this.txtName = txtName;
    }
}
