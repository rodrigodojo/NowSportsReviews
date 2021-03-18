package com.dojo.nowsportsreviews;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MeuViewHolder extends RecyclerView.ViewHolder {

    TextView timeCasa;
    TextView siglaCasa;
    TextView timeVisitante;
    TextView siglaVisitante;
    TextView placar;
    TextView titulo;

    public MeuViewHolder(@NonNull View itemView) {
        super(itemView);

        siglaCasa = itemView.findViewById(R.id.txtSiglaCasa);
        timeCasa = itemView.findViewById(R.id.txtTimeCasa);
        siglaVisitante = itemView.findViewById(R.id.txtTimeVisitante);
        timeVisitante = itemView.findViewById(R.id.txtSiglaVisitante);
        placar = itemView.findViewById(R.id.txtPlacar);
        titulo = itemView.findViewById(R.id.txtTitulo);
    }
}
