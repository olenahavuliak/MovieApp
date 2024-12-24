package com.example.movieapp.mapper;

import com.example.movieapp.dto.DirectorRequestDTO;
import com.example.movieapp.dto.DirectorResponseDTO;
import com.example.movieapp.dto.MovieRequestDTO;
import com.example.movieapp.dto.MovieResponseDTO;
import com.example.movieapp.model.Director;
import com.example.movieapp.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DirectorMapper {

    public abstract DirectorResponseDTO toDto(Director director);

    public abstract Director toEntity(DirectorRequestDTO directorRequestDTO);

    public abstract List<Director> toEntityList(List<DirectorRequestDTO> directorRequestDTO);

    public abstract List<DirectorResponseDTO> toDtoList(List<Director> directors);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedBy", ignore = true)
    public abstract Director update(Director source, @MappingTarget Director target);


}
