package com.example.tg1grupo3.util;

import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

public class UtilidadesCalendario {

    public static void showDatePickerDialog(FragmentActivity fragmentActivity, TextView campoFecha) {
        StringBuilder fechaBuilder = new StringBuilder();
        DatePickerFragment.newInstance(
                ((datePicker, year, mes, dia) -> {
                    fechaBuilder.append(UtilidadesCalendario.dosDigitos(dia))
                            .append("/")
                            .append(UtilidadesCalendario.dosDigitos(mes + 1))
                            .append("/")
                            .append(year);
                    campoFecha.setText(fechaBuilder.toString());
                })
        ).show(fragmentActivity.getSupportFragmentManager(), "datePicker");
    }

    private static String dosDigitos(int n){
        return (n<=9)?("0"+n):String.valueOf(n);
    }
}
