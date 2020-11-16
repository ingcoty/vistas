package com.example.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Calculo extends AppCompatActivity {

    private TextView titulo;
    private LinearLayout content;
    private Intent intent;

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

        intent = new Intent(Calculo.this, Resultado.class);
        Bundle param = new Bundle();
        param.putInt("show", 0);

        EditText txtValue = new EditText(this);
        EditText txtBase = new EditText(this);
        EditText txtAltura = new EditText(this);
        EditText txtBaseT = new EditText(this);
        EditText txtAlturaT = new EditText(this);
        EditText txtRadio = new EditText(this);

        switch (value){
            case 0: //cuadrado
                titulo.setText(getResources().getString(R.string.area1).toUpperCase());
                TextView label = new TextView(this);
                label.setGravity(Gravity.CENTER_VERTICAL);
                label.setText(getResources().getString(R.string.lblcuadrado));

                txtValue.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(label);
                content.addView(txtValue);

                btnCalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(txtValue.getText().toString().isEmpty()){
                            txtValue.setError(getResources().getString(R.string.errcuadrado));
                            txtValue.requestFocus();
                        }
                        else {
                            double lado = Double.parseDouble(txtValue.getText().toString());
                            double area = lado * lado;
                            param.putDouble("area", area);
                            param.putString("title", getResources().getString(R.string.area1).toUpperCase());
                            intent.putExtras(param);
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 1:
                titulo.setText(getResources().getString(R.string.area2).toUpperCase());
                TextView lblbase = new TextView(this);
                lblbase.setGravity(Gravity.CENTER_VERTICAL);
                lblbase.setText(getResources().getString(R.string.lblbase));

                TextView lblaltura = new TextView(this);
                lblaltura.setGravity(Gravity.CENTER_VERTICAL);
                lblaltura.setText(getResources().getString(R.string.lblaltura));

                txtBase.setGravity(Gravity.CENTER_VERTICAL);
                txtAltura.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblbase);
                content.addView(txtBase);
                content.addView(lblaltura);
                content.addView(txtAltura);

                btnCalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(txtBase.getText().toString().isEmpty()){
                            txtBase.setError(getResources().getString(R.string.errcuadrado));
                            txtBase.requestFocus();
                        }
                        else if(txtAltura.getText().toString().isEmpty()){
                            txtAltura.setError(getResources().getString(R.string.errcuadrado));
                            txtAltura.requestFocus();
                        }
                        else {
                            double base = Double.parseDouble(txtBase.getText().toString());
                            double altura = Double.parseDouble((txtAltura.getText().toString()));
                            double area = base * altura;
                            param.putDouble("area", area);
                            param.putString("title", getResources().getString(R.string.area2).toUpperCase());
                            intent.putExtras(param);
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 2:
                titulo.setText(getResources().getString(R.string.area3).toUpperCase());
                TextView lblbaseT = new TextView(this);
                lblbaseT.setGravity(Gravity.CENTER_VERTICAL);
                lblbaseT.setText(getResources().getString(R.string.lblbase));

                TextView lblalturaT = new TextView(this);
                lblalturaT.setGravity(Gravity.CENTER_VERTICAL);
                lblalturaT.setText(getResources().getString(R.string.lblaltura));


                txtBaseT.setGravity(Gravity.CENTER_VERTICAL);
                txtAlturaT.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblbaseT);
                content.addView(txtBaseT);
                content.addView(lblalturaT);
                content.addView(txtAlturaT);

                btnCalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(txtBaseT.getText().toString().isEmpty()){
                            txtBaseT.setError(getResources().getString(R.string.errcuadrado));
                            txtBaseT.requestFocus();
                        }
                        else if(txtAlturaT.getText().toString().isEmpty()){
                            txtAlturaT.setError(getResources().getString(R.string.errcuadrado));
                            txtAlturaT.requestFocus();
                        }
                        else {
                            double base = Double.parseDouble(txtBaseT.getText().toString());
                            double altura = Double.parseDouble(txtAlturaT.getText().toString());
                            double area = base * altura / 2;
                            param.putDouble("area", area);
                            param.putString("title", getResources().getString(R.string.area3).toUpperCase());
                            intent.putExtras(param);
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 3:
                titulo.setText(getResources().getString(R.string.area4).toUpperCase());
                TextView lblradio = new TextView(this);
                lblradio.setGravity(Gravity.CENTER_VERTICAL);
                lblradio.setText(getResources().getString(R.string.lblradio));

                txtRadio.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblradio);
                content.addView(txtRadio);

                btnCalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(txtRadio.getText().toString().isEmpty()){
                            txtRadio.setError(getResources().getString(R.string.errcuadrado));
                            txtRadio.requestFocus();
                        }
                        else {
                            double radio = Double.parseDouble(txtRadio.getText().toString());
                            double area = Math.PI * (radio * radio);
                            param.putDouble("area", area);
                            param.putString("title", getResources().getString(R.string.area4).toUpperCase());
                            intent.putExtras(param);
                            startActivity(intent);
                        }
                    }
                });

                break;
        }

        content.addView(lytButtons);

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtValue.setText("");
                txtBase.setText("");
                txtAltura.setText("");
                txtBaseT.setText("");
                txtAlturaT.setText("");
                txtRadio.setText("");
            }
        });

    }
}