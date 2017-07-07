package com.example.claudiopc.trigar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction Transacciones;
    FragmentManager Manejador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Manejador = getSupportFragmentManager();

       PantallainicioFragment p = new PantallainicioFragment();
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(android.R.id.content, p, "UN_TAG");
        tx.commit();

    }


    public void changeFragment(Fragment f) {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(android.R.id.content, f, "UN_TAG");
        tx.commit();

    }
    public void Volver(){
       CotizacionesFragment Dato = new CotizacionesFragment();

        Transacciones = Manejador.beginTransaction();
        Transacciones.replace(R.id.container, Dato);
        Transacciones.commit();
    }

}



