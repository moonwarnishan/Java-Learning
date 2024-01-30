package com.example.SpringRelationShip.models.domain;

import com.example.SpringRelationShip.persistence.entity.AuthorEntity;
import com.example.SpringRelationShip.persistence.entity.LibraryEntity;
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
public class Book {
    private String bookName;
    private List<AuthorEntity> author;
    private LibraryEntity library;
}
