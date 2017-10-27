package com.example.claudiopc.trigar;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CotizacionesFragment extends Fragment implements View.OnClickListener {

    SQLiteDatabase baseDatos;
    Basededatos accesoBaseproyecto;
    float cotiztr;
    float cotizMa;
    float cotizSo;
    float cotizCe;
    String Fecha;
    TextView ValorTrigo;
    TextView ValorMaiz;
    TextView ValorSoja;
    TextView ValorCebada;
    MainActivity activity;

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
    public  void insertar ( float ImporteTrigo,float ImporteSoja,float ImporteMaiz,float ImporteCebada) {

        if (baseDeDatosAbierta()) {
            ContentValues nuevoRegistro;
            nuevoRegistro = new ContentValues();
            //nuevoRegistro.put("Fecha", Fecha);
            nuevoRegistro.put("ImporteTrigo", ImporteTrigo);
            nuevoRegistro.put("ImporteSoja", ImporteSoja);
            nuevoRegistro.put("ImporteMaiz", ImporteMaiz);
            nuevoRegistro.put("ImporteCebada",ImporteCebada);
            baseDatos.insert("Cotizaciones", null, nuevoRegistro);
        }
        baseDatos.close();
    }

    public CotizacionesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Vista=inflater.inflate(R.layout.fragment_cotizaciones,container,false);
       // View vistadevolver;
        //vistadevolver = inflater.inflate(R.layout.fragment_cotizaciones, container, false);
        activity = (MainActivity)getActivity();
        Button btnVolver = (Button)Vista.findViewById(R.id.btnVolverCotizaciones);
        btnVolver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PantallainicioFragment PIf = new PantallainicioFragment();
                activity.changeFragment(PIf);

            }
        });



        new BuscarDatos().execute( "http://bolsadecereales.com/flash-cotizaciones.xml");
   ValorTrigo = (TextView) Vista.findViewById(R.id.TrigoPrecio);
        ValorMaiz = (TextView) Vista.findViewById(R.id.MaizPrecio);
       ValorSoja = (TextView) Vista.findViewById(R.id.SojaPrecio);
         ValorCebada = (TextView) Vista.findViewById(R.id.CebadaPrecio);


        return Vista;
    }

    @Override
    public void onClick(View v) {
       /* MainActivity anfitriona;
        anfitriona = (MainActivity) getActivity();
        anfitriona.Volver();*/

    }

private class BuscarDatos extends AsyncTask<String,Void,String>
{
    protected void onPostExecute(String datos) {
        super.onPostExecute(datos);

        ValorTrigo.setText(String.valueOf(cotiztr));

        ValorMaiz.setText(String.valueOf(cotizMa));

        ValorSoja.setText(String.valueOf(cotizSo));

        ValorCebada.setText(String.valueOf(cotizCe));
        insertar(cotiztr,cotizMa,cotizSo,cotizCe);
    }
    @Override
    protected String doInBackground(String... parametros) {
        /*
        String url ="http://www.bolsadecereales.com/flash-cotizaciones.xml";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String resultado=  response.body().string();
            return resultado;
        }
        catch (IOException e){
            Log.d("Error :", e.getMessage());
            return null;

        }
        */

        RssParserSax saxparser =
                new RssParserSax("http://www.bolsadecereales.com/flash-cotizaciones.xml");
        Cotizacion c= saxparser.parse();
        cotiztr=c.getCotizTrigo();
        cotizMa=c.getCotizMaiz();
        cotizSo=c.getCotizSoja();
        cotizCe=c.getCotizCebada();
        //Calendar calendar = Calendar.getInstance();
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Calendar cal = Calendar.getInstance();
        //Fecha= dateFormat.format(cal); //2016/11/16 12:08:43
        //create table Cotizaciones(Id integer, Fecha integer, ImporteTrigo real,ImporteSoja real,ImporteMaiz real,ImporteCebada real)";
        return "Hola";
    }
}







}
