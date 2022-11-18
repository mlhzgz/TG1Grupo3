package com.example.tg1grupo3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tg1grupo3.R;
import com.example.tg1grupo3.datos.Cita;

import java.util.List;

public class CitaAdapter extends RecyclerView.Adapter<CitaAdapter.ViewHolder>{

    private final List<Cita> citas;

    public CitaAdapter(List<Cita> citas){
        this.citas = citas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cita cita = citas.get(position);
        holder.nombrePaciente.setText(cita.getNombreDelPaciente());
        holder.nombreMedico.setText(cita.getNombreMedico());
        holder.dia.setText(cita.getFecha());
        holder.hora.setText(cita.getHora());

        holder.itemView.setOnClickListener(view -> new AlertDialog.Builder(view.getContext())
                .setTitle("Datos de la cita")
                .setMessage(cita.toString())
                .setPositiveButton("Ok", null)
                .show());
    }

    @Override
    public int getItemCount() {
        return citas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombrePaciente;
        TextView nombreMedico;
        TextView dia;
        TextView hora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombrePaciente = itemView.findViewById(R.id.txtNombrePaciente);
            nombreMedico = itemView.findViewById(R.id.txtNombreDoctor);
            dia = itemView.findViewById(R.id.txtFecha);
            hora = itemView.findViewById(R.id.txtHora);
        }
    }
}
