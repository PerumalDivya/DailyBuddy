package com.example.keerthana.dailybud.data;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.keerthana.dailybud.data.DetailsContract.Entry;

public class DetailsProvider extends ContentProvider {

    public static final String LOG_TAG = DetailsProvider.class.getSimpleName();
    private static final int DETAILS = 100;
    private static final int DETAILS_ID = 101;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(DetailsContract.CONTENT_AUTHORITY, DetailsContract.PATH_DETAILS, DETAILS);
        sUriMatcher.addURI(DetailsContract.CONTENT_AUTHORITY, DetailsContract.PATH_DETAILS + "/#", DETAILS_ID);
    }

    private DbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new DbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        Cursor cursor;
        int match = sUriMatcher.match(uri);
        switch(match) {
            case DETAILS:
                cursor = database.query(Entry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case DETAILS_ID:
                selection = Entry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = database.query(Entry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot Query Known URI " +uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }


    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case DETAILS:
                return insertDetails(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " +uri);
        }
    }

    private Uri insertDetails(Uri uri, ContentValues values) {

        values.getAsInteger(Entry.COLUMN_INITIAL_AMOUNT);
        values.getAsInteger(Entry.COLUMN_FOOD);
        values.getAsInteger(Entry.COLUMN_FUEL);
        values.getAsInteger(Entry.COLUMN_ENTERTAINMENT);
        values.getAsInteger(Entry.COLUMN_FRUITS_VEGETABLES);
        values.getAsInteger(Entry.COLUMN_GROCERY);
        values.getAsInteger(Entry.COLUMN_SHOPPING);
        values.getAsInteger(Entry.COLUMN_OTHERS);
        values.getAsInteger(Entry.COLUMN_TOTAL);
        values.getAsInteger(Entry.COLUMN_BALANCE);

        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        long id = database.insert(Entry.TABLE_NAME, null, values);
        if (id == -1) {
            Log.e(LOG_TAG, "Failed to insert row for " +uri);
            return null;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case DETAILS:
                return updateDetails(uri, contentValues, selection, selectionArgs);
            case DETAILS_ID:
                selection = Entry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return updateDetails(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Updation is not supported for " +uri);
        }
    }

    private int updateDetails(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (values.containsKey(Entry.COLUMN_INITIAL_AMOUNT))
            values.getAsInteger(Entry.COLUMN_INITIAL_AMOUNT);
        if (values.containsKey(Entry.COLUMN_FOOD))
            values.getAsInteger(Entry.COLUMN_FOOD);
        if (values.containsKey(Entry.COLUMN_FUEL))
            values.getAsInteger(Entry.COLUMN_FUEL);
        if (values.containsKey(Entry.COLUMN_FOOD))
            values.getAsInteger(Entry.COLUMN_FOOD);
        if (values.containsKey(Entry.COLUMN_ENTERTAINMENT))
            values.getAsInteger(Entry.COLUMN_ENTERTAINMENT);
        if (values.containsKey(Entry.COLUMN_FRUITS_VEGETABLES))
            values.getAsInteger(Entry.COLUMN_FRUITS_VEGETABLES);
        if (values.containsKey(Entry.COLUMN_FOOD))
            values.getAsInteger(Entry.COLUMN_FOOD);
        if (values.containsKey(Entry.COLUMN_GROCERY))
            values.getAsInteger(Entry.COLUMN_GROCERY);
        if (values.containsKey(Entry.COLUMN_SHOPPING))
            values.getAsInteger(Entry.COLUMN_SHOPPING);
        if (values.containsKey(Entry.COLUMN_OTHERS))
            values.getAsInteger(Entry.COLUMN_OTHERS);
        if (values.containsKey(Entry.COLUMN_TOTAL))
            values.getAsInteger(Entry.COLUMN_TOTAL);
        if (values.containsKey(Entry.COLUMN_BALANCE))
            values.getAsInteger(Entry.COLUMN_BALANCE);
        if (values.size() == 0) {
            return 0;
        }
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        int rowsUpdated = database.update(Entry.TABLE_NAME, values, selection, selectionArgs);
        if(rowsUpdated !=0 ) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsUpdated;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        int rowsDeleted;
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case DETAILS:
                rowsDeleted = database.delete(Entry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Error in Deletion");
        }
        if(rowsDeleted != 0)
            getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }

    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case DETAILS:
                return Entry.CONTENT_LIST_TYPE;
            case DETAILS_ID:
                return Entry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri + " with match " + match);
        }
    }
}
