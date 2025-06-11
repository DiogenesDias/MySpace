package com.dio.master.integrations.configs.clients.mappers.omdb;

import com.dio.master.core.domain.model.Director;
import com.dio.master.core.domain.model.Genre;
import com.dio.master.core.domain.model.Movie;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseMovie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface MoviesMapperIntegration {

    @Mapping(target = "imdbID", source = "imdbID")
    @Mapping(target = "title", source = "Title")
    @Mapping(target = "runtime", source = "Runtime")
    @Mapping(target = "released", source = "Released", qualifiedByName = "stringToLocalDate")
    @Mapping(target = "directors", source = "Director", qualifiedByName = "mapDirectors")
    @Mapping(target = "genres", source = "Genre", qualifiedByName = "mapGenres")
    @Mapping(target = "franchise", ignore = true)
    @Mapping(target = "universe", ignore = true)
    Movie toDomain(OmdbResponseMovie omdbResponse);

    @Named("stringToLocalDate")
    static LocalDate stringToDate(String released) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM uuuu", Locale.ENGLISH);
            return LocalDate.parse(released, formatter);
        } catch (Exception e) {
            return null;
        }
    }

    @Named("mapDirectors")
    default List<Director> mapDirectors(String directors) {
        if (directors == null || directors.isEmpty()) {
            Director directorObj = new Director("N/A");
            return Collections.singletonList(directorObj);
        }

        return Stream.of(directors.split(","))
                .map(String::trim)
                .map(Director::new)
                .collect(Collectors.toList());
    }

    @Named("mapGenres")
    default List<Genre> mapGenres(String genres) {
        if (genres == null || genres.isEmpty()) {
            Genre genreObj = new Genre("N/A");
            return Collections.singletonList(genreObj);
        }

        return Stream.of(genres.split(","))
                .map(String::trim)
                .map(Genre::new)
                .collect(Collectors.toList());
    }
}