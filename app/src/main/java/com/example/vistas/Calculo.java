package com.example.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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

        EditText txtValue = new EditText(this);
        txtValue.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        EditText txtBase = new EditText(this);
        txtBase.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        EditText txtAltura = new EditText(this);
        txtAltura.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        EditText txtBaseT = new EditText(this);
        txtBaseT.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        EditText txtAlturaT = new EditText(this);
        txtAlturaT.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        EditText txtRadio = new EditText(this);
        txtRadio.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        EditText txtProfundidad = new EditText(this);
        txtProfundidad.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        TextView lblradio = new TextView(this);
        TextView lblaltura = new TextView(this);
        TextView lblprofundidad = new TextView(this);
        TextView lblbase = new TextView(this);
        TextView lblbaseT = new TextView(this);

        if(value <= 3) param.putInt("show", 0);
        else param.putInt("show", 1);
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
                            String operacion = getResources().getString(R.string.operacion) + getResources().getString(R.string.area1);
                            String datos = getResources().getString(R.string.lblcuadrado) + " " + txtValue.getText();
                            Registro registro = new Registro(operacion, datos, String.format("%.2f", area));
                            registro.guardar();
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 1:
                titulo.setText(getResources().getString(R.string.area2).toUpperCase());
                lblbase.setGravity(Gravity.CENTER_VERTICAL);
                lblbase.setText(getResources().getString(R.string.lblbase));

                //TextView lblaltura = new TextView(this);
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
                            String operacion = getResources().getString(R.string.operacion) + getResources().getString(R.string.area2);
                            String datos = getResources().getString(R.string.lblbase) + ": " + txtBase.getText() + "\n";
                            datos += getResources().getString(R.string.lblaltura) + ": " + txtAltura.getText();
                            Registro registro = new Registro(operacion, datos, String.format("%.2f", area));
                            registro.guardar();
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 2:
                titulo.setText(getResources().getString(R.string.area3).toUpperCase());

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
                            String operacion = getResources().getString(R.string.operacion) + getResources().getString(R.string.area3);
                            String datos = getResources().getString(R.string.lblbase) + ": " + txtBaseT.getText() + "\n";
                            datos += getResources().getString(R.string.lblaltura) + ": " + txtAlturaT.getText();
                            Registro registro = new Registro(operacion, datos, String.format("%.2f", area));
                            registro.guardar();
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 3:
                titulo.setText(getResources().getString(R.string.area4).toUpperCase());

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
                            String operacion = getResources().getString(R.string.operacion) + getResources().getString(R.string.area4);
                            String datos = getResources().getString(R.string.lblradio) + ": " + txtRadio.getText();
                            Registro registro = new Registro(operacion, datos, String.format("%.2f", area));
                            registro.guardar();
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 4:
                titulo.setText(getResources().getString(R.string.vol1).toUpperCase());
                lblradio.setGravity(Gravity.CENTER_VERTICAL);
                lblradio.setText(getResources().getString(R.string.lblradio));

                txtRadio.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblradio);
                content.addView(txtRadio);

                btnCalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(txtRadio.getText().toString().isEmpty()){
                            txtRadio.setError(getResources().getString(R.string.lblradio));
                            txtRadio.requestFocus();
                        }
                        else {
                            double radio = Double.parseDouble(txtRadio.getText().toString());
                            double volume = (4/3) * Math.PI * (radio * radio* radio);
                            param.putDouble("area", volume);
                            param.putString("title", getResources().getString(R.string.vol1).toUpperCase());
                            intent.putExtras(param);
                            String operacion = getResources().getString(R.string.operacionVolume) + getResources().getString(R.string.vol1);
                            String datos = getResources().getString(R.string.lblradio) + ": " + txtRadio.getText();
                            Registro registro = new Registro(operacion, datos, String.format("%.2f", volume));
                            registro.guardar();
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 5:
                titulo.setText(getResources().getString(R.string.vol2).toUpperCase());
                lblradio.setGravity(Gravity.CENTER_VERTICAL);
                lblradio.setText(getResources().getString(R.string.lblradio));

                lblaltura.setGravity(Gravity.CENTER_VERTICAL);
                lblaltura.setText(getResources().getString(R.string.lblaltura));

                txtRadio.setGravity(Gravity.CENTER_VERTICAL);
                txtAltura.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblradio);
                content.addView(txtRadio);
                content.addView(lblaltura);
                content.addView(txtAltura);

                btnCalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(txtRadio.getText().toString().isEmpty()){
                            txtRadio.setError(getResources().getString(R.string.errcuadrado));
                            txtRadio.requestFocus();
                        }
                        else if(txtAltura.getText().toString().isEmpty()){
                            txtAltura.setError(getResources().getString(R.string.errcuadrado));
                            txtAltura.requestFocus();
                        }
                        else {
                            double radio = Double.parseDouble(txtRadio.getText().toString());
                            double altura = Double.parseDouble((txtAltura.getText().toString()));
                            double volume = Math.PI * radio * radio * altura;
                            param.putDouble("area", volume);
                            param.putString("title", getResources().getString(R.string.vol2).toUpperCase());
                            intent.putExtras(param);
                            String operacion = getResources().getString(R.string.operacionVolume) + getResources().getString(R.string.vol2);
                            String datos = getResources().getString(R.string.lblradio) + ": " + txtRadio.getText() + "\n";
                            datos += getResources().getString(R.string.lblaltura) + ": " + txtAltura.getText();
                            Registro registro = new Registro(operacion, datos, String.format("%.2f", volume));
                            registro.guardar();
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 6:
                titulo.setText(getResources().getString(R.string.vol3).toUpperCase());
                lblradio.setGravity(Gravity.CENTER_VERTICAL);
                lblradio.setText(getResources().getString(R.string.lblradio));

                lblaltura.setGravity(Gravity.CENTER_VERTICAL);
                lblaltura.setText(getResources().getString(R.string.lblaltura));

                txtRadio.setGravity(Gravity.CENTER_VERTICAL);
                txtAltura.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblradio);
                content.addView(txtRadio);
                content.addView(lblaltura);
                content.addView(txtAltura);

                btnCalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(txtRadio.getText().toString().isEmpty()){
                            txtRadio.setError(getResources().getString(R.string.errcuadrado));
                            txtRadio.requestFocus();
                        }
                        else if(txtAltura.getText().toString().isEmpty()){
                            txtAltura.setError(getResources().getString(R.string.errcuadrado));
                            txtAltura.requestFocus();
                        }
                        else {
                            double radio = Double.parseDouble(txtRadio.getText().toString());
                            double altura = Double.parseDouble((txtAltura.getText().toString()));
                            double volume = Math.PI * radio * radio * altura/3;
                            param.putDouble("area", volume);
                            param.putString("title", getResources().getString(R.string.vol3).toUpperCase());
                            intent.putExtras(param);
                            String operacion = getResources().getString(R.string.operacionVolume) + getResources().getString(R.string.vol3);
                            String datos = getResources().getString(R.string.lblradio) + ": " + txtRadio.getText() + "\n";
                            datos += getResources().getString(R.string.lblaltura) + ": " + txtAltura.getText();
                            Registro registro = new Registro(operacion, datos, String.format("%.2f", volume));
                            registro.guardar();
                            startActivity(intent);
                        }
                    }
                });

                break;

            case 7:
                titulo.setText(getResources().getString(R.string.vol4).toUpperCase());
                lblbase.setGravity(Gravity.CENTER_VERTICAL);
                lblbase.setText(getResources().getString(R.string.lblbase));

                lblaltura.setGravity(Gravity.CENTER_VERTICAL);
                lblaltura.setText(getResources().getString(R.string.lblaltura));

                lblprofundidad.setGravity(Gravity.CENTER_VERTICAL);
                lblprofundidad.setText(getResources().getString(R.string.lblprofundidad));

                txtRadio.setGravity(Gravity.CENTER_VERTICAL);
                txtAltura.setGravity(Gravity.CENTER_VERTICAL);
                txtProfundidad.setGravity(Gravity.CENTER_VERTICAL);

                content.addView(lblbase);
                content.addView(txtBase);
                content.addView(lblaltura);
                content.addView(txtAltura);
                content.addView(lblprofundidad);
                content.addView(txtProfundidad);

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
                        else if(txtProfundidad.getText().toString().isEmpty()){
                            txtProfundidad.setError(getResources().getString(R.string.errcuadrado));
                            txtProfundidad.requestFocus();
                        }
                        else {
                            double radio = Double.parseDouble(txtBase.getText().toString());
                            double altura = Double.parseDouble((txtAltura.getText().toString()));
                            double profundidad = Double.parseDouble((txtProfundidad.getText().toString()));
                            double volume = radio*altura*profundidad;
                            param.putDouble("area", volume);
                            param.putString("title", getResources().getString(R.string.vol4).toUpperCase());
                            intent.putExtras(param);
                            String operacion = getResources().getString(R.string.operacion) + getResources().getString(R.string.vol4);
                            String datos = getResources().getString(R.string.lblbase) + ": " + txtBase.getText() + "\n";
                            datos += getResources().getString(R.string.lblaltura) + ": " + txtAltura.getText() + "\n";
                            datos += getResources().getString(R.string.lblprofundidad) + ": " + txtProfundidad.getText();
                            Registro registro = new Registro(operacion, datos, String.format("%.2f", volume));
                            registro.guardar();
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
                txtProfundidad.setText("");
            }
        });

    }
}