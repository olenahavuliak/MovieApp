package com.example.movieapp.mapper;

import com.example.movieapp.dto.MovieRequestDTO;
import com.example.movieapp.dto.MovieResponseDTO;
import com.example.movieapp.model.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-12T15:22:59+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class MovieMapperImpl extends MovieMapper {

    @Override
    public MovieResponseDTO toDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieResponseDTO movieResponseDTO = new MovieResponseDTO();

        movieResponseDTO.setId( movie.getId() );
        movieResponseDTO.setTitle( movie.getTitle() );
        movieResponseDTO.setYear( movie.getYear() );
        movieResponseDTO.setDirector( movie.getDirector() );
        movieResponseDTO.setGenre( movie.getGenre() );
        movieResponseDTO.setDescription( movie.getDescription() );
        movieResponseDTO.setRating( movie.getRating() );
        movieResponseDTO.setState( movie.getState() );

        return movieResponseDTO;
    }

    @Override
    public List<Movie> toEntityList(List<MovieRequestDTO> movieRequestDTO) {
        if ( movieRequestDTO == null ) {
            return null;
        }

        List<Movie> list = new ArrayList<Movie>( movieRequestDTO.size() );
        for ( MovieRequestDTO movieRequestDTO1 : movieRequestDTO ) {
            list.add( toEntity( movieRequestDTO1 ) );
        }

        return list;
    }

    @Override
    public List<MovieResponseDTO> toDtoList(List<Movie> movieList) {
        if ( movieList == null ) {
            return null;
        }

        List<MovieResponseDTO> list = new ArrayList<MovieResponseDTO>( movieList.size() );
        for ( Movie movie : movieList ) {
            list.add( toDto( movie ) );
        }

        return list;
    }

    @Override
    public Movie update(Movie source, Movie target) {
        if ( source == null ) {
            return target;
        }

        target.setTitle( source.getTitle() );
        target.setYear( source.getYear() );
        target.setDirector( source.getDirector() );
        target.setGenre( source.getGenre() );
        target.setDescription( source.getDescription() );
        target.setRating( source.getRating() );
        target.setState( source.getState() );

        target.setUpdatedAt( java.time.LocalDateTime.now() );

        return target;
    }
}
