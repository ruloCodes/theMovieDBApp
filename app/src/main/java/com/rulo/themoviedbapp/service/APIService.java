package com.rulo.themoviedbapp.service;

import com.rulo.themoviedbapp.beans.APIgenresPelis;
import com.rulo.themoviedbapp.beans.APIgenresSeries;
import com.rulo.themoviedbapp.beans.APIpeli;
import com.rulo.themoviedbapp.beans.APIserie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("trending/tv/week?api_key=b496f9027a17f8228614a71be36f9c39&language=es-ES&page=1&region=ES")
    Call<APIserie> getSeries();

    @GET("movie/popular?api_key=b496f9027a17f8228614a71be36f9c39&language=es-ES&page=1&region=ES")
    Call<APIpeli> getPeliculas();

    @GET("genre/tv/list?api_key=b496f9027a17f8228614a71be36f9c39&language=es-ES")
    Call<APIgenresSeries> getGenresSeries();

    @GET("genre/movie/list?api_key=b496f9027a17f8228614a71be36f9c39&language=es-ES")
    Call<APIgenresPelis> getGenresPelis();

}
