package com.dio.master.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Episode {

    private String imdbID;
    private String ownerID;
    private String title;
    private Integer season;
    private Integer number;
    private LocalDate released;
}