package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.civil_line1.R;

public class HorizontalHistory extends AppCompatActivity {
    private ImageButton btnRetur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_history_layout);
        initComponents();

        btnRetur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HorizontalHistory.super.onBackPressed();
            }
        });
    }

    private void initComponents(){
        btnRetur = (ImageButton) findViewById(R.id.HorizontalHistoryReturn);
    }
}