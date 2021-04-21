package com.rulo.themoviedbapp.series.listasSeries.presenter;

import android.content.Context;
import android.util.Log;

import com.rulo.themoviedbapp.beans.Serie;
import com.rulo.themoviedbapp.series.listasSeries.contract.SeriesContract;
import com.rulo.themoviedbapp.series.listasSeries.model.SeriesModel;

import java.util.ArrayList;

public class SeriesPresenter implements SeriesContract.Presenter {
    private SeriesContract.View vista;
    private SeriesModel model;

    public SeriesPresenter(SeriesContract.View vista) {
        this.vista = vista;
        model = new SeriesModel();
    }

    @Override
    public void getSeries(Context context) {
        model.getSeriesWS(context, new SeriesContract.Model.SeriesListener() {
            @Override
            public void exito(ArrayList<Serie> series) {
                vista.success(series);
            }

            @Override
            public void fallo(String error) {
                vista.error(error);
            }
        });
    }
}
