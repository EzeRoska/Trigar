import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.claudiopc.trigar.R;

import java.util.ArrayList;


/**
 * Created by claudio PC on 8/24/2017.
 */

public class AdapterLisWiewdeta extends BaseAdapter {

    private ArrayList<String> _ListaCampos;
    private Context _context;

    public AdapterLisWiewdeta(ArrayList<String> ListadeCampos, Context ContextaUsar) {
        _ListaCampos = ListadeCampos;
        _context = ContextaUsar;

    }

    @Override
    public int getCount() {
        return _ListaCampos.size();
    }

    @Override
    public String getItem(int PosicionaObtener) {
        String NombreaDevolver = _ListaCampos.get(PosicionaObtener);
        return NombreaDevolver;
    }

    @Override
    public long getItemId(int PosicionaObtener) {
        return PosicionaObtener;
    }

    @Override
    public View getView(int PosicionActual, View VistaActual, ViewGroup GrupoActual)
    {
        //Aca en el VistaaDevolver no deberia hacer 5 VistaaDevolver??? preguntar a lean.
        View VistaaDevolver;
        LayoutInflater inflater;
        inflater = (LayoutInflater)_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        VistaaDevolver = inflater.inflate(R.layout.listviewdetalle, GrupoActual, false);
        TextView Titulo1 = (TextView)VistaaDevolver.findViewById(R.id.Nombre1);
        TextView Titulo2 = (TextView)VistaaDevolver.findViewById(R.id.Nombre2);
        TextView Titulo3 = (TextView)VistaaDevolver.findViewById(R.id.Nombre3);
        TextView Titulo4 = (TextView)VistaaDevolver.findViewById(R.id.Nombre4);
        TextView Titulo5 = (TextView)VistaaDevolver.findViewById(R.id.Nombre5);


        String TextoposicionActual = getItem(PosicionActual);
        Titulo1.setText(TextoposicionActual);
        Titulo2.setText(TextoposicionActual);
        Titulo3.setText(TextoposicionActual);
        Titulo4.setText(TextoposicionActual);
        Titulo5.setText(TextoposicionActual);

        return VistaaDevolver;
    }






}
