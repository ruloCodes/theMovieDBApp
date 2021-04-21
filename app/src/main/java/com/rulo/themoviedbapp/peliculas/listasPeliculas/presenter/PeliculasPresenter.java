package com.rulo.themoviedbapp.peliculas.listasPeliculas.presenter;

import android.content.Context;

import com.rulo.themoviedbapp.beans.Pelicula;
import com.rulo.themoviedbapp.peliculas.listasPeliculas.contract.PeliculasContract;
import com.rulo.themoviedbapp.peliculas.listasPeliculas.model.PeliculasModel;

import java.util.ArrayList;

public class PeliculasPresenter implements PeliculasContract.Presenter {
    private PeliculasContract.View vista;
    private PeliculasModel model;

    public PeliculasPresenter(PeliculasContract.View vista) {
        this.vista = vista;
        model = new PeliculasModel();
    }

    @Override
    public void getActuales(Context context) {
        model.getActualesWS(context, new PeliculasContract.Model.PeliculasListener() {
            @Override
            public void exito(ArrayList<Pelicula> peliculas) {
                vista.success(peliculas);
            }

            @Override
            public void fallo(String error) {
                vista.error(error);
            }
        });
    }
}
