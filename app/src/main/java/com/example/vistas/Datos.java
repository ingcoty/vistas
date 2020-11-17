package com.example.vistas;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Registro> registros = new ArrayList();

    public static void guardar(Registro reg){
        registros.add(reg);
    }

    public static ArrayList<Registro> obtener(){
        return registros;
    }
}
