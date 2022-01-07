package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.civil_line1.R;
import com.example.civil_line1.db.DbHelper;

import java.util.ArrayList;

import model.Espiral;
import model.HorizontalSimple;

public class SpiralHistory extends AppCompatActivity {
    private ImageButton btnReturn;
    private ListView lista;
    ArrayList<Espiral> listaCurvas = new ArrayList<Espiral>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiral_history_layout);

        initElements();
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpiralHistory.super.onBackPressed();
            }
        });
    }
    private void buscar(){
        DbHelper admin = new DbHelper(SpiralHistory.this);
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
            agregarAListView();
        }
        baseDeDatos.close();
    }

    private void agregarAListView() {
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaCurvas);
        lista.setAdapter(adaptador);
    }
    private void initElements(){
        btnReturn = (ImageButton) findViewById(R.id.historyReturn);
        lista = (ListView) findViewById(R.id.lv_datosEspiral);
        buscar();
    }
}