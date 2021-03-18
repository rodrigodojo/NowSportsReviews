package com.dojo.nowsportsreviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ActivitySecond extends AppCompatActivity {

    public static ArrayList<Noticia> listaNoticia;
    Button botaoVoltar;
    public RecyclerView minhaListaNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        minhaListaNews = findViewById(R.id.minhaListaNews);

        MeuAdaptador meuAdaptador = new MeuAdaptador(listaNoticia,getApplicationContext());
        minhaListaNews.setAdapter(meuAdaptador);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        minhaListaNews.setLayoutManager(layoutManager);


        botaoVoltar = findViewById(R.id.btVoltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Log.i("meuLog","Voltou");
            }
        });

    }
}