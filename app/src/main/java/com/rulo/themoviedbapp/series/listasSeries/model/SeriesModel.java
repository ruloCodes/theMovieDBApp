package com.rulo.themoviedbapp.series.listasSeries.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.rulo.themoviedbapp.beans.APIgenresPelis;
import com.rulo.themoviedbapp.beans.APIgenresSeries;
import com.rulo.themoviedbapp.beans.APIserie;
import com.rulo.themoviedbapp.beans.Pelicula;
import com.rulo.themoviedbapp.beans.Serie;
import com.rulo.themoviedbapp.series.listasSeries.contract.SeriesContract;
import com.rulo.themoviedbapp.service.APIServiceImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesModel implements SeriesContract.Model {

    @Override
    public void getSeriesWS(Context context, final SeriesListener seriesListener) {
        APIServiceImpl api = new APIServiceImpl(context);

        final Call<APIserie> seriesCall = api.getAPISeries();

        seriesCall.enqueue(new Callback<APIserie>() {
            @Override
            public void onResponse(@Nullable Call<APIserie> call, @Nullable Response<APIserie> response) {
                if (response != null && response.body() != null) {
                    List<Serie> series = response.body().getResults();
                    series.forEach(serie -> getGenres(context, serie));
                    seriesListener.exito(new ArrayList<>(series));
                }
            }

            @Override
            public void onFailure(@Nullable Call<APIserie> call, @Nullable Throwable t) {
                seriesListener.fallo("[Error al traer las series]");
            }
        });
    }

    private void getGenres(Context context, Serie serie) {
        APIServiceImpl api = new APIServiceImpl(context);

        final Call<APIgenresSeries> genresCall = api.getAPIGenresSeries();

        genresCall.enqueue(new Callback<APIgenresSeries>() {
            @Override
            public void onResponse(Call<APIgenresSeries> call, Response<APIgenresSeries> response) {
                StringBuilder generosSerie = new StringBuilder();

                for (int i = 0; i < serie.getGenre_ids().length; i++) {
                    final int fi = i;
                    response.body().getGenres().forEach(genero -> {
                        if (serie.getGenre_ids()[fi] == genero.getId()) {
                            generosSerie.append(genero.getName()).append(" ");
                            serie.setGenres(generosSerie.toString());
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<APIgenresSeries> call, Throwable t) {

            }
        });
    }

}
