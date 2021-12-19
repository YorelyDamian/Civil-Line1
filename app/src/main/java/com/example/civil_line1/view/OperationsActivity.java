package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.civil_line1.R;

public class OperationsActivity extends AppCompatActivity {
    private ImageButton btnReturn;

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




    }


    private void initComponets(){
        btnReturn = (ImageButton) findViewById(R.id.OperationsReturn);

    }
}