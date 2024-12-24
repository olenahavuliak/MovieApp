package com.example.movieapp.service;

import com.example.movieapp.model.Director;
import com.example.movieapp.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;
     public Director addDirector(Director director){
         return directorRepository.save(director);
     }

}
