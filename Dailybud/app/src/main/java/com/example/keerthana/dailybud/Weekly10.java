package com.example.keerthana.dailybud;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class Weekly10 extends AppCompatActivity implements OnClickListener {
    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    Button add,bal;
    TextView total,balance;
    String oper="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todayexp);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);
        e6 = (EditText) findViewById(R.id.e6);
        e7 = (EditText) findViewById(R.id.e7);
        e8 = (EditText) findViewById(R.id.e8);
        add = (Button) findViewById(R.id.bt1);
        bal = (Button) findViewById(R.id.bt2);
        total = (TextView) findViewById(R.id.rt1);
        balance = (TextView) findViewById(R.id.rt2);
        add.setOnClickListener(this);
        bal.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        int n1=0;
        int n2=0;
        int n3=0;
        int n4=0;
        int n5=0;
        int n6=0;
        int n7=0;
        int n8=0;

        int result=0;
        int ba=0;
        // if(TextUtils.isEmpty(e1.getText().toString()))||(TextUtils.isEmpty(e2.getText().toString()))||(TextUtils.isEmpty(e3.getText().toString()))||
        //(TextUtils.isEmpty(e4.getText().toString()))||(TextUtils.isEmpty(e5.getText().toString()))||


        n1=Integer.parseInt(e1.getText().toString());
        if(!e2.getText().toString().equals(""))
            n2=Integer.parseInt(e2.getText().toString());
        if(!e3.getText().toString().equals(""))
            n3=Integer.parseInt(e3.getText().toString());
        if(!e4.getText().toString().equals(""))
            n4=Integer.parseInt(e4.getText().toString());
        if(!e5.getText().toString().equals(""))
            n5=Integer.parseInt(e5.getText().toString());
        if(!e6.getText().toString().equals(""))
            n6=Integer.parseInt(e6.getText().toString());
        if(!e7.getText().toString().equals(""))
            n7=Integer.parseInt(e7.getText().toString());
        if(!e8.getText().toString().equals(""))
            n8=Integer.parseInt(e8.getText().toString());
        switch(v.getId())

        {
            case R.id.bt1:
                oper = "+";
                result = n2 + n3 + n3 + n4 + n5 + n6 + n7 + n8;
            case R.id.bt2:
                oper = "-";
                ba = n1 - result;
                break;

        }
        total.setText(""+result);
        balance.setText(""+ba);
    }}