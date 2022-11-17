package com.example.tg1grupo3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tg1grupo3.datos.Cita;

public class RegistrarCitaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cita);
        Button btnRegistrarCita = findViewById(R.id.btnRegistrarCita);
        btnRegistrarCita.setOnClickListener(v->{
            compruebaCampos();
        });
        EditText txtFechaCita = findViewById(R.id.txtFechaCita);


    }

    public void compruebaCampos(){
        EditText txtFechaCita = findViewById(R.id.txtFechaCita);
        EditText txtHoraCita = findViewById(R.id.txtHoraCita);
        EditText txtNombrePacienteCita = findViewById(R.id.txtNombrePacienteCita);
        Spinner spnEspecialidadMedicaCita = findViewById(R.id.spnEspecialidadMedicaCita);
        Spinner spnMedicoCita = findViewById(R.id.spnMedicoCita);
        EditText txtAnotacionesCita = findViewById(R.id.txtAnotacionesCita);


        if(compruebaTxtVacio(txtFechaCita)){
            alertas("El campo de la fecha no puede quedar vacío");
        } else if(compruebaTxtVacio(txtHoraCita)){
            alertas("El campo de lahora no puede quedar vacío");
        } else if(compruebaTxtVacio(txtFechaCita)){
            alertas("El campo del nombre del paciente no puede quedar vacío");
        } else if(compruebaSeleccionSpinner(spnEspecialidadMedicaCita)){
            alertas("Se debe de seleccionar una especialiad");
        } else if(compruebaSeleccionSpinner(spnMedicoCita)){
            alertas("Se debe de seleccionar un médico para la cita");
        } else{
            alertas("Has registrado la cita correctamente");
            //Cita objetoCita = new Cita(txtFechaCita.toString(),txtHoraCita.toString(),txtNombrePacienteCita.toString(),spnEspecialidadMedicaCita.getSelectedItem().toString(),spnMedicoCita.getSelectedItem().toString(),txtAnotacionesCita.toString());
            limpiarCampos();
        }

    }
    public boolean compruebaTxtVacio(EditText txt) {
        return "".equals(txt.getText().toString().trim());
    }
    public boolean compruebaSeleccionSpinner(Spinner spn){
        if(spn.getSelectedItemPosition()==0){
            return true;
        }
        else return false;
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
        EditText txtFechaCita = findViewById(R.id.txtFechaCita);
        EditText txtHoraCita = findViewById(R.id.txtHoraCita);
        EditText txtNombrePacienteCita = findViewById(R.id.txtNombrePacienteCita);
        Spinner spnEspecialidadMedicaCita = findViewById(R.id.spnEspecialidadMedicaCita);
        Spinner spnMedicoCita = findViewById(R.id.spnMedicoCita);
        EditText txtAnotacionesCita = findViewById(R.id.txtAnotacionesCita);
        txtFechaCita.setText("");
        txtHoraCita.setText("");
        txtNombrePacienteCita.setText("");
        spnEspecialidadMedicaCita.setSelection(0);
        spnMedicoCita.setSelection(0);
        txtAnotacionesCita.setText("");
    }
}