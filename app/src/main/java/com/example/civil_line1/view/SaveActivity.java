package com.example.civil_line1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.civil_line1.R;
import com.example.civil_line1.db.DbHelper;
import com.google.android.material.button.MaterialButton;

public class SaveActivity extends AppCompatActivity {
    private ImageButton btnReturn;
    private MaterialButton btnGuardar;
    private EditText txtNombre;
    private String direccion;
    private String padre;
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
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (!txtNombre.getText().toString().isEmpty()){
                    /*LLamada en el objeto db a la clase creadora  de la base de datos*/
                    DbHelper db = new DbHelper(SaveActivity.this);
                    /*Abrir la base de datos para poder escribir-leer de ella*/
                    SQLiteDatabase baseDeDatos = db.getWritableDatabase();
                    /*Extras para agregar los datos a la bd*/
                    Intent extras = getIntent();

                    /*Objeto para almacenar los valores extraidos de la curva*/
                    ContentValues registro = new ContentValues();

                    /*Padre define que datos se van a guardar*/
                    padre = getIntent().getStringExtra("padre");
                    Toast.makeText(SaveActivity.this,padre,Toast.LENGTH_LONG).show();

                    if(padre.equals("Horizontal")){
                        registro.put("nombre",txtNombre.getText().toString());
                        registro.put("AT",extras.getStringExtra("AT"));
                        registro.put("GC",extras.getStringExtra("GC"));
                        registro.put("PI",Double.parseDouble(extras.getStringExtra("PI")));
                        registro.put("VP",Double.parseDouble(extras.getStringExtra("VP")));
                        registro.put("direccion",direccion);
                        baseDeDatos.insert(db.TABLA_SIMPLE,null, registro);
                    }else{
                        registro.put("nombre",txtNombre.getText().toString());
                        registro.put("AT",extras.getStringExtra("AT"));
                        registro.put("GC",extras.getStringExtra("GC"));
                        registro.put("PI",Double.parseDouble(extras.getStringExtra("PI")));
                        registro.put("VP",Double.parseDouble(extras.getStringExtra("VP")));
                        registro.put("LE",Double.parseDouble(extras.getStringExtra("LE")));
                        registro.put("DC",Double.parseDouble(extras.getStringExtra("DC")));
                        registro.put("direccion",direccion);
                        baseDeDatos.insert(db.TABLA_ESPIRAL,null,registro);
                    }
                    Toast.makeText(SaveActivity.this,"Agregado",Toast.LENGTH_SHORT).show();
                    baseDeDatos.close();
                    Intent intent = new Intent(SaveActivity.this,MenuHistory.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void initComponents(){
        btnReturn = (ImageButton) findViewById(R.id.SaveReturn);
        btnGuardar = (MaterialButton) findViewById(R.id.btnGuardarBD);
        txtNombre = (EditText) findViewById(R.id.nombrePractica);
        direccion = getIntent().getStringExtra("direccion");

    }
}