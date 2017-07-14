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
    private Context _context;
    private ArrayList<String> _movimientos;
    public MovimientosAdapter(ArrayList<String> movimientos, Context context) {
        _context = context;
        _movimientos = movimientos;
    }



    @Override
    public int getCount() {
        return _movimientos.size();
    }

    @Override
    public String getItem(int position) {
        String CampoadDevolver=_movimientos.get(position);
        return CampoadDevolver;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View VistaaDevolver;
        LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        VistaaDevolver = inflater.inflate(R.layout.listview_item, viewGroup, false);

         TextView importe= (TextView)VistaaDevolver.findViewById(R.id.campo0);
         //TextView entrada_salida = (TextView)VistaaDevolver.findViewById(R.id.entrada_salida);



        String m = _movimientos.get(position);
       //importe.setText(String.valueOf(m.getCantidad()));
        //entrada_salida.setText(m.getEntrada_salida());
        String PosicionActual = getItem(position);
        importe.setText(PosicionActual);

        return VistaaDevolver;


    }


}
