package com.example.claudiopc.trigar;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;



public class listaMovimiento extends Fragment implements View.OnClickListener {


    MainActivity mainActivity;
    private EditText BuscarListView;
    public ListView listamov;
    String filtro="";
    ArrayAdapter<String> adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_movimiento, container, false);

        //RECEPCION DE BUNDLE.
        Bundle bundle = new Bundle();
        String Fecha = bundle.getString("Fecha");
        String Lote = bundle.getString("Lote");
        Integer Cantidad = bundle.getInt("Cantidad");
        String Grano = bundle.getString("Grano");

        listamov = (ListView) v.findViewById(R.id.ListaMov);
        BuscarListView=(EditText)v.findViewById (R.id.filtroListView);
        mainActivity = (MainActivity)getActivity();
        //adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,  mainActivity.getDatos());

        BuscarListView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //adapter.getFilter().filter(s);
                filtro=filtro+s;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        Button CargarMovs = (Button) v.findViewById(R.id.btnCargar);
        CargarMovs.setOnClickListener(this);
        Button btnVolver = (Button) v.findViewById(R.id.btnvolverListaMovimiento);
        btnVolver.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                PantallainicioFragment PIf = new PantallainicioFragment();
                mainActivity.changeFragment(PIf);
            }
        });
        ListView listamov;

        {

            listamov = (ListView) v.findViewById(R.id.ListaMov);
            MovimientosAdapter adapter = new MovimientosAdapter(mainActivity.mostrarCampos(filtro), getContext());

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








