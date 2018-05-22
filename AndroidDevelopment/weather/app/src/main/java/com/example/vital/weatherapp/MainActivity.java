package com.example.vital.weatherapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            //String result = "";
            URL url;
            HttpURLConnection urlConnection;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                StringBuilder builder = new StringBuilder();
                while (data != -1) {
                    char current = (char) data;
                    //result += current;
                    builder.append(current);
                    data = reader.read();
                }
                return builder.toString();
                //return result;
            } catch(Exception e) {
                e.printStackTrace();
                return null;
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkWeather(View view) {

        EditText cityInput = findViewById(R.id.cityInput);
        TextView weatherBox = findViewById(R.id.weatherBox);
        String city = cityInput.getText().toString();

        DownloadTask task = new DownloadTask();
        try {
            String result = task
                    .execute("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=3a3643a82162e67107ff1d0f01bc1b61")
                    .get();
//            Log.i("City", city);
//            Log.i("Weather", result);

            JSONObject jObject = new JSONObject(result);
            String weatherInfo =  jObject.getString("weather");
            JSONArray jArray = new JSONArray(weatherInfo);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jPart = jArray.getJSONObject(i);
                String main = jPart.getString("main");
                String desc = jPart.getString("description");
                Log.i("main", main);
                Log.i("description", desc);
                weatherBox.setText(main + ": " + desc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
