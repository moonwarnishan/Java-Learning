package com.example.SpringRelationShip.mapper;

import com.example.SpringRelationShip.models.domain.Library;
import com.example.SpringRelationShip.models.dto.LibraryResponse;
import com.example.SpringRelationShip.persistence.entity.LibraryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {
    Library entityToDomain(LibraryEntity entity);
    LibraryResponse domainToResponse(Library library);
}
