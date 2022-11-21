package com.example.tg1grupo3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
    TextView txtFechaElegida;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_citas);
        txtFechaElegida=findViewById(R.id.txtFechaElegida);
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recycler.setLayoutManager(layoutManager);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        String fecha = format.format(Calendar.getInstance().getTime());

        txtFechaElegida.setText(fecha);

        txtFechaElegida.addTextChangedListener(new OnTextChange());
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

    class OnTextChange implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            adapterLista(String.valueOf(charSequence));
        }

        @Override

        public void afterTextChanged(Editable editable) {}
    }

}