package com.example.movieapp.mapper;

import com.example.movieapp.dto.MovieRequestDTO;
import com.example.movieapp.dto.MovieResponseDTO;
import com.example.movieapp.model.Director;
import com.example.movieapp.model.Movie;
import com.example.movieapp.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
    @Autowired
    private DirectorRepository directorRepository;
    public abstract MovieResponseDTO toDto(Movie movie);

    public Movie toEntity(MovieRequestDTO movieRequest){
        Movie movie = new Movie();
        movie.setDirector(directorRepository.findByLastName(movieRequest.getDirector_lastname()));
        movie.setDescription(movieRequest.getDescription());
        movie.setState(movieRequest.getState());
        movie.setGenre(movieRequest.getGenre());
        movie.setRating(movieRequest.getRating());
        movie.setYear(movieRequest.getYear());
        movie.setTitle(movieRequest.getTitle());
        movie.setCreatedAt(LocalDateTime.now());
        return movie;
    }

    public abstract List<Movie> toEntityList(List<MovieRequestDTO> movieRequestDTO);

    public abstract List<MovieResponseDTO> toDtoList(List<Movie> movieList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedBy", ignore = true)
    public abstract Movie update(Movie source, @MappingTarget Movie target);

}
