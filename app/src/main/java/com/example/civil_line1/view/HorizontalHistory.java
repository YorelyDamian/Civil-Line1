package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.civil_line1.R;
import com.example.civil_line1.db.DbHelper;

import java.io.Serializable;
import java.util.ArrayList;

import model.HorizontalSimple;

public class HorizontalHistory extends AppCompatActivity {
    private ImageButton btnRetur;
    private ImageButton btnDelete;
    private ListView lista;
    ArrayList<HorizontalSimple> listaCurvas = new ArrayList<HorizontalSimple>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_history_layout);
        initComponents();

        btnRetur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HorizontalHistory.super.onBackPressed();
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HorizontalHistory.this, HorizontalValues.class);
                intent.putExtra("objetoData", (Serializable) listaCurvas.get(i));
                startActivity(intent);
            }
        });
    }
    private void buscar(){
        DbHelper admin = new DbHelper(HorizontalHistory.this);
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
            agregarAListView();
        }
        baseDeDatos.close();
    }

    private void agregarAListView() {
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaCurvas);
        lista.setAdapter(adaptador);
    }

    private void initComponents(){
        btnRetur = (ImageButton) findViewById(R.id.HorizontalHistoryReturn);
        btnDelete = (ImageButton) findViewById(R.id.HorizontalHistorybote);
        lista = (ListView) findViewById(R.id.lv_datosHorizontal);
        buscar();
    }
}