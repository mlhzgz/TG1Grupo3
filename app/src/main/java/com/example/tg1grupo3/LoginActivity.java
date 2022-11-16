package com.example.tg1grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText contrasena;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.nombre);
        contrasena = findViewById(R.id.contrasena);
        entrar = findViewById(R.id.btnentrar);

        nombre.setHint("Usuario");
        contrasena.setHint("Contraseña");



        entrar.setOnClickListener(v ->{
            if(ComprobarVacio(nombre)){nombre.setError("Debe introducir un usuario");}else if(ComprobarVacio(contrasena)){contrasena.setError("Debe introducir una contraseña");}else {
                Intent intent = new Intent(getApplicationContext(), ListaCitasActivity.class);
                startActivity(intent);
            }
        });

    }

    static boolean ComprobarVacio(EditText campo){
        return campo.getText().toString().trim().equals("");
    }
}