package com.example.movieapp.controller;

import com.example.movieapp.dto.DirectorRequestDTO;
import com.example.movieapp.dto.DirectorResponseDTO;
import com.example.movieapp.dto.MovieRequestDTO;
import com.example.movieapp.dto.MovieResponseDTO;
import com.example.movieapp.mapper.DirectorMapper;
import com.example.movieapp.mapper.MovieMapper;
import com.example.movieapp.service.DirectorService;
import com.example.movieapp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie-service")
@RequiredArgsConstructor
public class MovieController{

    private final MovieService service;
    private final MovieMapper mapper;
    private final DirectorMapper directorMapper;
    private final DirectorService directorService;

    @PostMapping
    public ResponseEntity<MovieResponseDTO> create(@RequestBody MovieRequestDTO movieRequest) {
        return ResponseEntity.ok(mapper.toDto(service.addMovie(mapper.toEntity(movieRequest))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> update(@PathVariable Long id, @RequestBody MovieRequestDTO movieRequest) {
        return null;
    }

    @GetMapping
    //@PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<MovieResponseDTO>> getAll() {
        return ResponseEntity.ok(mapper.toDtoList(service.getAllMovies()));
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('client_user')")
    public ResponseEntity<MovieResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.getMovieById(id)));
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAllMovies();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/director")
    public ResponseEntity<DirectorResponseDTO> addDirector(@RequestBody DirectorRequestDTO directorRequestDTO){
        return ResponseEntity.ok(directorMapper.toDto(directorService.addDirector(directorMapper.toEntity(directorRequestDTO))));
    }
}
