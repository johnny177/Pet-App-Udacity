package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String TEXT_TYPE2 = " INTEGER";
    private static final String COMMA = ", ";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+ PetEntry.TABLE_NAME + " (" + PetEntry.COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    PetEntry.COLUMN_PET_NAME + TEXT_TYPE +" NOT NULL" +COMMA +
                    PetEntry.COLUMN_PET_BREED + TEXT_TYPE +COMMA +
                    PetEntry.COLUMN_PET_GENDER +TEXT_TYPE2+" NOT NULL" +COMMA +
                    PetEntry.COLUMN_PET_WEIGHT  + TEXT_TYPE2 +" NOT NULL DEFAULT 0 )";



    public PetDbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);

    }
}
