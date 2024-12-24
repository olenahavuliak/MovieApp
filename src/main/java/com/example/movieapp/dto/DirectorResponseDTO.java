package com.example.movieapp.dto;

import com.example.movieapp.annotations.MandatoryField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DirectorResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
}
