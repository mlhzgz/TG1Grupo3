package com.example.tg1grupo3.logica;

import com.example.tg1grupo3.datos.Cita;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaCitas {

    private static final List<Cita> citas = new ArrayList<>();

    private ListaCitas(){    }

    public static void addCita(Cita cita){
        citas.add(cita);
    }

    public static List<Cita> filtrarPorFecha(String fecha){
        return citas.stream()
                .filter(cita -> cita.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }
}
