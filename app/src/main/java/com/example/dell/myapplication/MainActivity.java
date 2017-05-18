package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,mult,div,equal,btnc,btnce,btnsin,btnlog,btnsqrt;
    TextView tv1,tv2;
    int flag=0,num1=0,num2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it=getIntent();

        tv1=(TextView)findViewById(R.id.maintextview);
        tv2= (TextView) findViewById(R.id.lblmaintv);
        tv2.setText(it.getStringExtra("name"));
        zero= (Button) findViewById(R.id.btnmain0);
        one= (Button) findViewById(R.id.btnmain1);
        two=(Button) findViewById(R.id.btnmain2);
        three=(Button) findViewById(R.id.btnmain3);
        four=(Button) findViewById(R.id.btnmain4);
        five=(Button) findViewById(R.id.btnmain5);
        six=(Button) findViewById(R.id.btnmain6);
        seven=(Button) findViewById(R.id.btnmain7);
        eight=(Button) findViewById(R.id.btnmain8);
        nine=(Button) findViewById(R.id.btnmain9);
        plus=(Button) findViewById(R.id.btnmainplus);
        minus=(Button) findViewById(R.id.btnmainminus);
        mult=(Button) findViewById(R.id.btnmainmult);
        div=(Button) findViewById(R.id.btnmaindiv);
        equal=(Button) findViewById(R.id.btnmainequal);
        btnc=(Button) findViewById(R.id.btnmainC);
        btnce=(Button) findViewById(R.id.btnmainCE);
        btnlog=(Button) findViewById(R.id.btnmainlog);
        btnsqrt=(Button) findViewById(R.id.btnmainsqrt);
        btnsin=(Button) findViewById(R.id.btnmainsin);

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText((tv1.getText()).subSequence(0,tv1.length()-1));
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tv1.getText()+""+zero.getText());
            }
        });
       one.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               tv1.setText(tv1.getText()+"1");
           }
       });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tv1.getText()+""+two.getText());
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tv1.getText()+""+three.getText());
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tv1.getText()+""+four.getText());
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tv1.getText()+""+five.getText());
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tv1.getText()+""+six.getText());
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tv1.getText()+""+seven.getText());
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tv1.getText()+""+eight.getText());
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tv1.getText()+""+nine.getText());
            }
        });
        btnsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x;
                x=Integer.parseInt(tv1.getText()+"");
                tv1.setText((Math.sqrt(x))+"");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(tv1.getText()+"");
                tv1.setText("");
                flag=1;
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(tv1.getText()+"");
                tv1.setText("");
                flag=2;
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(tv1.getText()+"");
                tv1.setText("");
                flag=3;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(tv1.getText()+"");
                tv1.setText("");
                flag=4;
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2=Integer.parseInt(tv1.getText()+"");
                if(flag==1){
                    tv1.setText((num1+num2)+"");
                }
                else if(flag==2){
                    tv1.setText((num1-num2)+"");
                }
                else if(flag==3){
                    tv1.setText((num1*num2)+"");
                }
                else
                {
                    tv1.setText((num1/num2)+"");
                }

            }
        });

    }

}
