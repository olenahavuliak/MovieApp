package com.example.movieapp.model;

import com.example.movieapp.annotations.CustomValidation;
import com.example.movieapp.annotations.MandatoryField;
import com.example.movieapp.model.enumerations.Genre;
import com.example.movieapp.model.enumerations.Release;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Year;

@Entity
@Data
public class Movie extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MandatoryField
    private String title;

    @MandatoryField
    @CustomValidation(min = 1888)
    private int year;

    @MandatoryField
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;

    @Enumerated(EnumType.STRING)
    @MandatoryField
    private Genre genre;
    private String description;

    @CustomValidation(min = 1, max = 10)
    private double rating;

    @Enumerated(EnumType.STRING)
    @MandatoryField
    private Release state;
}
