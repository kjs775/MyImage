package com.example.jun_sung.mymovie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView tvDirector, tvGenre, tvRelease, tvIntro, tvActor;
    Button btnSearch;
    ImageView imgPoster;
    EditText etTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDirector = (TextView)findViewById(R.id.tvDirector);
        tvGenre = (TextView)findViewById(R.id.tvGenre);
        tvRelease = (TextView)findViewById(R.id.tvReleased);
        tvIntro = (TextView)findViewById(R.id.tvIntro);
        tvActor = (TextView)findViewById(R.id.tvActor);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        imgPoster = (ImageView)findViewById(R.id.imgPoster);
        etTitle = (EditText)findViewById(R.id.etTitle);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etTitle.getText() != null && !etTitle.getText().toString().isEmpty()){

                    MySearchTask task = new MySearchTask();
                    task.execute(etTitle.getText().toString());

                }else{
                    Toast.makeText(getApplicationContext(), "'타이틀을 입력하세요", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    class MySearchTask extends AsyncTask<String, Void, String>{

        String urlStr = "http://www.omdbapi.com/?apikey=b0bd924&t="+etTitle.getText().toString();
        StringBuffer sb = new StringBuffer();

        public String doInBackground(String... values) {
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(100000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);
//                conn.getOutputStream().write(search.getBytes("UTF-8"));

                int responseCode = conn.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    String line = null;

                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }

                    conn.disconnect();
                    br.close();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                final JSONObject jsonObject = new JSONObject(sb.toString());

                                tvIntro.setText(jsonObject.getString("Plot"));
                                tvActor.setText(jsonObject.getString("Actors"));
                                tvDirector.setText(jsonObject.getString("Director"));
                                tvGenre.setText(jsonObject.getString("Genre"));
                                tvRelease.setText(jsonObject.getString("Released"));
                                final URL imgUrl = new URL(jsonObject.getString("Poster"));
                                new Thread(){
                                    @Override
                                    public void run() {
                                        super.run();
                                        try {
                                            InputStream is = imgUrl.openStream();
                                            final Bitmap bm = BitmapFactory.decodeStream(is);
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    imgPoster.setImageBitmap(bm);
                                                }
                                            });
                                        }catch(Exception e){
                                            e.printStackTrace();
                                        }
                                    }
                                }.start();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    conn.disconnect();
                }
            }catch(Exception e){
                e.printStackTrace();
             }
            return sb.toString();
        }
    }
}

