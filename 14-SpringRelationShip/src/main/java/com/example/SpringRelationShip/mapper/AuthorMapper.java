package com.example.SpringRelationShip.mapper;

import com.example.SpringRelationShip.models.domain.Author;
import com.example.SpringRelationShip.models.dto.AuthorResponse;
import com.example.SpringRelationShip.persistence.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author entityToDomain(AuthorEntity entity);

    AuthorResponse domainToResponse(Author author);
}
