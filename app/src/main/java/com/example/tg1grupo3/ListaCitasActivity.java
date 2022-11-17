package com.example.tg1grupo3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tg1grupo3.adapters.CitaAdapter;
import com.example.tg1grupo3.datos.Cita;
import com.example.tg1grupo3.logica.ListaCitas;
import com.example.tg1grupo3.util.DatePickerFragment;
import com.example.tg1grupo3.util.Utilidades;

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

        RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(this,2);

        recycler.setLayoutManager(layoutManager2);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        String fecha = format.format(Calendar.getInstance().getTime());
        adapterLista(fecha);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.barraopciones,menu);
        return  true;
    }

    private void showDatePickerDialog() {
        StringBuilder fechaBuilder = new StringBuilder();
        DatePickerFragment.newInstance(
                ((datePicker, year, mes, dia) -> {
                    fechaBuilder.append(Utilidades.dosDigitos(dia))
                            .append("/")
                            .append(Utilidades.dosDigitos(mes + 1))
                            .append("/")
                            .append(year);
                    fecha = fechaBuilder.toString();
                })
        ).show(getSupportFragmentManager(), "datePicker");
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.nuevaCita){
            abrirListaCitas();
        }else if(item.getItemId()==R.id.calendario){
            showDatePickerDialog();
            txtFechaElegida= findViewById(R.id.txtFechaElegida);
            txtFechaElegida.setText(fecha);
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