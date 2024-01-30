package com.example.SpringRelationShip.models.dto;

import com.example.SpringRelationShip.persistence.entity.AuthorEntity;
import com.example.SpringRelationShip.persistence.entity.LibraryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CreateUpdateBookRequest {
    private String bookName;
    private List<AuthorEntity> author;
    private LibraryEntity library;
}
