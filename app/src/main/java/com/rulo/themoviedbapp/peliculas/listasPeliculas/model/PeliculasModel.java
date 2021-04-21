package com.rulo.themoviedbapp.peliculas.listasPeliculas.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.rulo.themoviedbapp.beans.APIgenresPelis;
import com.rulo.themoviedbapp.beans.APIpeli;
import com.rulo.themoviedbapp.beans.Pelicula;
import com.rulo.themoviedbapp.peliculas.listasPeliculas.contract.PeliculasContract;
import com.rulo.themoviedbapp.service.APIServiceImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculasModel implements PeliculasContract.Model {


    @Override
    public void getActualesWS(Context context, PeliculasListener peliculasListener) {
        APIServiceImpl api = new APIServiceImpl(context);

        final Call<APIpeli> pelisCall = api.getAPIPeliculas();

        pelisCall.enqueue(new Callback<APIpeli>() {
            @Override
            public void onResponse(@Nullable Call<APIpeli> call, @Nullable Response<APIpeli> response) {
                if (response != null && response.body() != null) {
                    List<Pelicula> peliculas = response.body().getResults();
                    peliculas.forEach(pelicula -> getGenres(context, pelicula));
                    peliculasListener.exito(new ArrayList<>(peliculas));
                }
            }

            @Override
            public void onFailure(@Nullable Call<APIpeli> call, @Nullable Throwable t) {
                Log.e("PELICULAS-MODEL-ERROR", "" + t.getLocalizedMessage());
                peliculasListener.fallo("[Error al traer las películas]");
            }
        });
    }

    private void getGenres(Context context, Pelicula pelicula) {
        APIServiceImpl api = new APIServiceImpl(context);

        final Call<APIgenresPelis> genresCall = api.getAPIGenresPelis();

        genresCall.enqueue(new Callback<APIgenresPelis>() {
            @Override
            public void onResponse(Call<APIgenresPelis> call, Response<APIgenresPelis> response) {
                StringBuilder generosPelicula = new StringBuilder();

                for (int i = 0; i < pelicula.getGenre_ids().length; i++) {
                    final int fi = i;
                    response.body().getGenres().forEach(genero -> {
                        if (pelicula.getGenre_ids()[fi] == genero.getId()) {
                            generosPelicula.append(genero.getName()).append(" ");
                            pelicula.setGenres(generosPelicula.toString());
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<APIgenresPelis> call, Throwable t) {

            }
        });
    }

}
