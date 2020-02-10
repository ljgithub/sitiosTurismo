package com.sagbaicela.sitiosturismo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSitios,btnTipos,btnUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSitios=(Button) findViewById(R.id.btnSitios);
        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map1 = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(map1);
            }
        });

        btnTipos = findViewById(R.id.btnTipos);
        btnTipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map2 = new Intent(getApplicationContext(), MapsActivity2.class);
                startActivity(map2);
            }
        });

        btnUbicacion = findViewById(R.id.btnUbicacion);
        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map3 = new Intent(getApplicationContext(), MapsActivity3.class);
                startActivity(map3);

            }
        });
    }
}
