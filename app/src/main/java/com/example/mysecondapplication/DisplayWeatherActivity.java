package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);
        String output ="";

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        try {
            int a = message.indexOf("weather");
            int b = message.indexOf("tp", a);
            int c = message.indexOf(",", b + 4);
            String tps = message.substring(b + 4, c);
            String tp = "the temperature is " + tps + " Celsius degree";
            int d = message.indexOf("ws", a);
            int e = message.indexOf("}", d + 4);
            String wss = message.substring(d + 4, e);
            String ws = "the wind speed is " + wss + " m/s";
            int f = message.indexOf("hu", a);
            int g = message.indexOf(",", f + 4);
            String hus = message.substring(f + 4, g);
            String hu = "the humidity is " + hus + "%";
            output = tp +"\n" + ws +"\n" + hu;
        } catch (Exception e) {
            output = "not find the city";
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(output);
    }
}
