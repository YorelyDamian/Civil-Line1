package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.text.TextWatcher;

import com.example.civil_line1.R;

import model.Espiral;

public class SpiralValues extends AppCompatActivity {
    private ImageButton btnReturn;
    private ImageButton btnSave;
    private ImageButton btnClear;
    private Button btnOperations;
    private EditText AngTan;
    private EditText PI;
    private EditText VP;
    private EditText GC;
    private EditText Le;
    private EditText DC;
    private String cadenaOperacionesEspiral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiral_layout);
        initComponents();

        /*Events*/
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpiralValues.super.onBackPressed();
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
                if(nombre.toLowerCase().equals("calcular")){
                    if(estanLlenos()){
                        btnOperations.setText("Operaciones");
                        //carga el evento de los datos
                        Espiral obj = new Espiral();
                        obj.setAngTan(AngTan.getText().toString());
                        obj.setPi(Double.parseDouble(PI.getText().toString().trim()));
                        obj.setVp(Integer.parseInt(VP.getText().toString().trim()));
                        obj.setGc(GC.getText().toString());
                        obj.setLe(Integer.parseInt(Le.getText().toString().trim()));
                        obj.setDc(Integer.parseInt(DC.getText().toString().trim()));
                        cadenaOperacionesEspiral = obj.operaciones();
                    }
                }else{
                    btnOperations.setText("Calcular");
                    Intent ope = new Intent(SpiralValues.this,OperationsActivity.class);
                    ope.putExtra("cadena",cadenaOperacionesEspiral);
                    startActivity(ope);
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AngTan.setText(null);
                PI.setText(null);
                VP.setText(null);
                Le.setText(null);
                GC.setText(null);
                DC.setText(null);
                Le.setText(null);
            }
        });
        cargarEvento(AngTan);
        cargarEvento(PI);
        cargarEvento(VP);
        cargarEvento(Le);
        cargarEvento(GC);
        cargarEvento(DC);
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
                Le.getText().toString().isEmpty() ||
                DC.getText().toString().isEmpty() ||
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
        btnReturn = (ImageButton) findViewById(R.id.SpiralReturn);
        btnSave = (ImageButton) findViewById(R.id.SpiralSave);
        btnClear = (ImageButton) findViewById(R.id.SpiralClear);
        btnOperations = (Button) findViewById(R.id.btnOperacionesEspiral);
        AngTan = (EditText) findViewById(R.id.deltaEspiral);
        PI = (EditText) findViewById(R.id.PIEspiral);
        VP = (EditText) findViewById(R.id.VPEspiral);
        GC = (EditText) findViewById(R.id.GCEspiral);
        Le = (EditText) findViewById(R.id.LEEspiral);
        DC = (EditText) findViewById(R.id.DCEspiral);
    }
}