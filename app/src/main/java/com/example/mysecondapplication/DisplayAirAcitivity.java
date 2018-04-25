package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayAirAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_air_acitivity);
        String output ="";

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String messageair = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        try {
            int ab = messageair.indexOf("pollution");
            int bc = messageair.indexOf("aqius", ab);
            int cd = messageair.indexOf(",", bc + 7);
            String aqis = messageair.substring(bc + 7, cd);
            String aqi = "the air quality index is " + aqis + " by US standard";
            int a = messageair.indexOf("pollution");
            int b = messageair.indexOf("aqicn", a);
            int c = messageair.indexOf(",", b + 7);
            String aqic = messageair.substring(b + 7, c);
            String aqicn = "the air quality index is " + aqic + " by Chinese standard";
            int de = messageair.indexOf("mainus", ab);
            int ef = messageair.indexOf("\"", de + 9);
            String pts = messageair.substring(de + 9, ef);
            String pt = "the main pollutant is " + pts;
            output = aqi + "\n" + aqicn + "\n" + pt;
        } catch (Exception e) {
            output = "not find the city";
        }


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.text);
        textView.setText(output);
    }
}
