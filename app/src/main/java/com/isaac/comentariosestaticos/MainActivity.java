package com.isaac.comentariosestaticos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaac.comentariosestaticos.network.EntradaInfoComentario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CardRecyclerViewAdapter cardRecyclerViewAdapter = new CardRecyclerViewAdapter(
                EntradaInfoComentario.listaInfoComentarios(getResources()));

        recyclerView.setAdapter(cardRecyclerViewAdapter);
        recyclerView.addItemDecoration(new CardItemDecoration(12, 3));
        }
    }