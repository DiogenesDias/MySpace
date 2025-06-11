package com.dio.master.app.mappers;

import com.dio.master.api.dto.responses.EpisodeResponse;
import com.dio.master.core.domain.model.Episode;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EpisodesMapper {

    EpisodeResponse toResponse(Episode episode);

    List<EpisodeResponse> toResponseList(List<Episode> episodes);
}