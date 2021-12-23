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

public class HorizontalValues extends AppCompatActivity {
    private ImageButton btnReturn;
    private ImageButton btnSave;
    private ImageButton btnClear;
    private Button btnOperations;
    private EditText AngTan;
    private EditText PI;
    private EditText VP;
    private EditText GC;

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
                    }
                }else{
                    btnOperations.setText("Calcular");

                    createIntent(OperationsActivity.class);

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
        cargarEvento(AngTan);
        cargarEvento(PI);
        cargarEvento(VP);
        cargarEvento(GC);
    }

    private void cargarEvento(EditText texto){
        texto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length()>0) {
                        if (estanLlenos()) {
                            //Cargar operaciones
                        }
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

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