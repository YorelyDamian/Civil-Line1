package com.example.civil_line1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class History extends AppCompatActivity {
    private ImageButton btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_layout);

        initElements();
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                History.super.onBackPressed();
            }
        });
    }

    private void initElements(){
        btnReturn = (ImageButton) findViewById(R.id.historyReturn);
    }
}