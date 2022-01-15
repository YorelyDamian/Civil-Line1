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
    DBQuerys querys = new DBQuerys();

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
                    querys.eliminarRegistro(curvaid,DbHelper.TABLA_ESPIRAL,SpiralHistory.this);
                }else{
                    /*Editar datos*/
                    Intent intent = new Intent(SpiralHistory.this,SpiralValues.class);
                    intent.putExtra("tipo","Recuperacion");
                    intent.putExtra("PI",curva.getPi());
                    intent.putExtra("AT",curva.getAngTan());
                    intent.putExtra("GC",curva.getGc());
                    intent.putExtra("VP",curva.getVp());
                    intent.putExtra("LE",curva.getLe());
                    intent.putExtra("DC",curva.getDc());
                    intent.putExtra("direccion",curva.getDireccion());
                    startActivity(intent);
                }
            }
        });
    }

    private void buscar() {
        listaCurvas = querys.buscarEspiral(SpiralHistory.this);
        agregarAListView();
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