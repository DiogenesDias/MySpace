package com.dio.master.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Movie {

    private String imdbID;
    private String title;
    private String runtime;
    private LocalDate released;
    private Franchise franchise;
    private Universe universe;
    private List<Genre> genres;
    private List<Director> directors;
}