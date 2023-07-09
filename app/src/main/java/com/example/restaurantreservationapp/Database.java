package com.example.restaurantreservationapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database {

    public static class Banco extends SQLiteOpenHelper {
        private static final String TAG = "sql";
        private static final String NAME_DATABASE = "alchemist.sqlite";
        private static final int VERSION = 1;
        public Banco(Context context){
            super(context,NAME_DATABASE,null,VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Log.d(TAG,"Creating Tables");
            sqLiteDatabase.execSQL("create table if not exists user (id integer primary key autoincrement," +
                    "name text, login text, pass text);");
            sqLiteDatabase.execSQL("create table if not exists reservation (id integer primary key autoincrement, id_user integer," +
                    "date text, hour text,"+
                    "foreign key (id_user) references user(id));");
            Log.d(TAG,"Tables created");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            //nao usaremos
        }
    }
}
