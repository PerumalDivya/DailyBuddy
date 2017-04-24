package com.example.keerthana.dailybud.data;

import android.net.Uri;
import android.content.ContentResolver;
import android.provider.BaseColumns;

public class DetailsContract {
    private DetailsContract() {}
    public static final String CONTENT_AUTHORITY = "com.example.keerthana.dailybud";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_DETAILS = "details";
    public static final class Entry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_DETAILS);
        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DETAILS;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DETAILS;
        public static final String TABLE_NAME = "daily";
        public static final String _ID = BaseColumns._ID;
        public final static String COLUMN_INITIAL_AMOUNT = "initialAmt";
        public final static String COLUMN_FOOD = "food";
        public final static String COLUMN_FUEL = "fuel";
        public final static String COLUMN_ENTERTAINMENT = "entertainment";
        public final static String COLUMN_FRUITS_VEGETABLES = "fruits";
        public final static String COLUMN_GROCERY = "grocery";
        public final static String COLUMN_SHOPPING = "shopping";
        public final static String COLUMN_OTHERS = "others";
        public final static String COLUMN_TOTAL = "total";
        public final static String COLUMN_BALANCE = "balance";
    }
}
