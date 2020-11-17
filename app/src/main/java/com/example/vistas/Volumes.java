package com.example.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Volumes extends AppCompatActivity {

    private ListView lista_opciones;
    private String opciones[];
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumes);

        lista_opciones = findViewById(R.id.lstVolumenes);
        opciones = getResources().getStringArray(R.array.opt_volumes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, opciones);
        lista_opciones.setAdapter(adapter);

        lista_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(Volumes.this, Calculo.class);
                Bundle b = new Bundle();
                switch (position){
                    case 0:
                        b.putInt("param", 4);
                        intent.putExtras(b);
                        break;
                    case 1:
                        b.putInt("param", 5);
                        intent.putExtras(b);
                        break;
                    case 2:
                        b.putInt("param", 6);
                        intent.putExtras(b);
                        break;
                    case 3:
                        b.putInt("param", 7);
                        intent.putExtras(b);
                        break;
                }
                startActivity(intent);
            }
        });

    }
}