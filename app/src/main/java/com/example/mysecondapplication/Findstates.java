package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Findstates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findstates);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String out = "";
        int run = 0;
        try {
            do {
                int a = message.indexOf("state", run);
                int b = message.indexOf("\"", a + 8);
                out += "        " + message.substring(a + 8, b) + "\n";
                run = b;
            } while (message.indexOf("state", run) > 0);
        } catch (Exception e) {
            out = "please enter a valid country according to the list of supported countries";
        }


    TextView textView = findViewById(R.id.textView4);
        textView.setText(out);
}
}
