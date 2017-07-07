package com.example.claudiopc.trigar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * A simple {@link Fragment} subclass.
 */
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





        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_movimiento, container, false);
        Button CargarMovs = (Button)v.findViewById(R.id.btnCargar);

        CargarMovs.setOnClickListener(this);

        ListView listamov;{

            listamov = (ListView) v.findViewById(R.id.ListaMov);
            ArrayList<Movimiento> movimientos;
            movimientos = new ArrayList<>();
            Movimiento m= new Movimiento((float)1.0, (float)1.0, 10, "Grano"); // float Fecha , float Lote , int Cantidad , String Grano
            movimientos.add(m);
            m= new Movimiento((float)1.0, (float)1.0, 10, "Grano");
            movimientos.add(m);
            m= new Movimiento((float)1.0, (float)1.0, 10, "Grano");
            movimientos.add(m);
            m= new Movimiento((float)1.0, (float)1.0, 10, "Grano");
            movimientos.add(m);

            MovimientosAdapter adapter = new MovimientosAdapter(getContext(), movimientos);
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

            case R.id.btnvolver:
                PantallainicioFragment Pi = new PantallainicioFragment();
                mainActivity.changeFragment(Pi);
                break;

        }

    }

}








