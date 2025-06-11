package com.dio.master.integrations.configs.clients.mappers.omdb;

import com.dio.master.core.domain.model.Episode;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseEpisode;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EpisodesMapperIntegration {

    @Mapping(target = "title", source = "Title")
    @Mapping(target = "imdbID", source = "imdbID")
    @Mapping(target = "number", source = "Episode", qualifiedByName = "stringToInt")
    @Mapping(target = "released", source = "Released", qualifiedByName = "stringToLocalDate")
    @Mapping(target = "season", expression = "java(season)")
    @Mapping(target = "ownerID", expression = "java(ownerID)")
    Episode toEpisode(OmdbResponseEpisode episode, @Context Integer season, @Context String ownerID);

    List<Episode> toDomainList(List<OmdbResponseEpisode> episodes, @Context Integer season, @Context String ownerID);

    @Named("stringToInt")
    static Integer stringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return null;
        }
    }

    @Named("stringToLocalDate")
    static LocalDate stringToDate(String released) {
        try {
            return LocalDate.parse(released, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            return null;
        }
    }
}