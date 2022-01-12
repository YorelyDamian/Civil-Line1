package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.civil_line1.R;

import java.util.Locale;

import model.HorizontalSimple;

public class HorizontalValues extends AppCompatActivity {
    private ImageButton btnReturn;
    private ImageButton btnSave;
    private ImageButton btnClear;
    private Button btnOperations;
    private EditText AngTan;
    private EditText PI;
    private EditText VP;
    private EditText GC;
    private String cadenaOperaciones;
    private String direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_layout);
        initComponents();
        direccion = getIntent().getStringExtra("direccion");

        /*Definir tipo de entrada*/
        String tipo=getIntent().getStringExtra("tipo");
        if (tipo.equals("Recuperacion")){
            /*El padre viene del un historial*/
            AngTan.setText(getIntent().getStringExtra("AT"));
            GC.setText(getIntent().getStringExtra("GC"));
            PI.setText(getIntent().getDoubleExtra("PI",0.00)+"");
            VP.setText(getIntent().getDoubleExtra("VP",0.00)+"");
        }
        /*Events*/
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HorizontalValues.super.onBackPressed();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HorizontalValues.this,SaveActivity.class);
                intent.putExtra("AT",AngTan.getText().toString());
                intent.putExtra("GC",GC.getText().toString().trim());
                intent.putExtra("PI",PI.getText().toString().trim());
                intent.putExtra("VP",VP.getText().toString().trim());
                intent.putExtra("direccion",direccion);
                intent.putExtra("padre","Horizontal");
                startActivity(intent);
            }
        });

        btnOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = btnOperations.getText().toString();
                if (nombre.toLowerCase().equals("calcular")){
                    if (estanLlenos()){
                        btnOperations.setText("Operaciones");
                        //Cargar evento de los datos
                        HorizontalSimple obj = new HorizontalSimple();
                        obj.setAT(AngTan.getText().toString());
                        obj.setGC((GC.getText().toString().trim()));
                        obj.setPuntoInter(Double.parseDouble(PI.getText().toString().trim()));
                        obj.setVelocProy(Double.parseDouble(VP.getText().toString().trim()));
                        cadenaOperaciones = obj.calcularCurva();
                    }
                }else{
                    btnOperations.setText("Calcular");
                    Intent op = new Intent(HorizontalValues.this,OperationsActivity.class);
                    op.putExtra("cadena", cadenaOperaciones);
                    startActivity(op);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AngTan.setText(null);
                PI.setText(null);
                VP.setText(null);
                GC.setText(null);
            }
        });
    }


    private boolean estanLlenos(){
        if(AngTan.getText().toString().isEmpty() ||
                PI.getText().toString().isEmpty() ||
                VP.getText().toString().isEmpty() ||
                GC.getText().toString().isEmpty()){
            //Alguno esta vacio
            return false;
        }else{
            return true;
        }
    }


    private void initComponents(){
        btnReturn = (ImageButton) findViewById(R.id.HorizontalReturn);
        btnSave = (ImageButton) findViewById(R.id.HorizontalSave);
        btnClear = (ImageButton) findViewById(R.id.HorizontalClear);
        btnOperations = (Button) findViewById(R.id.btnOperacionesSimple);
        AngTan = (EditText) findViewById(R.id.deltaSimple);
        PI = (EditText) findViewById(R.id.PISimple);
        VP = (EditText) findViewById(R.id.VPSimple);
        GC = (EditText) findViewById(R.id.GCSimple);
    }
}