package com.example.tg1grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.tg1grupo3.util.Utilidades;

public class RegistrarCitaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cita);

        EditText txtFechaCita = findViewById(R.id.txtFechaCita);


    }
}