package com.rulo.themoviedbapp.peliculas.listasPeliculas.contract;

import android.content.Context;

import com.rulo.themoviedbapp.beans.Pelicula;

import java.util.ArrayList;

public interface PeliculasContract {
    interface ItemListener {
        void onClick(int posicion);
    }

    interface View extends ItemListener{
        void success(ArrayList<Pelicula> peliculas);
        void error(String message);
    }

    interface Presenter{
        void getActuales(Context context);
    }

    interface Model{
        void getActualesWS(Context context, PeliculasListener peliculasListener);

        interface PeliculasListener{
            void exito(ArrayList<Pelicula> peliculas);
            void fallo(String error);
        }
    }
}
