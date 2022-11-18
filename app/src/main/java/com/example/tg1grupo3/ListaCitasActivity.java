package com.example.tg1grupo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tg1grupo3.adapters.CitaAdapter;
import com.example.tg1grupo3.datos.Cita;
import com.example.tg1grupo3.logica.ListaCitas;
import com.example.tg1grupo3.util.UtilidadesCalendario;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ListaCitasActivity extends AppCompatActivity {
    String fecha;
    TextView txtFechaElegida;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_citas);

        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recycler.setLayoutManager(layoutManager);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        String fecha = format.format(Calendar.getInstance().getTime());
        adapterLista(fecha);
        txtFechaElegida.setText(fecha);
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
            txtFechaElegida= findViewById(R.id.txtFechaElegida);
            UtilidadesCalendario.showDatePickerDialog(this, txtFechaElegida);
            fecha = txtFechaElegida.getText().toString();
            adapterLista(fecha);
        }

        return super.onOptionsItemSelected(item);
    }

    private void adapterLista(String fecha) {
        List<Cita> citas = ListaCitas.filtrarPorFecha(fecha);

        recycler.setAdapter(new CitaAdapter(citas));
    }

    public void abrirListaCitas(){
        Intent intento = new Intent(ListaCitasActivity.this,RegistrarCitaActivity.class);
        startActivity(intento);
    }


}