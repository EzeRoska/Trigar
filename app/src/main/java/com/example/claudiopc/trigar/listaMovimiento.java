package com.example.claudiopc.trigar;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;



public class listaMovimiento extends Fragment implements View.OnClickListener {


    MainActivity mainActivity;

    public listaMovimiento() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //RECEPCION DE BUNDLE.
        Bundle bundle = new Bundle();
        String Fecha = bundle.getString("Fecha");
        String Lote = bundle.getString("Lote");
        Integer Cantidad = bundle.getInt("Cantidad");
        String Grano = bundle.getString("Grano");



        View v = inflater.inflate(R.layout.fragment_lista_movimiento, container, false);
        Button CargarMovs = (Button)v.findViewById(R.id.btnCargar);
        CargarMovs.setOnClickListener(this);
        Button btnVolver = (Button)v.findViewById(R.id.btnvolverListaMovimiento);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PantallainicioFragment PIf = new PantallainicioFragment();
                mainActivity.changeFragment(PIf);
            }
        });
        ListView listamov;{

            listamov = (ListView) v.findViewById(R.id.ListaMov);
            MovimientosAdapter adapter = new MovimientosAdapter(mainActivity.mostrarCampos(), getContext());
            listamov.setAdapter(adapter);
            return v;
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCargar:
                MovimientoFragment Mf = new MovimientoFragment();
                 mainActivity.changeFragment(Mf);
                break;
        }

    }

}








