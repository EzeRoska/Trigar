package com.example.claudiopc.trigar;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Usuario on 30/06/2017.
 */

public class MovimientoFragment extends Fragment implements View.OnClickListener {

    TextView txtFecha;
    TextView txtLote;
    TextView txtCantidad;
    Switch EntradaSalida;
    Boolean EntradaOSalida;
    Spinner txtGrano;
    String tipoGrano;
    String Fecha;
    String Lote;
    int Cantidad;
    SQLiteDatabase baseDatos;
    Basededatos accesoBaseproyecto;
    MainActivity activity;
    CalendarView calendari;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Vista=inflater.inflate(R.layout.fragment_movimiento,container,false);
        Button guardar=(Button)Vista.findViewById(R.id.botonGuardar);
        guardar.setOnClickListener(this);
        activity = (MainActivity)getActivity();
        Button btnVolver = (Button)Vista.findViewById(R.id.btnVolverMovimiento);
        btnVolver.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                listaMovimiento LMF = new listaMovimiento();
                activity.changeFragment(LMF);

            }
        });
        txtFecha=(TextView)Vista.findViewById(R.id.edFecha);
        txtCantidad=(TextView)Vista.findViewById(R.id.edCant);
        txtLote=(TextView) Vista.findViewById(R.id.edLote);
        EntradaSalida=(Switch) Vista.findViewById(R.id.switch1);
        txtGrano=(Spinner) Vista.findViewById(R.id.spGrano);
        calendari=(CalendarView) Vista.findViewById(R.id.Calendar);
        return Vista;
    }
    @Override
    public void onClick(View Vista) {
        switch (Vista.getId()) {
            case R.id.botonGuardar:
                SimpleDateFormat calendario=new SimpleDateFormat("dd/MM/yyyy");
                Fecha=calendario.format(new Date((calendari.getDate())));
                Lote=txtLote.getText().toString();
        Cantidad=Integer.parseInt(String.valueOf(txtCantidad.getText()));
                EntradaOSalida=EntradaSalida.isChecked();
                tipoGrano=txtGrano.getSelectedItem().toString();
                insertar(Fecha,Lote,Cantidad,EntradaOSalida,tipoGrano);
                break;
        }

    }


    public  void insertar (String Fecha, String Lote, int Cantidad,boolean EntradaOsalida,String tipoGrano) {
        if (baseDeDatosAbierta()) {
            ContentValues nuevoRegistro;
            nuevoRegistro = new ContentValues();
            nuevoRegistro.put("Fecha", Fecha);
            nuevoRegistro.put("Lote", Lote);
            nuevoRegistro.put("Cantidad", Cantidad);
            nuevoRegistro.put("EntradaSalida", EntradaOsalida?"E":"S");
            nuevoRegistro.put("Grano",tipoGrano);
            baseDatos.insert("Movimiento", null, nuevoRegistro);
        }
        baseDatos.close();
    }

    private boolean baseDeDatosAbierta() {
        boolean responder;
        accesoBaseproyecto = new Basededatos(getActivity(), "Basededatos", null, 1);
        baseDatos = accesoBaseproyecto.getWritableDatabase();
        if (baseDatos != null) {
            responder = true;
        }
        else {
            responder = false;
        }
        return responder;

    }
}


/*
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

*/



