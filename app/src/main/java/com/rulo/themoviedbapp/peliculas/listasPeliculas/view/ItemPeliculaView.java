package com.rulo.themoviedbapp.peliculas.listasPeliculas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rulo.themoviedbapp.R;
import com.rulo.themoviedbapp.beans.Pelicula;
import com.squareup.picasso.Picasso;

public class ItemPeliculaView extends AppCompatActivity {

    private Pelicula pelicula;
    private String urlImagen;
    private Float puntos;
    private ImageView ivImagenItem;
    private TextView tvTituloItem;
    private TextView tvSinopsisItem;
    private TextView tvGeneroItem;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_pelicula_view);

        initComponents();

        pelicula.setTitle(getIntent().getStringExtra("titulo"));
        pelicula.setOverview(getIntent().getStringExtra("sinopsis"));
        pelicula.setGenres(getIntent().getStringExtra("generos"));
        pelicula.setBackdrop_path(getIntent().getStringExtra("imagen"));

        urlImagen = "https://image.tmdb.org/t/p/original" + pelicula.getBackdrop_path();
        puntos = Float.parseFloat(getIntent().getStringExtra("puntos")) / 2;

        pintaComponents();
    }

    private void initComponents() {
        pelicula = new Pelicula();

        ivImagenItem = findViewById(R.id.ivImagenPeliculaItem);
        tvTituloItem = findViewById(R.id.tvTituloPeliculaItem);
        tvSinopsisItem = findViewById(R.id.tvSinopsisPeliculaItem);
        tvGeneroItem = findViewById(R.id.tvGeneroPeliculaItem);
        ratingBar = findViewById(R.id.ratingBarPeliculaItem);
    }

    private void pintaComponents() {
        Picasso.get().load(urlImagen).into(ivImagenItem);
        tvTituloItem.setText(pelicula.getTitle());
        tvSinopsisItem.setText(pelicula.getOverview());
        tvGeneroItem.setText(pelicula.getGenres());
        ratingBar.setRating(puntos);
    }
}
