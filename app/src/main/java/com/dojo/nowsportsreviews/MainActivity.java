package com.dojo.nowsportsreviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ImageButton botaoHome;
    public ImageButton botaoNews;
    public JsonTask meuJson;
    public ArrayList<Noticia> listaNoticia;
    private static String minhaUrlTeste = "https://www.json-generator.com/api/json/get/cvlKbvCoaG?indent=2";
    private static String minhaUrl = "https://api.api-futebol.com.br/v1/campeonatos/10/rodadas";
    private static String autorizacao = "test_5a6a0e4383befd4b786b5bc7d59308";
    private static String nomeUsuario = "rodrigo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("meuLog:","carregando.");
        botaoHome = findViewById(R.id.btHome);
        botaoNews = findViewById(R.id.btNews);
        listaNoticia = new ArrayList<>();
        meuJson = new JsonTask();
        meuJson.execute(minhaUrlTeste);
        Log.i("meuLog:","Iniciou aqui.");

        MeuAdaptador meuAdaptador = new MeuAdaptador(listaNoticia,getApplicationContext());


        botaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Bem-vindo ao Now Sports News",Toast.LENGTH_LONG).show();
            }
        });

        botaoNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("meuLog:","foi para a Second Astivity");
                Toast.makeText(MainActivity.this,"Noticias da rodada",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getBaseContext(),ActivitySecond.class);
                ActivitySecond.listaNoticia = listaNoticia;
                startActivity(i);
            }
        });
    }
    public class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                //connection.setRequestProperty(nomeUsuario,autorizacao);
                connection.connect();
                Log.i("meuLog", "conectou com sucesso");

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line);
                }
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONObject listaJson = new JSONObject(result);
                JSONArray rodada = listaJson.getJSONArray("questionario");

                for (int i = 0; i < rodada.length(); i++) {
                    JSONObject noticia = rodada.getJSONObject(i);;

                    String timeCasa = noticia.getString("timeCasa");
                    String timeVisitante = noticia.getString("timeVisitante");
                    String siglaCasa = noticia.getString("siglaCasa");
                    String siglaVisitante = noticia.getString("siglaVisitante");
                    String placar = noticia.getString("placar");

                    Noticia minhaNoticia = new Noticia(timeCasa, timeVisitante, siglaCasa, siglaVisitante, placar);
                    listaNoticia.add(minhaNoticia);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}