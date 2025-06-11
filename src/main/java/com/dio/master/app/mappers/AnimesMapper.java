package com.dio.master.app.mappers;

import com.dio.master.api.dto.responses.AnimeResponse;
import com.dio.master.core.domain.model.Anime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimesMapper {

    AnimeResponse toResponse(Anime anime);
}