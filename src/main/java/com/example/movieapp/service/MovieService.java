package com.example.movieapp.service;

import com.example.movieapp.dto.MovieRequestDTO;
import com.example.movieapp.mapper.MovieMapper;
import com.example.movieapp.model.Director;
import com.example.movieapp.model.Movie;
import com.example.movieapp.repository.DirectorRepository;
import com.example.movieapp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final RabbitTemplate rabbitTemplate;
    private final MovieMapper movieMapper;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }

    public Movie getMovieById(Long id) {
        return  movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Movie not found"));
    }

    public void deleteAllMovies() {
        movieRepository.deleteAll();
    }
}
