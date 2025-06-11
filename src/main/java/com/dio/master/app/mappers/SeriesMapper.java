package com.dio.master.app.mappers;

import com.dio.master.api.dto.responses.SerieResponse;
import com.dio.master.core.domain.model.Serie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeriesMapper {

    SerieResponse toResponse(Serie serie);
}
