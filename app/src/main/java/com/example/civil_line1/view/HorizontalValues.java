package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.civil_line1.R;

public class HorizontalValues extends AppCompatActivity {
    private ImageButton btnReturn;
    private ImageButton btnSave;
    private ImageButton btnClear;
    private Button btnOperations;
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
                createIntent(OperationsActivity.class);
            }
        });
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
    }
}