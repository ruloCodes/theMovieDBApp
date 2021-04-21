package com.rulo.themoviedbapp.peliculas.listasPeliculas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.rulo.themoviedbapp.R;
import com.rulo.themoviedbapp.beans.Pelicula;
import com.rulo.themoviedbapp.peliculas.adapter.PeliculasAdapter;
import com.rulo.themoviedbapp.peliculas.listasPeliculas.contract.PeliculasContract;
import com.rulo.themoviedbapp.peliculas.listasPeliculas.presenter.PeliculasPresenter;
import com.rulo.themoviedbapp.series.listasSeries.view.ItemSerieView;
import com.rulo.themoviedbapp.series.listasSeries.view.SeriesView;

import java.util.ArrayList;

public class PeliculasView extends AppCompatActivity implements PeliculasContract.View {

    private PeliculasPresenter presenter;
    private ArrayList<Pelicula> pelis;
    private RecyclerView recycler;
    private Button series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_view);

        presenter = new PeliculasPresenter(this);

        initComponents();
        listarActuales();

        series.setOnClickListener(v -> irAseries());
    }

    private void initComponents() {
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
        series = findViewById(R.id.btSeries);
    }

    private void listarActuales() {
        presenter.getActuales(this);
    }

    private void irAseries() {
        Intent intent = new Intent(this, SeriesView.class);
        startActivity(intent);
    }

    public void success(ArrayList<Pelicula> peliculas) {
        pelis = peliculas;
        PeliculasAdapter adapter = new PeliculasAdapter(peliculas, this);
        recycler.setAdapter(adapter);
    }

    public void error(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(int posicion) {
        Intent intent = new Intent(this, ItemPeliculaView.class);
        intent.putExtra("titulo", pelis.get(posicion).getTitle());
        intent.putExtra("sinopsis", pelis.get(posicion).getOverview());
        intent.putExtra("generos", pelis.get(posicion).getGenres());
        intent.putExtra("puntos", pelis.get(posicion).getVote_average());
        intent.putExtra("imagen", pelis.get(posicion).getBackdrop_path());
        startActivity(intent);
    }
}