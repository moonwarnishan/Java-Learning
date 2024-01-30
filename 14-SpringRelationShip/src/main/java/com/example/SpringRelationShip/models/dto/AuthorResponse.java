package com.example.SpringRelationShip.models.dto;

import com.example.SpringRelationShip.persistence.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AuthorResponse {
    private String name;
    private List<BookEntity> books;
}