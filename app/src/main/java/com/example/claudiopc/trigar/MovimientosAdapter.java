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
    private ArrayList<Movimiento> _movimientos;
    public MovimientosAdapter(ArrayList<Movimiento> movimientos, Context context) {
        _context = context;
        _movimientos = movimientos;
    }



    @Override
    public int getCount() {
        return _movimientos.size();
    }

    @Override
    public Movimiento getItem(int position) {
        return _movimientos.get(position);
        //return CampoadDevolver;
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

        //Aca tengo que poner en inporte el campo correspondiente a cada uno de los 5 campos.
         TextView importe0= (TextView)VistaaDevolver.findViewById(R.id.campo0);
        TextView importe1 =(TextView) VistaaDevolver.findViewById(R.id.campo1);
        TextView importe2 =(TextView)VistaaDevolver.findViewById(R.id.campo2);
        TextView importe3 =(TextView)VistaaDevolver.findViewById(R.id.campo3);
        TextView importe4 = (TextView)VistaaDevolver.findViewById(R.id.campo4);
         //TextView entrada_salida = (TextView)VistaaDevolver.findViewById(R.id.entrada_salida);



        Movimiento m = _movimientos.get(position);
      //En donde dice cantidad tengo que poner los 5 campos correspondientes .
        importe0.setText(m.getCantidad());
        importe1.setText(m.getCantidad());
        importe2.setText(m.getCantidad());
        importe3.setText(m.getCantidad());
        importe4.setText(m.getCantidad());


        return VistaaDevolver;


    }


}
