package com.rulo.themoviedbapp.series.listasSeries.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rulo.themoviedbapp.R;
import com.rulo.themoviedbapp.beans.Serie;
import com.rulo.themoviedbapp.peliculas.listasPeliculas.view.PeliculasView;
import com.rulo.themoviedbapp.series.adapter.SeriesAdapter;
import com.rulo.themoviedbapp.series.listasSeries.contract.SeriesContract;
import com.rulo.themoviedbapp.series.listasSeries.presenter.SeriesPresenter;
import com.rulo.themoviedbapp.service.APIService;
import com.rulo.themoviedbapp.service.APIServiceImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesView extends AppCompatActivity implements SeriesContract.View {
    private SeriesPresenter presenter;
    private ArrayList<Serie> series;
    private RecyclerView recycler;
    private Button pelis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_view);

        presenter = new SeriesPresenter(this);

        initComponents();
        listarSeries();

        pelis.setOnClickListener(v -> irApelis());
    }

    private void initComponents() {
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
        pelis = findViewById(R.id.btPeliculas);
    }

    private void listarSeries() {
        presenter.getSeries(this);
    }

    private void irApelis() {
        Intent intent = new Intent(this, PeliculasView.class);
        startActivity(intent);
    }

    @Override
    public void success(ArrayList<Serie> series) {
        this.series = series;
        SeriesAdapter adapter = new SeriesAdapter(series, this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(int posicion) {
        Intent intent = new Intent(this, ItemSerieView.class);
        intent.putExtra("titulo", series.get(posicion).getName());
        intent.putExtra("sinopsis", series.get(posicion).getOverview());
        intent.putExtra("generos", series.get(posicion).getGenres());
        intent.putExtra("puntos", series.get(posicion).getVote_average());
        intent.putExtra("imagen", series.get(posicion).getBackdrop_path());
        startActivity(intent);
    }
}