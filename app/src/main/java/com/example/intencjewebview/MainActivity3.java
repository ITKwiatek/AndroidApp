package com.example.intencjewebview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView textView03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.layout3);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        odnajdzKontrolki();
        Bundle paczka = getIntent().getExtras();
        String s = paczka.getString("wartosc");
        s += paczka.getString("wartosc2");
        textView03.setText(s);
    }

    private void odnajdzKontrolki() {
        textView03 = findViewById(R.id.textView0301);
    }
}