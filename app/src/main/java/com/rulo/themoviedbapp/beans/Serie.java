package com.rulo.themoviedbapp.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serie {

    private int id;
    private String poster_path;
    private String backdrop_path;
    private String name;
    private String overview;
    private int[] genre_ids;
    private String vote_average;
    private String genres;

}
