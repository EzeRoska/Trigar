package com.example.claudiopc.trigar;

        import android.app.Activity;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.Spinner;
        import android.widget.TextView;

        import org.w3c.dom.Text;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Calendar;
        import java.util.List;


public class MiBolsilloFrag extends Fragment {
    RssHandler a;
    SQLiteDatabase baseDatos;
    Basededatos accesoBaseproyecto;
    int[] Vec = new int[4];
  int cantidadtrigo;
    int cantidadmaiz;
    int cantidadsoja;
    int cantidadcebada;
    MovimientoFragment b;
    MainActivity activity;
    float cotizaciontrigo;
    float cotizacionmaiz;
    float cotizacionsoja;
    float cotizacioncebada;
    float totaltrigo;
    float totalmaiz;
    float totalsoja;
    float totalcebada;
    RssHandler Objeto = new RssHandler();

    //cantidad,grano,entradasalidaformmovimiento
    //&& conjuntoderegistros.getstring(2).compareto(E")==0
    //VEC+
    //EL ULTIMO SIN IF
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Vista = inflater.inflate(R.layout.fragment_mi_bolsillo, container, false);
        TextView txtcantidadTrigo = (TextView) Vista.findViewById(R.id.TrigoCant);
        TextView txtcantidadMaiz = (TextView) Vista.findViewById(R.id.MaizCant);
        TextView txtcantidadSoja = (TextView) Vista.findViewById(R.id.SojaCant);
        TextView txtcantidadCebada = (TextView) Vista.findViewById(R.id.CebadaCant);
        TextView txtCotizTrigo = (TextView) Vista.findViewById(R.id.TrigoCotiz);
        TextView txtCotizMaiz = (TextView) Vista.findViewById(R.id.MaizCotiz);
        TextView txtCotizSoja = (TextView) Vista.findViewById(R.id.SojaCotiz);
        TextView txtCotizCebada = (TextView) Vista.findViewById(R.id.CebadaCotiz);
        TextView txttotaltrigo=(TextView) Vista.findViewById(R.id.TrigoTotal);
        TextView txttotalmaiz=(TextView) Vista.findViewById(R.id.MaizTotal);
        TextView txttotalsoja=(TextView) Vista.findViewById(R.id.SojaTotal);
        TextView txttotalcebada=(TextView) Vista.findViewById(R.id.CebadaTotal);
        activity = (MainActivity)getActivity();
        Button btnVolver = (Button)Vista.findViewById(R.id.btnVolverMibolsillo);
        btnVolver.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                PantallainicioFragment PIf = new PantallainicioFragment();
                activity.changeFragment(PIf);

            }
        });
        //Log.d("Trigo", Objeto.DevolverTrigo());
        if (baseDeDatosAbierta()) {
            Cursor conjuntoderegistros;
            conjuntoderegistros = baseDatos.rawQuery("select Cantidad, Grano,EntradaSalida From Movimiento", null);
            if (conjuntoderegistros.moveToFirst() == true) {
                do {
                    if (conjuntoderegistros.getString(1).compareTo("Trigo") == 0 && conjuntoderegistros.getString(2).compareTo("E") == 0) {
                        //txtTrigo.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                       cantidadtrigo += conjuntoderegistros.getInt(0);
                    } else if (conjuntoderegistros.getString(1).compareTo("Trigo") == 0 && conjuntoderegistros.getString(2).compareTo("S") == 0) {
                        //txtTrigo.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        cantidadtrigo -= conjuntoderegistros.getInt(0);

                    } else if (conjuntoderegistros.getString(1).compareTo("Maiz") == 0 && conjuntoderegistros.getString(2).compareTo("E") == 0) {
                        //txtTrigo.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        cantidadmaiz += conjuntoderegistros.getInt(0);
                    } else if (conjuntoderegistros.getString(1).compareTo("Maiz") == 0 && conjuntoderegistros.getString(2).compareTo("S") == 0) {
                        //txtTrigo.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        cantidadmaiz -= conjuntoderegistros.getInt(0);
                    } else if (conjuntoderegistros.getString(1).compareTo("Soja") == 0 && conjuntoderegistros.getString(2).compareTo("E") == 0) {
                        //txtTrigo.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        cantidadsoja += conjuntoderegistros.getInt(0);
                    } else if (conjuntoderegistros.getString(1).compareTo("Soja") == 0 && conjuntoderegistros.getString(2).compareTo("S") == 0) {
                        //txtTrigo.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        cantidadsoja -= conjuntoderegistros.getInt(0);
                    } else if (conjuntoderegistros.getString(1).compareTo("Cebada") == 0 && conjuntoderegistros.getString(2).compareTo("E") == 0) {
                        //txtTrigo.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        cantidadcebada+= conjuntoderegistros.getInt(0);
                    } else {
                        //txtTrigo.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        cantidadcebada -= conjuntoderegistros.getInt(0);
                    }

                }
                while (conjuntoderegistros.moveToNext() == true);

            }


            Cursor conjuntoderegistros2;

            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //Calendar cal = Calendar.getInstance();
            //String Fecha= dateFormat.format(cal); //2016/11/16 12:08:43


            conjuntoderegistros2 = baseDatos.rawQuery("select CotizacionTrigo,CotizacionMaiz,CotizacionSoja,CotizacionCebada  From Cotizaciones", null);
            if (conjuntoderegistros2.moveToFirst() == true) {
                 do {
                     cotizaciontrigo = conjuntoderegistros2.getFloat(0);
  cotizacionmaiz = conjuntoderegistros2.getFloat(1);
 cotizacionsoja = conjuntoderegistros2.getFloat(2);
 cotizacioncebada = conjuntoderegistros2.getFloat(3);
  }
                while (conjuntoderegistros2.moveToNext() == true);


            }

        }
        baseDatos.close();
        totaltrigo=cantidadtrigo * cotizaciontrigo;
        totalmaiz=cantidadmaiz * cotizacionmaiz;
        totalsoja=cantidadsoja * cotizacionsoja;
        totalcebada=cantidadcebada * cotizacioncebada;
txttotaltrigo.setText(String.valueOf(totaltrigo));
        txttotalmaiz.setText(String.valueOf(totalmaiz));
        txttotalsoja.setText(String.valueOf(totalsoja));
        txttotalcebada.setText(String.valueOf(totalcebada));
        //MainActivity ma = (MainActivity) getActivity();
        txtcantidadTrigo.setText(String.valueOf(cantidadtrigo));
        txtcantidadMaiz.setText(String.valueOf(cantidadmaiz));
        txtcantidadSoja.setText(String.valueOf(cantidadsoja));
        txtcantidadCebada.setText(String.valueOf(cantidadcebada));
        txtCotizTrigo.setText(String.valueOf(cotizaciontrigo));
        txtCotizMaiz.setText(String.valueOf(cotizacionmaiz));
        txtCotizSoja.setText(String.valueOf(cotizacionsoja));
        txtCotizCebada.setText(String.valueOf(cotizacioncebada));
        //txtCotizTrigo.setText(ma.getCotizTrigo());
        // String Cotiz = Objeto.DevolverTrigo();
        //Log.d("Cotiz", Cotiz);
        //txtCotizTrigo.setText(Cotiz);
        //View VistaQueVuelve = inflater.inflate(R.layout.fragment_mi_bolsillo, container, false);
        // Inflate the layout for this fragment
        return Vista;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private boolean baseDeDatosAbierta() {
        boolean responder;
        accesoBaseproyecto=new Basededatos(getActivity(),"Basededatos",null,1);
        baseDatos=accesoBaseproyecto.getWritableDatabase();
        if (baseDatos != null) {
            responder = true;
        }
        else {
            responder = false;
        }
        return responder;

    }

   /* public void mult()
    { cotizaciontrigo=a.cotizTrigo;
        convertircotizaciontrigo=Integer.parseInt(cotizaciontrigo);
        cotizacionMaiz=a.cotizMaiz;
        convertircotizacionMaiz=Integer.parseInt(cotizacionMaiz);
        cotizacionSoja=a.cotizSoja;
        convertircotizacionSoja=Integer.parseInt(cotizacionSoja);
        cotizacionCebada=a.cotizCebadaGirasol;
        convertircotizacionCebada=Integer.parseInt(cotizacionCebada);
        String text = b.txtGrano.getSelectedItem().toString();
        if(text=="trigo")
        {
            MultiplicarTrigo=convertircotizaciontrigo*Cantidad;
            //multiplico convertircotizaciontrigo con lo que ingreso el usuario
        }
        if(text=="Maiz")
        {
            MultiplicarMaiz=convertircotizacionMaiz*Cantidad;
            //multiplico convertircotizaciontrigo con lo que ingreso el usuario
        }
        if(text=="Soja")
        {
            MultiplicarSoja=convertircotizacionSoja*Cantidad;
            //multiplico convertircotizaciontrigo con lo que ingreso el usuario
        }
        if(text=="Cebada")
        {
            MultiplicarCebada=convertircotizacionCebada*Cantidad;
            //multiplico convertircotizaciontrigo con lo que ingreso el usuario
        }


    }*/
}