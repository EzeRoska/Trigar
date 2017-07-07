package com.example.claudiopc.trigar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Usuario on 30/06/2017.
 */

public class Basededatos extends SQLiteOpenHelper {

    public  Basededatos(Context contexto, String nombre, SQLiteDatabase.CursorFactory fabrica, int Version){
        super(contexto,nombre,fabrica,Version);
    }
    @Override
    public void onCreate(SQLiteDatabase baseDeDatos)
    {
        Log.d("SQLite","Declaro e inicializo la variable para crear la tabla Login");
        String sqlCrearTablaLogin;
        sqlCrearTablaLogin="create table Login(Usuario text,Contraseña text)";

        Log.d("SQLite","invoca al creador de la tabla");
        baseDeDatos.execSQL(sqlCrearTablaLogin);
        Log.d("SQLite"," fin de la creacion de la tabla Login");

        Log.d("SQLite","Declaro e inicializo la variable para crear la tabla Movimiento");
        String sqlCrearTablaMovimiento;
        sqlCrearTablaMovimiento=" create table Movimiento(Id integer, Fecha integer, Grano text,EntradaSalida text,Cantidad integer,Lote text)";

        Log.d("SQLite","invoca al creador de la tabla");
        baseDeDatos.execSQL(sqlCrearTablaMovimiento);
        Log.d("SQLite"," fin de la creacion de la tabla Movimiento");

        Log.d("SQLite","Declaro e inicializo la variable para crear la tabla Cotizaciones");
        String sqlCrearTablaCotizaciones;
        sqlCrearTablaCotizaciones=" create table Cotizaciones(Id integer, Fecha integer, Importe integer,Tipo boolean)";

        Log.d("SQLite","invoca al creador de la tabla");
        baseDeDatos.execSQL(sqlCrearTablaCotizaciones);
        Log.d("SQLite"," fin de la creacion de la tabla Cotizaciones");

        Log.d("SQLite","Declaro e inicializo la variable para crear la tabla Mi Bolsillo");
        String sqlCrearTablaMiBolsillo;
        sqlCrearTablaMiBolsillo="create table MiBolsillo(Id integer, Trigo text,Cebada text, Maiz text,Soja text,ConImpuesto boolean, SinImpuesto boolean)";

        Log.d("SQLite","invoca al creador de la tabla");
        baseDeDatos.execSQL(sqlCrearTablaMiBolsillo);
        Log.d("SQLite"," fin de la creacion de la tabla MiBolsillo");
    }
    @Override
    public void onUpgrade(SQLiteDatabase baseDeDatos, int versionAnterior, int versionNueva)
    {
        Log.d("SQLite"," on upgrade");
    }
}


