package com.example.dell.myapplication;

/**
 * Created by Dell on 22-05-2017.
 */

public class student {
    int rno,fees;
    String name;

    public student(int rno, String name, int fees) {
        this.rno = rno;
        this.fees = fees;
        this.name = name;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
