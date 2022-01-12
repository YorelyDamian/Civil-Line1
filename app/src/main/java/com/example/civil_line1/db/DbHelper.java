package com.example.civil_line1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/*Clase necesaria para administrar la base de datos*/
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "curvas.db";
    public static final String TABLA_SIMPLE = "t_simple";
    public static final String TABLA_ESPIRAL = "t_espiral";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*CREACION DE LAS BASES DE DATOS*/
        db.execSQL("CREATE TABLE "+TABLA_SIMPLE + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "AT TEXT NOT NULL," +
                "PI REAL NOT NULL," +
                "VP REAL NOT NULL," +
                "GC TEXT NOT NULL," +
                "direccion TEXT NOT NULL)");

        db.execSQL("CREATE TABLE "+TABLA_ESPIRAL + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "AT TEXT NOT NULL," +
                "PI REAL NOT NULL," +
                "VP REAL NOT NULL," +
                "GC TEXT NOT NULL," +
                "LE REAL NOT NULL," +
                "DC REAL NOT NULL," +
                "direccion TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
