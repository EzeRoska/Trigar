package com.example.claudiopc.trigar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction Transacciones;
    FragmentManager Manejador;
    ArrayList<String> datos = new ArrayList<>();
    Basededatos acceso;
/*
    public ArrayList<String> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }

    public void addDatos(String datos) {
        this.datos.add(datos);

    }
*/
    SQLiteDatabase bd;

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

        Log.d("FELIPE","changeFragment");
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(android.R.id.content, f, "UN_TAG");
        tx.commit();

    }
    public void Volver(){
       PantallainicioFragment inicio = new PantallainicioFragment();
        Transacciones = Manejador.beginTransaction();
        Transacciones.replace(R.id.container, inicio);
        Transacciones.commit();
    }
    public boolean connectToDatabase()
    {
        acceso = new Basededatos(this, "Basededatos", null, 1);
        bd = acceso.getWritableDatabase();
        if (bd != null)
        {
            return true;
        }
        return false;

    }
    ArrayList<Movimiento> mostrarCampos(String filtro)
    {
        ArrayList<Movimiento>Lista= new ArrayList<>();
        Movimiento m;
        if (connectToDatabase())
        {
            Cursor cursor;
            if (filtro.length() > 0 )
                cursor = bd.rawQuery("SELECT Fecha, Grano,EntradaSalida,Cantidad,Lote FROM Movimiento where grano='"+filtro+"'", null);
            else
                cursor = bd.rawQuery("SELECT Fecha, Lote,Grano, Cantidad, EntradaSalida FROM Movimiento", null);

            if (cursor.moveToFirst()){
                do {
                    String fecha = cursor.getString(0);
                    String Lote = cursor.getString(1);
                    String grano = cursor.getString(2);
                    int Cantidad =cursor.getInt(3);
                    String EntradaSalida = cursor.getString(4);



                   // m = Lista<>(fecha,Lote,grano,Cantidad,EntradaSalida);
                    //Lista.add(m);



                    /*
                    int convert= cursor.getInt(0);
                    String Fechas = String.valueOf(convert);
                    Lista.add(Fechas);
                    Lista.add(cursor.getString(1));
                    //Campos.add(cursor.getString(2));
                    int convert2 = cursor.getInt(3);
                    String Cantidades = String.valueOf(convert2);
                    Lista.add(Cantidades);
                    Lista.add(cursor.getString(4));
                    */
                }while (cursor.moveToNext());
            }

        }
        bd.close();
        return Lista;
    }


}



