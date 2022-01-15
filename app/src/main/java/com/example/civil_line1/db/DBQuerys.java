package com.example.civil_line1.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.civil_line1.view.HorizontalHistory;
import com.example.civil_line1.view.SpiralHistory;

import java.util.ArrayList;

import model.Espiral;
import model.HorizontalSimple;

public class DBQuerys {

    public ArrayList<HorizontalSimple> buscarHorizontal(Context cntx) {
        ArrayList<HorizontalSimple> listaCurvas = new ArrayList<HorizontalSimple>();
        DbHelper admin = new DbHelper(cntx);
        SQLiteDatabase baseDeDatos = admin.getReadableDatabase();
        HorizontalSimple curva = null;
        /*Consulta de la tabla 'SELECT * FROM t_simple;'*/
        Cursor sqlOut = baseDeDatos.rawQuery("SELECT * FROM "+admin.TABLA_SIMPLE,null);

        /*Recorremos la salida de la consulta, lo guardamos en un objeto de la curva y agregamos a la listaCurvas*/
        while (sqlOut.moveToNext()){
            curva = new HorizontalSimple();
            curva.setId(sqlOut.getInt(0));
            curva.setNombre(sqlOut.getString(1));
            curva.setAT(sqlOut.getString(2));
            curva.setPuntoInter(sqlOut.getDouble(3));
            curva.setVelocProy(sqlOut.getDouble(4));
            curva.setGC(sqlOut.getString(5));
            curva.setDireccion(sqlOut.getString(6));
            listaCurvas.add(curva);
        }
        baseDeDatos.close();
        return listaCurvas;
    }
    public ArrayList<Espiral> buscarEspiral(Context cntx){
        ArrayList<Espiral> listaCurvas = new ArrayList<Espiral>();
        DbHelper admin = new DbHelper(cntx);
        SQLiteDatabase baseDeDatos = admin.getReadableDatabase();
        Espiral curva = null;
        /*Consulta de la tabla 'SELECT * FROM t_simple;'*/
        Cursor sqlOut = baseDeDatos.rawQuery("SELECT * FROM "+admin.TABLA_ESPIRAL,null);

        /*Recorremos la salida de la consulta, lo guardamos en un objeto de la curva y agregamos a la listaCurvas*/
        while (sqlOut.moveToNext()){
            curva = new Espiral();
            curva.setId(sqlOut.getInt(0));
            curva.setNombre(sqlOut.getString(1));
            curva.setAngTan(sqlOut.getString(2));
            curva.setPi(sqlOut.getDouble(3));
            curva.setVp(sqlOut.getDouble(4));
            curva.setGc(sqlOut.getString(5));
            curva.setLe(sqlOut.getDouble(6));
            curva.setDc(sqlOut.getDouble(7));
            curva.setDireccion(sqlOut.getString(8));
            listaCurvas.add(curva);
        }
        baseDeDatos.close();
        return  listaCurvas;
    }

    public void eliminarRegistro(int curvaid, String tabla,Context cntx) {
            DbHelper admin = new DbHelper(cntx);
            SQLiteDatabase db = admin.getWritableDatabase();
            db.delete(tabla,"id="+curvaid,null);
            db.close();
    }
}
