package com.rulo.themoviedbapp.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIserie {

    private int page;
    private List<Serie> results;
    private int total_pages;
    private int total_results;

}
