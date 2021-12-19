package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.civil_line1.R;

public class MenuHistory extends AppCompatActivity {
    private ImageButton btnReturn;
    private Button btnHorizontal;
    private Button btnSpiral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_history_layout);
        initElements();

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuHistory.super.onBackPressed();
            }
        });
        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createIntent(HorizontalHistory.class);
            }
        });
        btnSpiral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createIntent(SpiralHistory.class);
            }
        });
    }


    private void createIntent(Class clase){
        /*method to go to other screens*/
        Intent intent = new Intent(this,clase);
        startActivity(intent);
    }

    private void initElements(){
        btnReturn = (ImageButton) findViewById(R.id.MenuHistoryReturn);
        btnHorizontal = (Button) findViewById(R.id.btn_Historial_Horizontal);
        btnSpiral = (Button) findViewById(R.id.btn_Historial_Espiral);
    }
}