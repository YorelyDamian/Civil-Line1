package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;

import model.Espiral;
import model.HorizontalSimple;

public class SpiralHistory extends AppCompatActivity {
    private ImageButton btnReturn;
    private ImageButton btnDelete;
    private ListView lista;
    private boolean eliminar = false;
    private ArrayAdapter adaptador;
    private ArrayList<Espiral> listaCurvas = new ArrayList<Espiral>();

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
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar = !eliminar;
                if (eliminar){
                    Toast.makeText(SpiralHistory.this, "pulsa el elemento a eliminar",Toast.LENGTH_SHORT).show();
                }
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Espiral curva = (Espiral) parent.getItemAtPosition(position);
                if (eliminar){
                    /*Eliminar datos*/
                    int curvaid = curva.getId();
                    eliminarRegistro(curvaid);
                }else{
                    /*Editar datos*/
                }
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
    private void eliminarRegistro(int idCurva) {
        DbHelper admin = new DbHelper(SpiralHistory.this);
        SQLiteDatabase db = admin.getWritableDatabase();
        db.delete(DbHelper.TABLA_ESPIRAL,"id="+idCurva,null);
        db.close();
        adaptador.notifyDataSetChanged();

    }

    private void agregarAListView() {
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaCurvas);
        lista.setAdapter(adaptador);
    }
    private void initElements(){
        btnReturn = (ImageButton) findViewById(R.id.historyReturn);
        btnDelete = (ImageButton) findViewById(R.id.Espiralbote);
        lista = (ListView) findViewById(R.id.lv_datosEspiral);
        buscar();
    }
}