package com.dojo.nowsportsreviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivitySecond extends AppCompatActivity {

    Button botaoVoltar;
    RecyclerView minhaListaNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        minhaListaNews = findViewById(R.id.minhaListaNews);

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