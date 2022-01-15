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
import com.example.civil_line1.db.DBQuerys;
import com.example.civil_line1.db.DbHelper;

import java.io.Serializable;
import java.util.ArrayList;

import model.HorizontalSimple;

public class HorizontalHistory extends AppCompatActivity {
    private ImageButton btnRetur;
    private ImageButton btnDelete;
    private ListView lista;
    private ArrayList<HorizontalSimple> listaCurvas = new ArrayList<HorizontalSimple>();
    private boolean eliminar = false;
    private ArrayAdapter adaptador;
    private DBQuerys querys = new DBQuerys();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_history_layout);
        initComponents();

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar = !eliminar;
                if (eliminar) {
                    Toast.makeText(HorizontalHistory.this, "pulsa el elemento a eliminar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HorizontalSimple curva = (HorizontalSimple) parent.getItemAtPosition(position);
                if (eliminar) {
                    /*Eliminar datos*/
                    int curvaid = curva.getId();

                    querys.eliminarRegistro(curvaid,DbHelper.TABLA_SIMPLE,HorizontalHistory.this);
                    //buscar();
                } else {
                    /*Editar datos*/
                    Intent intent = new Intent(HorizontalHistory.this,HorizontalValues.class);
                    intent.putExtra("tipo","Recuperacion");
                    intent.putExtra("AT",curva.getAT());
                    intent.putExtra("GC",curva.getGC());
                    intent.putExtra("PI",curva.getPuntoInter());
                    intent.putExtra("VP",curva.getVelocProy());
                    intent.putExtra("direccion",curva.getDireccion());
                    startActivity(intent);

                }
            }
        });

        btnRetur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HorizontalHistory.super.onBackPressed();
            }
        });
    }

    private void buscar(){
        listaCurvas = querys.buscarHorizontal(HorizontalHistory.this);
        agregarAListView();
    }

    private void agregarAListView() {
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaCurvas);
        lista.setAdapter(adaptador);
    }

    private void initComponents(){
        btnRetur = (ImageButton) findViewById(R.id.HorizontalHistoryReturn);
        btnDelete = (ImageButton) findViewById(R.id.HorizontalHistorybote);
        lista = (ListView) findViewById(R.id.lv_datosHorizontal);
        buscar();
    }
}