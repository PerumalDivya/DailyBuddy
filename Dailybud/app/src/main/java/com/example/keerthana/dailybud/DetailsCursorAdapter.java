package com.example.keerthana.dailybud;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.keerthana.dailybud.data.DetailsContract.Entry;

public class DetailsCursorAdapter extends CursorAdapter {

    public DetailsCursorAdapter(Context context, Cursor c) { super(context, c, 0); }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.findViewById(R.id.amount);
        int amountColumnIndex = cursor.getColumnIndex(Entry.COLUMN_TOTAL);
        String amount = cursor.getString(amountColumnIndex);
        textView.setText("Rs : " +amount);
    }
}
