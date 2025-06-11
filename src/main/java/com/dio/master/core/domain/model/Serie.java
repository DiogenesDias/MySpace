package com.dio.master.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Serie {

    private String imdbID;
    private String title;
    private Integer seasons;
    private LocalDate released;
    private String yearsActive;
}