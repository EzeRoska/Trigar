package com.example.claudiopc.trigar;

        import android.content.Context;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Spinner;


public class MiBolsilloFrag extends Fragment {
    RssHandler a;
    MovimientoFragment b;
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
    int Cantidad;//PREGUNTAR
    Spinner txtGrano;//preguntar
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mi_bolsillo, container, false);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public void mult()
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


    }
}
