package com.rulo.themoviedbapp.series.listasSeries.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rulo.themoviedbapp.R;
import com.rulo.themoviedbapp.beans.Serie;
import com.squareup.picasso.Picasso;

public class ItemSerieView extends AppCompatActivity {

    private Serie serie;
    private String urlImagen;
    private Float puntos;
    private ImageView ivImagenSerie;
    private TextView tvTituloItem;
    private TextView tvSinopsisItem;
    private TextView tvGeneroItem;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_serie_view);

        initComponents();

        serie.setName(getIntent().getStringExtra("titulo"));
        serie.setOverview(getIntent().getStringExtra("sinopsis"));
        serie.setGenres(getIntent().getStringExtra("generos"));
        serie.setBackdrop_path(getIntent().getStringExtra("imagen"));

        urlImagen = "https://image.tmdb.org/t/p/original" + serie.getBackdrop_path();
        puntos = Float.parseFloat(getIntent().getStringExtra("puntos")) / 2;

        pintaComponents();
    }

    private void initComponents() {
        serie = new Serie();

        ivImagenSerie = findViewById(R.id.ivImagenSerieItem);
        tvTituloItem = findViewById(R.id.tvTituloSerieItem);
        tvSinopsisItem = findViewById(R.id.tvSinopsisSerieItem);
        tvGeneroItem = findViewById(R.id.tvGeneroSerieItem);
        ratingBar = findViewById(R.id.ratingBarSerieItem);
    }

    private void pintaComponents() {
        Picasso.get().load(urlImagen).into(ivImagenSerie);
        tvTituloItem.setText(serie.getName());
        tvSinopsisItem.setText(serie.getOverview());
        tvGeneroItem.setText(serie.getGenres());
        ratingBar.setRating(puntos);
    }

}