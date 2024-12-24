package com.example.movieapp.model;

import com.example.movieapp.annotations.MandatoryField;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Director extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @MandatoryField
    private String firstName;
    @MandatoryField
    private String lastName;
}
