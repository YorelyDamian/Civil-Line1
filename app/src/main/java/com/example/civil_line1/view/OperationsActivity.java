package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.civil_line1.R;

public class OperationsActivity extends AppCompatActivity {
    private ImageButton btnReturn;
    private ImageButton btnAgregar;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operations_layout);
        initComponets();
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationsActivity.super.onBackPressed();
            }
        });
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createIntent(MainActivity.class);
            }
        });

    }
    private void createIntent(Class clase){
        /*method to go to other screens*/
        Intent intent = new Intent(this,clase);
        startActivity(intent);
    }
    private void initComponets(){
        btnReturn = (ImageButton) findViewById(R.id.OperationsReturn);
        btnAgregar = (ImageButton) findViewById(R.id.agregarOperacion);
        salida = (TextView) findViewById(R.id.OutOperaciones);
        salida.setText(getIntent().getStringExtra("cadena"));
    }
}