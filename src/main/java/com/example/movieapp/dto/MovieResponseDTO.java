package com.example.movieapp.dto;

import com.example.movieapp.annotations.CustomValidation;
import com.example.movieapp.annotations.MandatoryField;
import com.example.movieapp.model.Director;
import com.example.movieapp.model.enumerations.Genre;
import com.example.movieapp.model.enumerations.Release;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDTO {
    private Long id;
    private String title;
    private int year;
    private Director director;
    private Genre genre;
    private String description;
    private double rating;
    private Release state;
}
