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

    String Fecha;
    String Lote;
    int Cantidad;
    String Grano;
    String EntradaSalid;

    public Movimiento() {
        // Required empty public constructor
    }

    public Movimiento(String fecha, String lote,String grano, int cantidad, String EntradaSalida) {
        Fecha = fecha;
        Lote = lote;
        Grano = grano;
        Cantidad = cantidad;
        EntradaSalid = EntradaSalida;
        //this.grano = grano;
    }

    public String getFecha() {
        return Fecha;
    }
    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getLote() {
        return Lote;
    }
    public void setLote(String lote) {
        Lote = lote;
    }

    public String getgrano() {return Grano;}
    public void setGrano (String grano) {Grano = grano;}

    public int getCantidad() {return Cantidad;}
    public void setCantidad(int cantidad) {Cantidad = cantidad;}

    public String getEntradaSalida(){return EntradaSalid;}
    public void setEntradaSalid(String EntradaSalida ) {EntradaSalid = EntradaSalida;}





}






