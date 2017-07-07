package com.example.claudiopc.trigar;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


public class Movimiento extends AppCompatActivity{
    float Fecha;
    float Lote;
    int Cantidad;
    String Grano;

    public Movimiento(float Fecha , float Lote , int Cantidad , String Grano) {
        this.Fecha = Fecha;
        this.Lote = Lote;
        this.Cantidad = Cantidad;
        this.Grano = Grano;
    }

    public float getFecha()
    {

        return Fecha;

    }

    public float getLote()
    {
        return Lote;

    }
    public int getCantidad()
    {
        return Cantidad;
    }
    public String getGrano()
    {
        return Grano;

    }

    public void btnGuardar(View VistaR) {
        EditText fecha = (EditText) VistaR.findViewById(R.id.edFecha);
        String Fecha = fecha.getText().toString();

        EditText lote = (EditText) VistaR.findViewById(R.id.edLote);
        String Lote = fecha.getText().toString();

        EditText cantidad = (EditText) VistaR.findViewById(R.id.edCant);
        String Cantidad = fecha.getText().toString();
        Integer cant = Integer.parseInt(Cantidad);

        Spinner grano = (Spinner) VistaR.findViewById(R.id.spGrano);
        String Grano = grano.getSelectedItem().toString();

        Bundle paqueteDatos = new Bundle();
        paqueteDatos.putString("Fecha", Fecha);
        paqueteDatos.putString("Lote", Lote);
        paqueteDatos.putInt("Cantidad", cant);
        paqueteDatos.putString("Grano", Grano);
        Intent IrAFragment = new Intent(VistaR.getContext(), listaMovimiento.class);
        IrAFragment.putExtras(paqueteDatos);


        listaMovimiento lm = new listaMovimiento();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(android.R.id.content, lm, "UN_TAG");
        tx.commit();



    }
}
