package com.rulo.themoviedbapp.peliculas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rulo.themoviedbapp.R;
import com.rulo.themoviedbapp.beans.Pelicula;
import com.rulo.themoviedbapp.peliculas.listasPeliculas.contract.PeliculasContract;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.PeliculaViewHolder> {
    private ArrayList<Pelicula> lstMovies;
    private PeliculasContract.ItemListener itemListener;

    public static class PeliculaViewHolder extends RecyclerView.ViewHolder{
        public ImageView img;
        public TextView titulo;
        public TextView sinopsis;
        public TextView generos;
        public TextView puntuacion;

        public PeliculaViewHolder(View v, PeliculasContract.ItemListener itemListener){
            super(v);
            img = v.findViewById(R.id.ivTarjeta);
            titulo = v.findViewById(R.id.tvTitulo);
            sinopsis = v.findViewById(R.id.tvSinopsis);
            generos = v.findViewById(R.id.tvGenero);
            puntuacion = v.findViewById(R.id.tvPuntuacion);

            v.setOnClickListener(v1 -> {
                itemListener.onClick(getAdapterPosition());
            });
        }
    }

    public PeliculasAdapter(ArrayList<Pelicula> lstMovies, PeliculasContract.ItemListener itemListener) {
        this.lstMovies = lstMovies;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_recycler, parent, false);
        return new PeliculaViewHolder(v, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        Pelicula pelicula = lstMovies.get(position);

        holder.titulo.setText(pelicula.getTitle());
        holder.sinopsis.setText(pelicula.getOverview());
        holder.generos.setText(pelicula.getGenres());
        holder.puntuacion.setText(pelicula.getVote_average());

        String urlBase = "https://image.tmdb.org/t/p/original";
        Picasso.get().load(urlBase + pelicula.getPoster_path()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return lstMovies.size();
    }

}