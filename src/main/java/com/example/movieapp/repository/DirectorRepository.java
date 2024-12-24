package com.example.movieapp.repository;

import com.example.movieapp.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    @Query(value = "SELECT d from Director d WHERE d.lastName =:lastname")
    Director findByLastName(@Param("lastname") String lastName);
}
