package com.dio.master.app.mappers;

import com.dio.master.api.dto.responses.MovieResponse;
import com.dio.master.core.domain.model.Director;
import com.dio.master.core.domain.model.Genre;
import com.dio.master.core.domain.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MoviesMapper {


    @Mapping(target = "genres", source = "genres", qualifiedByName = "mapGenres")
    @Mapping(target = "directors", source = "directors", qualifiedByName = "mapDirectors")
    MovieResponse toResponse(Movie movie);

    @Named("mapDirectors")
    default List<String> mapDirectors(List<Director> directors) {
        if (directors == null || directors.isEmpty()) {
            return Collections.singletonList("N/A");
        }

        return directors.stream()
                .map(Director::getName)
                .collect(Collectors.toList());
    }

    @Named("mapGenres")
    default List<String> mapGenres(List<Genre> genres) {
        if (genres == null || genres.isEmpty()) {
            return Collections.singletonList("N/A");
        }

        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toList());
    }

}