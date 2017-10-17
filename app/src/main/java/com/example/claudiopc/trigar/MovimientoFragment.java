package com.example.claudiopc.trigar;



import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MovimientoFragment extends Fragment implements View.OnClickListener {

    RssHandler a;
    TextView txtFecha;
    TextView txtLote;
    TextView txtCantidad;
    Switch EntradaSalida;
    Boolean EntradaOSalida;
    Spinner txtGrano;
    String tipoGrano;
    String  Fecha;
    String Lote;
    int Cantidad;
    SQLiteDatabase baseDatos;
    Basededatos accesoBaseproyecto;
    MainActivity activity;
    Calendar peti;
    int convertircotizaciontrigo;
    int convertircotizacionMaiz;
    int convertircotizacionSoja;
    int convertircotizacionCebada;
    String cotizaciontrigo;
    String cotizacionMaiz;
    String cotizacionCebada;
    String cotizacionSoja;
    int MultiplicarTrigo;
    int MultiplicarSoja;
    int MultiplicarMaiz;
    int MultiplicarCebada;
//a.cotiztrigo y asi con cada tipo multiplicarlo por la cantidad que ingresa.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Vista=inflater.inflate(R.layout.fragment_movimiento,container,false);
        Button Calendario = (Button) Vista.findViewById(R.id.BotonCalendario);
        Calendario.setOnClickListener(this);
        // Button guardar=(Button)Vista.findViewById(R.id.botonGuardar);
        //guardar.setOnClickListener(this);
        activity = (MainActivity)getActivity();
        Button btnVolver = (Button)Vista.findViewById(R.id.btnVolverMovimiento);
        Button btnGuardar = (Button)Vista.findViewById(R.id.botonGuardar);
        btnVolver.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                listaMovimiento LMF = new listaMovimiento();
                activity.changeFragment(LMF);

            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lote=txtLote.getText().toString();
                Cantidad=Integer.parseInt(String.valueOf(txtCantidad.getText()));
                EntradaOSalida=EntradaSalida.isChecked();
                tipoGrano=txtGrano.getSelectedItem().toString();
                insertar(Fecha,Lote,Cantidad,EntradaOSalida,tipoGrano);

            }
        });


        txtCantidad=(TextView)Vista.findViewById(R.id.edCant);
        txtLote=(TextView) Vista.findViewById(R.id.edLote);
        EntradaSalida=(Switch) Vista.findViewById(R.id.switch1);
        txtGrano=(Spinner) Vista.findViewById(R.id.spGrano);

        MainActivity myParent = (MainActivity)getActivity();
        peti = Calendar.getInstance();
        peti.add(Calendar.DATE,1);
/*
        String Fecha ="como recibo mis datos de la BD, ";
        myParent.addDatos(Fecha);
        String Lote = "";
        myParent.addDatos(Lote);
        String Cantidad = "";
        myParent.addDatos(Cantidad);
        String tipoGrano = "";
        myParent.addDatos(tipoGrano);
        String EntradaOSalida = "";
        myParent.addDatos(EntradaOSalida);
*/
        // Calendario=(CalendarView) Vista.findViewById(R.id.Calendarioo);

        return Vista;
    }
    /*public void SelectBD()

    {
        if(baseDeDatosAbierta() == true)
        {
            Cursor conjuntoderegistros;
            conjuntoderegistros=baseDatos.rawQuery("select * from Movimiento",null);
            if(conjuntoderegistros.moveToFirst()==true){
                int cantidadregistros=0;
                do {
                    cantidadregistros++;

                    String Fechaa=conjuntoderegistros.getString(0);
                    listaMovimiento Objeto = new listaMovimiento();
                    Objeto.adapter.add(Fechaa);

                        String Lotee=conjuntoderegistros.getString(1);
                     Objeto = new listaMovimiento();
                    Objeto.adapter.add(Lotee);

                    String Granoo=conjuntoderegistros.getString(2);
                     Objeto = new listaMovimiento();
                    Objeto.adapter.add(Granoo);

                    String Cantidadd=conjuntoderegistros.getString(3);
                     Objeto = new listaMovimiento();
                    Objeto.adapter.add(Cantidadd);

                    String EntradaSalidaa=conjuntoderegistros.getString(4);
                     Objeto = new listaMovimiento();
                    Objeto.adapter.add(EntradaSalidaa);
                }
                while (conjuntoderegistros.moveToNext()==true);
            }
        }
    }*/





    @Override
    public void onClick(View Vista) {
        Log.d("probando", "clickeado" + Vista.getId());
        switch (Vista.getId()) {
            case R.id.BotonCalendario:
                DatePickerDialog dp = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        peti.set(year,month,dayOfMonth);
                        Fecha = peti.get(Calendar.DAY_OF_MONTH) + "/" + peti.get(Calendar.MONTH)+ "/"+ peti.get(Calendar.YEAR);

                    }
                },peti.get(Calendar.DAY_OF_MONTH),peti.get(Calendar.MONTH),peti.get(Calendar.YEAR));
                dp.getDatePicker().setMinDate(peti.getTimeInMillis());
                dp.show();
                break;

            case R.id.botonGuardar:
                Lote=txtLote.getText().toString();
                Cantidad=Integer.parseInt(String.valueOf(txtCantidad.getText()));
                EntradaOSalida=EntradaSalida.isChecked();
                tipoGrano=txtGrano.getSelectedItem().toString();
                insertar(Fecha , Lote ,Cantidad, EntradaOSalida, tipoGrano);

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