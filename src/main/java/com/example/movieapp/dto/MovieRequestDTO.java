package com.example.movieapp.dto;

import com.example.movieapp.annotations.CustomValidation;
import com.example.movieapp.annotations.MandatoryField;
import com.example.movieapp.model.Director;
import com.example.movieapp.model.enumerations.Genre;
import com.example.movieapp.model.enumerations.Release;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestDTO {
    @MandatoryField
    private String title;
    @MandatoryField
    @CustomValidation(min = 1888)
    private int year;
    @MandatoryField
    private String director_lastname;
    @MandatoryField
    private Genre genre;
    private String description;
    @CustomValidation(min = 0, max = 10)
    private double rating;
    @MandatoryField
    private Release state;
}
