package com.example.tg1grupo3.util;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import androidx.appcompat.app.AlertDialog;

import com.example.tg1grupo3.R;

public class Utilidades {

    static String fechaSeleccionada="";

    public static String seleccionarFecha(Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.calendario, null);
        builder.setView(view);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatePicker guardarFecha = (DatePicker) view.findViewById(R.id.fecha);
                int dia = guardarFecha.getDayOfMonth();
                int mes = guardarFecha.getMonth() + 1;
                int año = guardarFecha.getYear();
                fechaSeleccionada = dosDigitos(dia) + "/" + dosDigitos(mes) + "/" + año;
                //EditText txtFecha = findViewById(R.id.txtFecha);
                //txtFecha.setText(fechaSeleccionada);
            }
        });

        builder.show();
        return fechaSeleccionada;
    }
    private static String dosDigitos(int n){
        return (n<=9)?("0"+n):String.valueOf(n);
    }
}
