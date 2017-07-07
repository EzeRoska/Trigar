package com.example.claudiopc.trigar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 41919393 on 26/5/2017.
 */

public class MovimientosAdapter extends BaseAdapter{
    Context context;
    ArrayList<Movimiento> movimientos;
    public MovimientosAdapter(Context context, ArrayList<Movimiento> movimientos) {
        this.context = context;
        this.movimientos = movimientos;
    }



    @Override
    public int getCount() {
        return movimientos.size();
    }

    @Override
    public Object getItem(int position) {
        return movimientos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position
                ;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view== null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item, viewGroup, false);
        }
         TextView importe= (TextView)view.findViewById(R.id.importe);
         TextView entrada_salida = (TextView)view.findViewById(R.id.entrada_salida);



        Movimiento m = movimientos.get(position);

       importe.setText(String.valueOf(m.getCantidad()));
        //entrada_salida.setText(m.getEntrada_salida());

        return view;


    }


}
