package com.dio.master.integrations.configs.clients.mappers.omdb;

import com.dio.master.core.domain.model.Serie;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseSerie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Mapper(componentModel = "spring")
public interface SeriesMapperIntegration {

    @Mapping(target = "title", source = "Title")
    @Mapping(target = "yearsActive", source = "Year")
    @Mapping(target = "seasons", source = "totalSeasons", qualifiedByName = "stringToInteger")
    @Mapping(target = "released", source = "Released", qualifiedByName = "stringToLocalDate")
    @Mapping(target = "imdbID", source = "imdbID")
    Serie toDomain(OmdbResponseSerie response);

    @Named("stringToInteger")
    static Integer stringToInteger(String value) {
        try {
            return value != null ? Integer.parseInt(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Named("stringToLocalDate")
    static LocalDate stringToDate(String released) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM uuuu", Locale.ENGLISH);
            return LocalDate.parse(released, formatter);
        } catch (Exception e) {
            return null;
        }
    }
}