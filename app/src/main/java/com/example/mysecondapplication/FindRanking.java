package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FindRanking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_ranking);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String out = "";
        int run = 0;
        do{
            int a = message.indexOf("country", run);
            int b = message.indexOf("\"", a+10);
            out += "        "+message.substring(a+10,b)+"\n";
            run = b;
        } while (message.indexOf("country", run) > 0);

        TextView textView = findViewById(R.id.textView2);
        textView.setText(out);
    }
}
