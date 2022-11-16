package com.example.tg1grupo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaCitasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_citas);

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(this,2);

        recycler.setLayoutManager(layoutManager2);



        //recycler.setAdapter(new SerieAdapter(series));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.barraopciones,menu);
        return  true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.nuevaCita){
            abrirListaCitas();
        }else if(item.getItemId()==R.id.calendario){
            //aqui se debe de abrir el calendario
        }

        return super.onOptionsItemSelected(item);
    }
    public void abrirListaCitas(){
        Intent intento = new Intent(ListaCitasActivity.this,RegistrarCitaActivity.class);
        startActivity(intento);
    }

}