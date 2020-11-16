package com.example.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView titulo;
    private TextView lblResultado;
    private TextView lblResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        titulo = findViewById(R.id.lblTituloResultado);
        lblResultado = findViewById(R.id.lblResultadoValue);
        lblResultText = findViewById(R.id.lblResultado);

        Bundle b = getIntent().getExtras();
        double area = b.getDouble("area");
        String title = b.getString("title");
        int show = b.getInt("show");

        if(show == 0){
            lblResultText.setText(R.string.lblResultadoArea);
        }else{
            lblResultText.setText(R.string.lblResultadoVolume);
        }
        titulo.setText(title);
        lblResultado.setText(Double.toString(area));

    }

    public void goback(View v){
        Intent intent = new Intent(Resultado.this, MainActivity.class);
        startActivity(intent);
    }
}