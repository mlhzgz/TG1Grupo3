package com.example.tg1grupo3.util;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import com.example.tg1grupo3.R;

public class Utilidades {

    public static String dosDigitos(int n){
        return (n<=9)?("0"+n):String.valueOf(n);
    }
}
