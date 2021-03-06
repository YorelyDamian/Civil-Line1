package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.example.civil_line1.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnClose;
    private ImageButton btnHistory;
    private Button btnContinue;
    private RadioButton btnHorizontal;
    private RadioButton btnSpiral;
    private SwitchMaterial switchDirection;
    private String direction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_CivilLine1);
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
                createIntent(MenuHistory.class);
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*direction true is left
                * direction false is right
                */

                direction = "izq";
                if (switchDirection.isChecked()){
                    /*Right*/
                    direction = "der";
                }
                if(btnSpiral.isChecked()){
                    createIntent(SpiralValues.class);
                }else if(btnHorizontal.isChecked()){
                    createIntent(HorizontalValues.class);
                }
            }
        });
    }



    private void createIntent(Class clase){
    /*method to go to other screens*/
        Intent intent = new Intent(this,clase);
        intent.putExtra("direccion",direction);
        intent.putExtra("tipo","normal");
        startActivity(intent);
    }

    private void initElements(){
        btnClose = (ImageButton) findViewById(R.id.main_close);
        btnHistory = (ImageButton) findViewById(R.id.main_history);
        btnContinue = (Button) findViewById(R.id.btn_Continuar);
        btnHorizontal = (RadioButton) findViewById(R.id.radioHorizontal);
        btnSpiral = (RadioButton) findViewById(R.id.radioEspiral);
        switchDirection = (SwitchMaterial) findViewById(R.id.switchDirection);
    }
}