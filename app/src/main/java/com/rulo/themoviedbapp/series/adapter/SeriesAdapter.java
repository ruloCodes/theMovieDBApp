package com.rulo.themoviedbapp.series.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rulo.themoviedbapp.R;
import com.rulo.themoviedbapp.beans.Serie;
import com.rulo.themoviedbapp.series.listasSeries.contract.SeriesContract;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SerieViewHolder> {
    private ArrayList<Serie> lstSeries;
    private SeriesContract.ItemListener itemListener;

    public SeriesAdapter(ArrayList<Serie> lstSeries, SeriesContract.ItemListener itemListener) {
        this.lstSeries = lstSeries;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public SeriesAdapter.SerieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_recycler, parent, false);
        return new SeriesAdapter.SerieViewHolder(v, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesAdapter.SerieViewHolder holder, int position) {
        Serie serie = lstSeries.get(position);

        holder.titulo.setText(serie.getName());
        holder.sinopsis.setText(serie.getOverview());
        holder.generos.setText(serie.getGenres());
        holder.puntuacion.setText(serie.getVote_average());

        String urlBase = "https://image.tmdb.org/t/p/original";
        Picasso.get().load(urlBase + serie.getPoster_path()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return lstSeries.size();
    }

    public static class SerieViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView titulo;
        public TextView sinopsis;
        public TextView generos;
        public TextView puntuacion;

        public SerieViewHolder(View v, SeriesContract.ItemListener itemListener) {
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
}
