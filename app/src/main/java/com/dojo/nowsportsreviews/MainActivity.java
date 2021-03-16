package com.dojo.nowsportsreviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public ImageButton botaoHome;
    public ImageButton botaoNews;
    public JsonTask meuJson;
    public String minhaUrl = "https://api.api-futebol.com.br/v1/";
    public String Ayutentication = "test_5a6a0e4383befd4b786b5bc7d59308";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoHome = findViewById(R.id.btHome);
        botaoNews = findViewById(R.id.btNews);

        botaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        botaoNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),ActivitySecond.class);
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
                // inserir o Header de autenticação para conexão.


                connection.connect();

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

        }
    }

    public class noticia {

        public String timeCasa, timeVisitante, siglaCasa,siglaVisitante;
        public Integer placar , golCasa, golVisitante;

        public noticia(String timeCasa, String timeVisitante, String siglaCasa, String siglaVisitante, Integer placar, Integer golCasa, Integer golVisitante) {
            this.timeCasa = timeCasa;
            this.timeVisitante = timeVisitante;
            this.siglaCasa = siglaCasa;
            this.siglaVisitante = siglaVisitante;
            this.placar = placar;
            this.golCasa = golCasa;
            this.golVisitante = golVisitante;
        }

        public String getTimeCasa() {
            return timeCasa;
        }

        public void setTimeCasa(String timeCasa) {
            this.timeCasa = timeCasa;
        }

        public String getTimeVisitante() {
            return timeVisitante;
        }

        public void setTimeVisitante(String timeVisitante) {
            this.timeVisitante = timeVisitante;
        }

        public String getSiglaCasa() {
            return siglaCasa;
        }

        public void setSiglaCasa(String siglaCasa) {
            this.siglaCasa = siglaCasa;
        }

        public String getSiglaVisitante() {
            return siglaVisitante;
        }

        public void setSiglaVisitante(String siglaVisitante) {
            this.siglaVisitante = siglaVisitante;
        }

        public Integer getPlacar() {
            return placar;
        }

        public void setPlacar(Integer placar) {
            this.placar = placar;
        }

        public Integer getGolCasa() {
            return golCasa;
        }

        public void setGolCasa(Integer golCasa) {
            this.golCasa = golCasa;
        }

        public Integer getGolVisitante() {
            return golVisitante;
        }

        public void setGolVisitante(Integer golVisitante) {
            this.golVisitante = golVisitante;
        }
    }
}