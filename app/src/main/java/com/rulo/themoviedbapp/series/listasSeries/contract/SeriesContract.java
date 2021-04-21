package com.rulo.themoviedbapp.series.listasSeries.contract;

import android.content.Context;

import com.rulo.themoviedbapp.beans.Serie;

import java.util.ArrayList;

public interface SeriesContract {
    interface ItemListener {
        void onClick(int posicion);
    }

    interface View extends ItemListener {
        void success(ArrayList<Serie> series);
        void error(String message);
    }

    interface Presenter {
        void getSeries(Context context);
    }

    interface Model {
        void getSeriesWS(Context context, SeriesListener seriesListener);

        interface SeriesListener {
            void exito(ArrayList<Serie> series);

            void fallo(String error);
        }
    }
}
