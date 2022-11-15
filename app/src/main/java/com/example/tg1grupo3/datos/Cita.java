package com.example.tg1grupo3.datos;

public class Cita {

    String fecha;
    String hora;
    String nombreDelPaciente;
    String especialidad;
    String nombreMedico;
    String anotaciones;

    public Cita(String fecha, String hora, String nombreDelPaciente, String especialidad, String nombreMedico, String anotaciones) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombreDelPaciente = nombreDelPaciente;
        this.especialidad = especialidad;
        this.nombreMedico = nombreMedico;
        this.anotaciones = anotaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getNombreDelPaciente() {
        return nombreDelPaciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fecha: " + fecha +
                "\n hora: " + hora +
                "\n nombreDelPaciente: " + nombreDelPaciente +
                "\n especialidad: " + especialidad +
                "\n nombreMedico: " + nombreMedico +
                "\n anotaciones: " + anotaciones +
                '}';
    }
}
