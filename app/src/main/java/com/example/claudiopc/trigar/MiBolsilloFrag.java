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
    Integer[] Vec = new Integer[4];
    Integer[] Vec2 = new Integer[4];
    MovimientoFragment b;
    MainActivity activity;
    int convertircotizaciontrigo;
    int convertircotizacionMaiz;
    int convertircotizacionSoja;
    int convertircotizacionCebada;
    float cotizaciontrigo;
    String cotizacionMaiz;
    String cotizacionCebada;
    String cotizacionSoja;
    int MultiplicarTrigo;
    int MultiplicarSoja;
    int MultiplicarMaiz;
    int MultiplicarCebada;
    int Cantidad;//PREGUNTAR
    Spinner txtGrano;//preguntar
    String cantidadtrigo;
    String cantidadmaiz;
    String cantidadsoja;
    String cantidadcebada;
    String Nombre;
    RssHandler Objeto = new RssHandler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Vista = inflater.inflate(R.layout.fragment_mi_bolsillo, container, false);
        TextView txtTrigo = (TextView) Vista.findViewById(R.id.TrigoCant);
        TextView txtMaiz = (TextView) Vista.findViewById(R.id.MaizCant);
        TextView txtSoja = (TextView) Vista.findViewById(R.id.SojaCant);
        TextView txtCebada = (TextView) Vista.findViewById(R.id.CebadaCant);
        TextView txtCotizTrigo = (TextView) Vista.findViewById(R.id.TrigoCotiz);
        TextView txtCotizMaiz = (TextView) Vista.findViewById(R.id.MaizCotiz);
        TextView txtCotizSoja = (TextView) Vista.findViewById(R.id.SojaCotiz);
        TextView txtCotizCebada = (TextView) Vista.findViewById(R.id.CebadaCotiz);
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
            conjuntoderegistros = baseDatos.rawQuery("select sum(Cantidad), Grano From Movimiento group by Grano", null);
            if (conjuntoderegistros.moveToFirst() == true) {
                do {
                    if (conjuntoderegistros.getString(1).compareTo("Trigo") == 0) {
                        //txtTrigo.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        Vec[0] = conjuntoderegistros.getInt(0);
                    }

                    if (conjuntoderegistros.getString(1).compareTo("Maiz") == 0) {
                        //txtMaiz.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        Vec[1] = conjuntoderegistros.getInt(0);
                    }

                    if (conjuntoderegistros.getString(1).compareTo("Soja") == 0) {
                        //txtSoja.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        Vec[2] = conjuntoderegistros.getInt(0);
                    }

                    if (conjuntoderegistros.getString(1).compareTo("Cebada") == 0) {
                        Log.d("Cebada", "Entra a cebada");
                        //txtCebada.setText(String.valueOf(conjuntoderegistros.getInt(0)));
                        Vec[3] = conjuntoderegistros.getInt(0);
                        Log.d("Cebada", String.valueOf(Vec[3]));
                    }
                }
                while (conjuntoderegistros.moveToNext() == true);

            }
            Cursor conjuntoderegistros2;

            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //Calendar cal = Calendar.getInstance();
            //String Fecha= dateFormat.format(cal); //2016/11/16 12:08:43


/*            conjuntoderegistros2 = baseDatos.rawQuery("select ImporteTrigo ,ImporteSoja ,ImporteMaiz ,ImporteCebada From Cotizaciones ", null);
            if (conjuntoderegistros2.moveToFirst() == true) {
                Vec2[0] = conjuntoderegistros2.getInt(0);
                Vec2[1] = conjuntoderegistros2.getInt(1);
                Vec2[2] = conjuntoderegistros2.getInt(2);
                Vec2[3] = conjuntoderegistros2.getInt(3);
            }
            while (conjuntoderegistros2.moveToNext() == true);

        */}


        //MainActivity ma = (MainActivity) getActivity();
        txtTrigo.setText(String.valueOf(Vec[0]));
        txtMaiz.setText(String.valueOf(Vec[1]));
        txtSoja.setText(String.valueOf(Vec[2]));
        txtCebada.setText(String.valueOf(Vec[3]));
        txtCotizTrigo.setText(String.valueOf(Vec2[0]));
        txtCotizMaiz.setText(String.valueOf(Vec2[1]));
        txtCotizSoja.setText(String.valueOf(Vec2[2]));
        txtCotizCebada.setText(String.valueOf(Vec2[3]));
        //txtCotizTrigo.setText(ma.getCotizTrigo());
        // String Cotiz = Objeto.DevolverTrigo();
        //Log.d("Cotiz", Cotiz);
        //txtCotizTrigo.setText(Cotiz);
        View VistaQueVuelve = inflater.inflate(R.layout.fragment_mi_bolsillo, container, false);
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