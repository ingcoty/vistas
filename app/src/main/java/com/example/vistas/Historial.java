package com.example.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    private TableLayout tabla;
    private ArrayList<Registro> registros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        tabla = findViewById(R.id.tblHistorial);
        registros = Datos.obtener();

        for(int i = 0; i<registros.size(); i++){
            TableRow fila = new TableRow(this);
            TextView no = new TextView(this);
            TextView operacion = new TextView(this);
            TextView datos = new TextView(this);
            TextView resultado = new TextView(this);

            no.setText(registros.get(i).getId());
            operacion.setText((registros.get(i).getOperacion()));
            datos.setText(registros.get(i).getDatos());
            resultado.setText(registros.get(i).getResultado());

            fila.addView(no);
            fila.addView(operacion);
            fila.addView(datos);
            fila.addView(resultado);

            tabla.addView(fila);

        }
    }
}