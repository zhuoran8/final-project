package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Findcities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findcities);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String out = "";
        int run = 0;
        try {
            do {
                int a = message.indexOf("city", run);
                int b = message.indexOf("\"", a + 7);
                out += "        " + message.substring(a + 7, b) + "\n";
                run = b;
            } while (message.indexOf("city", run) > 0);
        } catch (Exception e) {
            out = "please enter a valid city according to the list of supported countries and states";
        }


        TextView textView = findViewById(R.id.textView5);
        textView.setText(out);
    }
}
