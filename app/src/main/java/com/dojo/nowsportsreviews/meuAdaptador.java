package com.dojo.nowsportsreviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class meuAdaptador extends RecyclerView.Adapter {

    ArrayList<Noticia> listaNoticia;
    Context context;

    public meuAdaptador(ArrayList<Noticia> listaNoticia, Context context) {
        this.listaNoticia = listaNoticia;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.forma_noticia,parent,false);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaNoticia.size();
    }
}
