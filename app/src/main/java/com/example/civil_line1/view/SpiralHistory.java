package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.civil_line1.R;

public class SpiralHistory extends AppCompatActivity {
    private ImageButton btnReturn;

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
    }

    private void initElements(){
        btnReturn = (ImageButton) findViewById(R.id.historyReturn);
    }
}