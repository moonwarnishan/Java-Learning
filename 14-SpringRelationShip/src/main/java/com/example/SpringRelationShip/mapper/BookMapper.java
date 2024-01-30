package com.example.SpringRelationShip.mapper;

import com.example.SpringRelationShip.models.domain.Book;
import com.example.SpringRelationShip.models.dto.BookResponse;
import com.example.SpringRelationShip.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book entityToDomain(BookEntity entity);
    BookResponse domainToResponse(Book book);
}
