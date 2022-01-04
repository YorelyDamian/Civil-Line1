package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_layout);
        initComponents();

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
                createIntent(SaveActivity.class);
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
                        //obj.setAT(AngTan.getText().toString());
                        //obj.setGradoCurva(Double.parseDouble(GC.getText().toString().trim()));
                        //obj.setGradoCurva(Double.parseDouble(PI.getText().toString().trim()));
                        //obj.setGradoCurva(Double.parseDouble(VP.getText().toString().trim()));
                        //cadenaOperaciones = obj.calcularCurva();
                        cadenaOperaciones = "Horizontal";
                    }
                }else{
                    btnOperations.setText("Calcular");
                    Intent op = new Intent(HorizontalValues.this,OperationsActivity.class);
                    op.putExtra("cadena", "Horizontal");
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

    private void createIntent(Class clase){
        /*method to go to other screens*/
        Intent intent = new Intent(this,clase);
        startActivity(intent);
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