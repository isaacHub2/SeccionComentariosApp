package com.isaac.comentariosestaticos;

import android.content.Intent;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isaac.comentariosestaticos.network.EntradaInfoComentario;
import com.isaac.comentariosestaticos.network.SolicitadorImagen;

import java.util.List;

public class CardRecyclerViewAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private List<EntradaInfoComentario> listaComentarios;
    private SolicitadorImagen solicitadorImagen;

    CardRecyclerViewAdapter(List<EntradaInfoComentario> listaComentarios){
        this.listaComentarios = listaComentarios;
        solicitadorImagen = SolicitadorImagen.getInstance();
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new CardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        if (listaComentarios != null & position < listaComentarios.size()){
            EntradaInfoComentario entradaInfoComentario = listaComentarios.get(position);
            holder.nombreUsuario.setText(entradaInfoComentario.usuario);
            solicitadorImagen.setImageFromUrl(holder.imagenUsuario, entradaInfoComentario.url);

            holder.comentarioUsuario.setText(entradaInfoComentario.comentario);
            holder.fechaComentario.setText(entradaInfoComentario.publicacion);

            //holder.itemView.getContext().startActivity(CardRecyclerViewAdapter,MainActivity.class);

        //Intent intent = new Intent(holder.itemView.getContext(), )
        }
    }

    @Override
    public int getItemCount() {
        return listaComentarios.size();
    }
}
