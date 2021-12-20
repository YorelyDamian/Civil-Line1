package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.civil_line1.R;

public class SaveActivity extends AppCompatActivity {
    private ImageButton btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_layout);
        initComponents();

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveActivity.super.onBackPressed();
            }
        });
    }

    private void initComponents(){
        btnReturn = (ImageButton) findViewById(R.id.SaveReturn);
    }
}