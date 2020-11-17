package com.example.vistas;

public class Registro {

    private String id;
    private String operacion;
    private String datos;
    private String resultado;
    private static Integer numid=0;

    public Registro(String operacion, String datos, String resultado) {
        this.numid++;
        this.id = Integer.toString(numid);
        this.operacion = operacion;
        this.datos = datos;
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void guardar(){
        Datos.guardar(this);
    }
}
