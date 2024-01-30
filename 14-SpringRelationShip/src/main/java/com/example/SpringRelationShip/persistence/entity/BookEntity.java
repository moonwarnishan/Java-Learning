package com.example.SpringRelationShip.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Entity(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BookEntity {
    @Id
    @GeneratedValue
    private int id;
    private String bookName;
    @ManyToMany(mappedBy = "books")
    private List<AuthorEntity> author;
    @ManyToOne
    @JoinColumn(name="library_id")
    private LibraryEntity library;
}
