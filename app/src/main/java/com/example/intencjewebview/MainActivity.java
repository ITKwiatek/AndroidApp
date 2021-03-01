package com.example.intencjewebview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int KOD_ODP_OKNA = 1 ;
    Button b1, b2, b3, b4, b5;
    TextView textView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        znajdzKontrolki();
    }

    private void znajdzKontrolki() {
        b1 = findViewById(R.id.button01);
        b2 = findViewById(R.id.button02 );
        b3 = findViewById(R.id.button03);
        b4 = findViewById(R.id.button04);
        b5 = findViewById(R.id.button05);
        textView01 = findViewById(R.id.textView01);
        dodajSluchacza();
    }

    private void dodajSluchacza() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otworzAktywnosc();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otworzIPrzekaz();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otworzIPobierz();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otworzURI();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otworzGeoURI();
            }
        });
    }

    private void otworzGeoURI() {
        Uri geoAdres = Uri.parse("geo:51.39517, 21.13989");
        Intent intencja = new Intent(Intent.ACTION_VIEW, geoAdres);
        startActivity(intencja);
    }

    private void otworzURI() {
        Uri adres = Uri.parse("http://www.google.pl");
        Intent intencja = new Intent(Intent.ACTION_VIEW, adres);

        startActivity(intencja);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==KOD_ODP_OKNA){
            String odpowiedz = data.getStringExtra(MainActivity4.ODPOWIEDZ);
            if(odpowiedz.length()>=1)
            textView01.setText("Odp aktywności to: \n"+odpowiedz);
            else
                textView01.setText("Nie wpisano wiadomości");
        }
    }

    private void otworzIPobierz() {
        Intent intencja = new Intent(MainActivity.super.getApplicationContext(),
                MainActivity4.class);
        startActivityForResult(intencja, KOD_ODP_OKNA);

    }

    private void otworzIPrzekaz() {
        Intent aktywnosc = new Intent(this, MainActivity3.class);
        aktywnosc.putExtra("wartosc", "To jest przekazane z zewnątrz");
        aktywnosc.putExtra("wartosc2", "\n i to tez");
        startActivity(aktywnosc);
    }

    private void otworzAktywnosc() {
        Intent intencja = new Intent(MainActivity.super.getApplicationContext(),
                MainActivity2.class);
        startActivity(intencja);
    }
}