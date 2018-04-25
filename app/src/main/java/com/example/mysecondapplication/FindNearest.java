package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class FindNearest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_nearest);
        String output ="";

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message3 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        try {
        int a = message3.indexOf("weather");
        int b = message3.indexOf("tp", a);
        int c = message3.indexOf(",", b+4);
        String tps = message3.substring(b+4, c);
        String tp = "the temperature is " + tps + " Celsius degree";
        int d = message3.indexOf("ws", a);
        int e = message3.indexOf("}", d+4);
        String wss = message3.substring(d+4, e);
        String ws = "the wind speed is " + wss + " m/s";
        int f = message3.indexOf("hu", a);
        int g = message3.indexOf(",", f+4);
        String hus = message3.substring(f+4, g);
        String hu = "the humidity is " + hus+"%";

        int ab = message3.indexOf("pollution");
        int bc = message3.indexOf("aqius", ab);
        int cd = message3.indexOf(",", bc+7);
        String aqis = message3.substring(bc+7, cd);
        String aqi = "the air quality index is " + aqis + " by US standard";
        int de = message3.indexOf("mainus", ab);
        int ef = message3.indexOf("\"", de+9);
        String pts = message3.substring(de+9, ef);
        String pt = "the main pollutant is " + pts;

        int cityindex = message3.indexOf("city");
        String city = message3.substring(cityindex+7,
                message3.indexOf("\"", cityindex+7));
        int stateindex = message3.indexOf("state");
        String state = message3.substring(stateindex+8,
                message3.indexOf("\"", stateindex+8));
        int countryindex = message3.indexOf("country");
        String country = message3.substring(countryindex+10,
                message3.indexOf("\"", countryindex+10));
        String location = "Your current location is "+city+", "+state+", "+country;
        output = location+"\n"+"\n"+tp +"\n" + ws +"\n" + hu +"\n"+"\n"+"\n"+aqi +"\n" + pt;
        } catch (Exception e) {
            output = "cannot find the city";
        }


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView3);
        textView.setText(output);

    }
}
