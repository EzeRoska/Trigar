package com.example.claudiopc.trigar;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;


/**
 * Created by Usuario on 30/06/2017.
 */

public class Movimiento  {
    Basededatos accesoBaseproyecto;
    SQLiteDatabase baseDatos;

    int Fecha;
    String Lote;
    int Cantidad;
    String grano;

    public Movimiento() {
        // Required empty public constructor
    }

    public Movimiento(int fecha, String lote, int cantidad, String grano) {
        Fecha = fecha;
        Lote = lote;
        Cantidad = cantidad;
        this.grano = grano;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int fecha) {
        Fecha = fecha;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String lote) {
        Lote = lote;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getGrano() {
        return grano;
    }

    public void setGrano(String grano) {
        this.grano = grano;
    }
}



