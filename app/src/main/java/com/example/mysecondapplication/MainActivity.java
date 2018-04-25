package com.example.mysecondapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    //HePNHFKohpmbcA3BABCDEFG
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public String city, state, country, out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the Send button
     */
    public void findNearestMessage(View view) {
        Intent intent = new Intent(this, FindNearest.class);
        try {
            out = new CallbackTask().execute(Entries2()).get();
        } catch (Exception e) {
            out = "not find";
            //return;
        }
        intent.putExtra(EXTRA_MESSAGE, out);
        startActivity(intent);
    }

    public void findcountries(View view) {
        Intent intent = new Intent(this, FindRanking.class);
        try {
            out = new CallbackTask().execute(
                    "http://api.airvisual.com/v2/countries?key=HePNHFKohpmbcA3BA").get();
        } catch (Exception e) {
            out = "not find";
            //return;
        }
        intent.putExtra(EXTRA_MESSAGE, out);
        startActivity(intent);
    }

    public void findstates(View view) {
        Intent intent = new Intent(this, Findstates.class);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        country = editText3.getText().toString();
        try {
            out = new CallbackTask().execute(
                    "http://api.airvisual.com/v2/states?country="+country+"&key=HePNHFKohpmbcA3BA").get();
        } catch (Exception e) {

        }
        intent.putExtra(EXTRA_MESSAGE, out);
        startActivity(intent);
    }

    public void findcities(View view) {
        Intent intent = new Intent(this, Findcities.class);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        state = editText2.getText().toString();
        country = editText3.getText().toString();
        try {
            out = new CallbackTask().execute(
                    "http://api.airvisual.com/v2/cities?state="+state+"&country="+country+"&key=HePNHFKohpmbcA3BA").get();
        } catch (Exception e) {

        }
        intent.putExtra(EXTRA_MESSAGE, out);
        startActivity(intent);
    }

    public void sendWeatherMessage(View view) {
        Intent intent = new Intent(this, DisplayWeatherActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        city = editText.getText().toString();
        state = editText2.getText().toString();
        country = editText3.getText().toString();
        try {
            out = new CallbackTask().execute(Entries()).get();
        } catch (Exception e) {
            out = "not find";
            //return;
        }
        intent.putExtra(EXTRA_MESSAGE, out);
        startActivity(intent);
    }

    public void sendAirMessage(View view) {
        Intent intent = new Intent(this, DisplayAirAcitivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        city = editText.getText().toString();
        state = editText2.getText().toString();
        country = editText3.getText().toString();
        try {
            out = new CallbackTask().execute(Entries()).get();
        } catch (Exception e) {
            out = "not find";
            //return;
        }
        intent.putExtra(EXTRA_MESSAGE, out);
        startActivity(intent);
    }

    private String Entries() {
        final String cit = city;
        final String sta = state;
        final String coun = country;
        //TODO: replace with your own app id and app key
        return "http://api.airvisual.com/v2/city?city="
                + cit + "&state=" + sta + "&country=" + coun + "&key=HePNHFKohpmbcA3BA";
    }

    private String Entries2() {
        //TODO: replace with your own app id and app key
        return "http://api.airvisual.com/v2/nearest_city?key=HePNHFKohpmbcA3BA";
    }




    //in android calling network requests on the main thread forbidden by default
    //create class to do async job
    private class CallbackTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {

            //TODO: replace with your own app id and app key
            final String app_key = "HePNHFKohpmbcA3BA";
            try {
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Accept", "application/json");
                //urlConnection.setRequestProperty("app_id", app_id);
                urlConnection.setRequestProperty("app_key", app_key);

                // read the output from the server
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                return stringBuilder.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            System.out.println(result);
        }
    }


}
