package com.example.claudiopc.trigar;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CotizacionesFragment extends Fragment implements View.OnClickListener {


    public CotizacionesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vistadevolver;
        vistadevolver = inflater.inflate(R.layout.fragment_cotizaciones, container, false);


        Button volver = (Button)vistadevolver.findViewById(R.id.btnVolver5);
        volver.setOnClickListener(this);

        return vistadevolver;
    }

    @Override
    public void onClick(View v) {
        MainActivity anfitriona;
        anfitriona = (MainActivity) getActivity();
        anfitriona.Volver();
        new BuscarDatos().execute( "http://bolsadecereales.com/flash-cotizaciones.xml");
    }

private class BuscarDatos extends AsyncTask<String,Void,String>
{
    protected void onPostExecute(String datos) {
        super.onPostExecute(datos);
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
        List<Cotizacion> c= saxparser.parse();
        return "Hola";
    }
}







}
