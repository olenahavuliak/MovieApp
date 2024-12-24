package com.example.movieapp.mapper;

import com.example.movieapp.dto.DirectorRequestDTO;
import com.example.movieapp.dto.DirectorResponseDTO;
import com.example.movieapp.model.Director;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-12T15:23:00+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class DirectorMapperImpl extends DirectorMapper {

    @Override
    public DirectorResponseDTO toDto(Director director) {
        if ( director == null ) {
            return null;
        }

        DirectorResponseDTO directorResponseDTO = new DirectorResponseDTO();

        directorResponseDTO.setId( director.getId() );
        directorResponseDTO.setFirstName( director.getFirstName() );
        directorResponseDTO.setLastName( director.getLastName() );

        return directorResponseDTO;
    }

    @Override
    public Director toEntity(DirectorRequestDTO directorRequestDTO) {
        if ( directorRequestDTO == null ) {
            return null;
        }

        Director director = new Director();

        director.setFirstName( directorRequestDTO.getFirstName() );
        director.setLastName( directorRequestDTO.getLastName() );

        return director;
    }

    @Override
    public List<Director> toEntityList(List<DirectorRequestDTO> directorRequestDTO) {
        if ( directorRequestDTO == null ) {
            return null;
        }

        List<Director> list = new ArrayList<Director>( directorRequestDTO.size() );
        for ( DirectorRequestDTO directorRequestDTO1 : directorRequestDTO ) {
            list.add( toEntity( directorRequestDTO1 ) );
        }

        return list;
    }

    @Override
    public List<DirectorResponseDTO> toDtoList(List<Director> directors) {
        if ( directors == null ) {
            return null;
        }

        List<DirectorResponseDTO> list = new ArrayList<DirectorResponseDTO>( directors.size() );
        for ( Director director : directors ) {
            list.add( toDto( director ) );
        }

        return list;
    }

    @Override
    public Director update(Director source, Director target) {
        if ( source == null ) {
            return target;
        }

        target.setFirstName( source.getFirstName() );
        target.setLastName( source.getLastName() );

        target.setUpdatedAt( java.time.LocalDateTime.now() );

        return target;
    }
}
