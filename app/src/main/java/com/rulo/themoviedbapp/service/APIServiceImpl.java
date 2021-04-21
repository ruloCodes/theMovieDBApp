package com.rulo.themoviedbapp.service;


import android.content.Context;
import android.util.Log;

import com.rulo.themoviedbapp.beans.APIgenresPelis;
import com.rulo.themoviedbapp.beans.APIgenresSeries;
import com.rulo.themoviedbapp.beans.APIpeli;
import com.rulo.themoviedbapp.beans.APIserie;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServiceImpl {

    private Retrofit retrofit;
    private APIService service;
    private Context context;

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    public APIServiceImpl(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(APIService.class);
    }

    public Call<APIserie> getAPISeries() {
        return service.getSeries();
    }

    public Call<APIpeli> getAPIPeliculas() {
        return service.getPeliculas();
    }

    public Call<APIgenresPelis> getAPIGenresPelis() {
        return service.getGenresPelis();
    }

    public Call<APIgenresSeries> getAPIGenresSeries() {
        return service.getGenresSeries();
    }

}
