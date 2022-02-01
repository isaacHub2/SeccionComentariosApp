package com.isaac.comentariosestaticos;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class CardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView imagenUsuario;
    public TextView nombreUsuario;
    public TextView comentarioUsuario;
    public TextView fechaComentario;


    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        imagenUsuario = itemView.findViewById(R.id.imagen_usuario_card);
        nombreUsuario = itemView.findViewById(R.id.nombre_usuario_card);
        comentarioUsuario = itemView.findViewById(R.id.comentario_usuario_card);
        fechaComentario = itemView.findViewById(R.id.fecha_comentario_card);
    }
}
