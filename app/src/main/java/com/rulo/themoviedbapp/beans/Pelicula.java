package com.rulo.themoviedbapp.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    private int id;
    private String poster_path;
    private String backdrop_path;
    private String title;
    private String overview;
    private String vote_average;
    private int[] genre_ids;
    private String genres;

}
