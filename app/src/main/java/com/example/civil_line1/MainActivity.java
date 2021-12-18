package com.example.civil_line1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnClose;
    private ImageButton btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


        /*Get screen items*/
        initElements();



        /*Set item events*/
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createIntent(History.class);
            }
        });
    }



    private void createIntent(Class clase){
    /*method to go to other screens*/
        Intent intent = new Intent(this,clase);
        startActivity(intent);
    }

    private void initElements(){
        btnClose = (ImageButton) findViewById(R.id.main_close);
        btnHistory = (ImageButton) findViewById(R.id.main_history);
    }
}