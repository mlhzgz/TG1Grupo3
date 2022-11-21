package com.example.tg1grupo3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tg1grupo3.datos.Cita;
import com.example.tg1grupo3.logica.ListaCitas;
import com.example.tg1grupo3.util.UtilidadesCalendario;

public class RegistrarCitaActivity extends AppCompatActivity {
    EditText txtFechaCita;
    EditText txtNombrePacienteCita;
    Spinner spnEspecialidadMedicaCita;
    Spinner spnMedicoCita;
    EditText txtAnotacionesCita;
    Spinner spnHorasCita;
    Spinner spnMinutosCitas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cita);
        txtFechaCita = findViewById(R.id.txtFechaCita);
        spnHorasCita = findViewById(R.id.spnHorasCita);
        spnMinutosCitas = findViewById(R.id.spnMinutosCitas);
        txtNombrePacienteCita = findViewById(R.id.txtNombrePacienteCita);
        spnEspecialidadMedicaCita = findViewById(R.id.spnEspecialidadMedicaCita);
        spnMedicoCita = findViewById(R.id.spnMedicoCita);
        txtAnotacionesCita = findViewById(R.id.txtAnotacionesCita);

        Button btnRegistrarCita = findViewById(R.id.btnRegistrarCita);
        btnRegistrarCita.setOnClickListener(v->{
            compruebaCampos();
        });

        Button btnCancelarCita = findViewById(R.id.btnCancelarCita);
        btnCancelarCita.setOnClickListener(v->{
            finish();
        });
        txtFechaCita.setOnClickListener(v->{
            UtilidadesCalendario.showDatePickerDialog(this, txtFechaCita);
        });

    }

    public void compruebaCampos(){
        if(compruebaTxtVacio(txtFechaCita)){
            alertas("El campo de la fecha no puede quedar vacío");
        } else if(compruebaTxtVacio(txtNombrePacienteCita)){
            alertas("El campo del nombre del paciente no puede quedar vacío");
        } else if(compruebaSeleccionSpinner(spnEspecialidadMedicaCita)){
            alertas("Se debe de seleccionar una especialiad");
        } else if(compruebaSeleccionSpinner(spnMedicoCita)){
            alertas("Se debe de seleccionar un médico para la cita");
        } else{
            alertas("Has registrado la cita correctamente");

            String horaCitas = String.format("%s:%s",spnHorasCita.getSelectedItem().toString(),spnMinutosCitas.getSelectedItem().toString());

            Cita objetoCita = new Cita(txtFechaCita.getText().toString(),horaCitas,
                    txtNombrePacienteCita.getText().toString(),spnEspecialidadMedicaCita.getSelectedItem().toString(),
                    spnMedicoCita.getSelectedItem().toString(),txtAnotacionesCita.getText().toString());
            ListaCitas.addCita(objetoCita);
            limpiarCampos();
        }

    }
    public boolean compruebaTxtVacio(EditText txt) {
        return "".equals(txt.getText().toString().trim());
    }
    public boolean compruebaSeleccionSpinner(Spinner spn){
        return spn.getSelectedItemPosition() == 0;
    }
    public void alertas(String texto){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(texto);
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
    public void limpiarCampos(){
        txtFechaCita.setText("");
        spnHorasCita.setSelection(0);
        spnMinutosCitas.setSelection(0);
        txtNombrePacienteCita.setText("");
        spnEspecialidadMedicaCita.setSelection(0);
        spnMedicoCita.setSelection(0);
        txtAnotacionesCita.setText("");
    }
}