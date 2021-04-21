package com.rulo.themoviedbapp.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIgenresPelis {

    private List<Genero> genres;

}
