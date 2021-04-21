package com.rulo.themoviedbapp.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIpeli {

    private int page;
    private List<Pelicula> results;
    private int total_pages;
    private int total_results;

}
