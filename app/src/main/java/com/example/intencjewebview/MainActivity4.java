package com.example.intencjewebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4<TextEdit> extends AppCompatActivity {

    public static final String ODPOWIEDZ = "Odpowiedz";
    public static final int KOD_ODP_OKNA = 1;
    TextView textView01;
    Button wykonaj;
    EditText textEdit01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        odnajdzKontrolki();
    }

    private void odnajdzKontrolki() {
        textView01 = findViewById(R.id.textView0401);
        wykonaj = findViewById(R.id.button0401);
        textEdit01 = findViewById(R.id.textEdit0401);
        dodajSluchacza();
    }

    private void dodajSluchacza() {
        wykonaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                przygotujOdpowiedz();
                finish();
            }
        });
    }

    private void przygotujOdpowiedz() {
        String s = textEdit01.getText().toString();
        Intent wynik = new Intent();
        wynik.putExtra(ODPOWIEDZ, s);
        setResult(KOD_ODP_OKNA, wynik);
    }
}
