package com.example.keerthana.dailybud;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.keerthana.dailybud.data.DetailsContract.Entry;

public class Todayexp extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, OnClickListener {

    private static final int EXISTING_LOADER = 0;
    private Uri mCurrentUri;
    private EditText e1,e2,e3,e4,e5,e6,e7,e8;
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
    Button add,bal,save;
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
        save = (Button) findViewById(R.id.but11);
        add.setOnClickListener(this);
        bal.setOnClickListener(this);

        Intent intent = getIntent();
        mCurrentUri = intent.getData();
        if (mCurrentUri != null)
            getLoaderManager().initLoader(EXISTING_LOADER, null, this);
    }
public void onClick(View v)
{



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
             result = n2 + n3 + n3 + n4  + n5 + n6 + n7 + n8;
        case R.id.bt2:
            oper = "-";
             ba = n1 - result;
            break;
    }
    total.setText(""+result);
    balance.setText(""+ba);

    save.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            ContentValues values = new ContentValues();
            values.put(Entry.COLUMN_INITIAL_AMOUNT,n1);
            values.put(Entry.COLUMN_FOOD,n2);
            values.put(Entry.COLUMN_FUEL,n3);
            values.put(Entry.COLUMN_ENTERTAINMENT,n4);
            values.put(Entry.COLUMN_FRUITS_VEGETABLES,n5);
            values.put(Entry.COLUMN_GROCERY,n6);
            values.put(Entry.COLUMN_SHOPPING,n7);
            values.put(Entry.COLUMN_OTHERS,n8);
            values.put(Entry.COLUMN_TOTAL,result);
            values.put(Entry.COLUMN_BALANCE,ba);
            if (mCurrentUri == null) {
                Uri newUri = getContentResolver().insert(Entry.CONTENT_URI, values);
                if (newUri == null)
                {
                    Toast.makeText(Todayexp.this, "Error in Saving", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Todayexp.this, "Details Saved", Toast.LENGTH_SHORT).show();
                }
            }

        }
    });
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data == null || data.getCount() < 1) {
            return;
        }
        if(data.moveToFirst()) {
            int initialAmtIndex = data.getColumnIndex(Entry.COLUMN_INITIAL_AMOUNT);
            int foodIndex = data.getColumnIndex(Entry.COLUMN_FOOD);
            int fuelIndex = data.getColumnIndex(Entry.COLUMN_FUEL);
            int entertainmentIndex = data.getColumnIndex(Entry.COLUMN_ENTERTAINMENT);
            int fruitsIndex = data.getColumnIndex(Entry.COLUMN_FRUITS_VEGETABLES);
            int groceryIndex = data.getColumnIndex(Entry.COLUMN_GROCERY);
            int shoppingIndex = data.getColumnIndex(Entry.COLUMN_SHOPPING);
            int othersIndex = data.getColumnIndex(Entry.COLUMN_OTHERS);
            int totalIndex = data.getColumnIndex(Entry.COLUMN_TOTAL);
            int balanceIndex = data.getColumnIndex(Entry.COLUMN_BALANCE);

            int initialAmt = data.getInt(initialAmtIndex);
            int food = data.getInt(foodIndex);
            int fuel = data.getInt(fuelIndex);
            int entertainment = data.getInt(entertainmentIndex);
            int fruits  = data.getInt(fruitsIndex);
            int grocery = data.getInt(groceryIndex);
            int shopping = data.getInt(shoppingIndex);
            int others = data.getInt(othersIndex);
            int totalAmt = data.getInt(totalIndex);
            int balanceAmt = data.getInt(balanceIndex);

            e1.setText(initialAmt);
            e2.setText(food);
            e3.setText(fuel);
            e4.setText(entertainment);
            e5.setText(fruits);
            e6.setText(grocery);
            e7.setText(shopping);
            e8.setText(others);
            total.setText(totalAmt);
            balance.setText(balanceAmt);

        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
        e7.setText("");
        e8.setText("");
    }
}