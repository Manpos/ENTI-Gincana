package com.gincana.enti.entigincana;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.bitmap;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    protected ArrayList<Hint> llistaPistes;    //Pistes a mostrar

    protected LayoutInflater inflador;             //Crea Layouts a partir de l'XML list_item

    protected Context contexto;                    //Necessari per l'inflater

    protected View.OnClickListener onClickListener;

    protected View.OnLongClickListener onLongClickListener;

    public int hintId;


    public Adaptador(Context contexto, ArrayList<Hint> _llistaPistes) {
        this.contexto = contexto;
        llistaPistes = _llistaPistes;
        inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nomPista;
        public ImageView imatgePista;

        public ViewHolder(View itemView) {

            super(itemView);
            nomPista = itemView.findViewById(R.id.nompista);
            imatgePista = itemView.findViewById(R.id.hint_icon);
        }

    }

    //Mètode obligatori que genera un ViewHolder a partir de l'id de l'XML list_item

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflador.inflate(R.layout.list_item, null);
        v.setOnClickListener(onClickListener);
        v.setOnLongClickListener(onLongClickListener);

        return new ViewHolder(v);

    }

    // Mètode obligatori que ens permet especificar què posar als views de cada item

    @Override

    public void onBindViewHolder(ViewHolder holder, int posicio) {

        holder.nomPista.setText(llistaPistes.get(posicio).getDescription());
        holder.imatgePista.setImageResource(llistaPistes.get(posicio).type());
        hintId = posicio;

    }

    //Mètode obligatori que retorna el número d'elements total de la llista

    @Override public int getItemCount() {

        return llistaPistes.size();

    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener){
        this.onLongClickListener = onLongClickListener;
    }

}