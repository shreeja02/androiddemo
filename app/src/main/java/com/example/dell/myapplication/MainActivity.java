package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,mult,div,equal,btnc,btnce,btnsin,btnlog,btnsqrt;
    TextView tv1,tv2;
    ToggleButton toggle;
    RadioGroup rg;
    int flag=0,num1=0,num2=0;
   /* public void onRadioButtonClicked(View view) {
    boolean checked=((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radiomainscientific:
                if(checked)
                    btnlog.setVisibility(view.VISIBLE);
                    btnsin.setVisibility(view.VISIBLE);
                    btnsqrt.setVisibility(view.VISIBLE);
                    break;
            case R.id.radiomainsimple:
                if(checked)
                    btnlog.setVisibility(view.INVISIBLE);
                     btnsin.setVisibility(view.INVISIBLE);
                    btnsqrt.setVisibility(view.INVISIBLE);
        }
    }*/
   public void onToggleClicked(View view) {
       // Is the toggle on?
       boolean on = ((ToggleButton) view).isChecked();

       if (on) {
           btnlog.setVisibility(view.VISIBLE);
           btnsin.setVisibility(view.VISIBLE);
           btnsqrt.setVisibility(view.VISIBLE);
       } else {
           btnlog.setVisibility(view.INVISIBLE);
           btnsin.setVisibility(view.INVISIBLE);
           btnsqrt.setVisibility(view.INVISIBLE);
       }
   }
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

        toggle= (ToggleButton) findViewById(R.id.togglemain);



        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText((tv1.getText()).subSequence(0,tv1.length()-1));
            }
        });
        btnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("");
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
                double x,y;
                x= Double.parseDouble(tv1.getText() + "");
                y=Math.sqrt(x);
                String ans=String.format("%.2f",y);
                tv1.setText(ans);
            }
        });
        btnsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double x,y;
                x= Double.parseDouble(tv1.getText() + "");
                y=Math.sin(x);
                String ans=String.format("%.2f",y);
                tv1.setText(ans);
            }
        });
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double x,y;
                x= Double.parseDouble(tv1.getText() + "");
                y=Math.log(x);
                String ans=String.format("%.2f",y);
                tv1.setText(ans);
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
