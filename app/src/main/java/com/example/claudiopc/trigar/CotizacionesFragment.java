package com.example.claudiopc.trigar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


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
        anfitriona = (MainActivity)getActivity();
        anfitriona.Volver();


    }
}
