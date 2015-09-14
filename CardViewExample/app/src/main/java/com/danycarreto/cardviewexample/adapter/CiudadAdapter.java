package com.danycarreto.cardviewexample.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.danycarreto.cardviewexample.R;
import com.danycarreto.cardviewexample.model.Ciudad;

import java.util.List;

/**
 * Created by Daniel on 24/04/2015.
 */
public class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.ContactViewHolder> {

    List<Ciudad> infoCity;

    /**
     * Constructor de la clase que recibe la lista de objetos.
     */
    public CiudadAdapter(List<Ciudad> infoCity){
        this.infoCity=infoCity;
    }

    /**
     * Carga la vista de la tarjeta.
     */
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View tarjeta= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_ciudad,viewGroup,false);
        return new ContactViewHolder(tarjeta);
    }


    /**
     * Llenamos la tarjeta con la información.
     */
    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        final Ciudad ciudad = infoCity.get(i);
        contactViewHolder.txtCiudad.setText(ciudad.getCiudad());
        contactViewHolder.txtContinente.setText(ciudad.getContinente());
        contactViewHolder.txtDescripcion.setText(ciudad.getDescripcion());
        contactViewHolder.txtPais.setText(ciudad.getPais());

        contactViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "tarjetas:" + ciudad.getPais() + ciudad.getCiudad(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Regresa el total de elementos de una lista
     */
    @Override
    public int getItemCount() {
        return infoCity.size();
    }

    /**
     * Con el View Holder optimizamos la creación del contenido de la tarjeta
     */
    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        protected TextView txtCiudad;
        protected TextView txtContinente;
        protected TextView txtDescripcion;
        protected TextView txtPais;
        protected CardView cardView;
        public ContactViewHolder(View v) {
            super(v);
            txtCiudad =  (TextView) v.findViewById(R.id.textViewCiudad);
            txtContinente = (TextView)  v.findViewById(R.id.textViewContinente);
            txtCiudad = (TextView)  v.findViewById(R.id.textViewDescripcion);
            txtPais = (TextView) v.findViewById(R.id.textViewPais);
            cardView= (CardView) v.findViewById(R.id.cardView);
        }
    }
}
