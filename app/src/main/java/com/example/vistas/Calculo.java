package com.example.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Calculo extends AppCompatActivity {

    private TextView titulo;
    private LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        titulo = findViewById(R.id.txtTituloCalculo);
        content = (LinearLayout)findViewById(R.id.lytCalculo);


        Bundle b = getIntent().getExtras();
        int value = b.getInt("param");

        LinearLayout lytButtons = new LinearLayout(this);
        lytButtons.setOrientation(LinearLayout.HORIZONTAL);

        Button btnCalcular = new Button(this);
        btnCalcular.setText(getResources().getString(R.string.txtbtncalcular));

        Button btnBorrar = new Button(this);
        btnBorrar.setText(getResources().getString(R.string.txtbtnborrar));

        lytButtons.addView(btnCalcular);
        lytButtons.addView(btnBorrar);

        switch (value){
            case 0: //cuadrado
                titulo.setText(getResources().getString(R.string.area1).toUpperCase());
                TextView label = new TextView(this);
                label.setGravity(Gravity.CENTER_VERTICAL);
                label.setText(getResources().getString(R.string.lblcuadrado));

                EditText txtValue = new EditText(this);
                txtValue.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(label);
                content.addView(txtValue);
                break;

            case 1:
                titulo.setText(getResources().getString(R.string.area2).toUpperCase());
                TextView lblbase = new TextView(this);
                lblbase.setGravity(Gravity.CENTER_VERTICAL);
                lblbase.setText(getResources().getString(R.string.lblbase));

                TextView lblaltura = new TextView(this);
                lblaltura.setGravity(Gravity.CENTER_VERTICAL);
                lblaltura.setText(getResources().getString(R.string.lblaltura));

                EditText txtBase = new EditText(this);
                txtBase.setGravity(Gravity.CENTER_VERTICAL);

                EditText txtAltura = new EditText(this);
                txtAltura.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblbase);
                content.addView(txtBase);
                content.addView(lblaltura);
                content.addView(txtAltura);
                break;

            case 2:
                titulo.setText(getResources().getString(R.string.area3).toUpperCase());
                TextView lblbaseT = new TextView(this);
                lblbaseT.setGravity(Gravity.CENTER_VERTICAL);
                lblbaseT.setText(getResources().getString(R.string.lblbase));

                TextView lblalturaT = new TextView(this);
                lblalturaT.setGravity(Gravity.CENTER_VERTICAL);
                lblalturaT.setText(getResources().getString(R.string.lblaltura));

                EditText txtBaseT = new EditText(this);
                txtBaseT.setGravity(Gravity.CENTER_VERTICAL);

                EditText txtAlturaT = new EditText(this);
                txtAlturaT.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblbaseT);
                content.addView(txtBaseT);
                content.addView(lblalturaT);
                content.addView(txtAlturaT);
                break;

            case 3:
                titulo.setText(getResources().getString(R.string.area4).toUpperCase());
                TextView lblradio = new TextView(this);
                lblradio.setGravity(Gravity.CENTER_VERTICAL);
                lblradio.setText(getResources().getString(R.string.lblradio));

                EditText txtRadio = new EditText(this);
                txtRadio.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblradio);
                content.addView(txtRadio);
                break;
        }

        content.addView(lytButtons);
    }
}