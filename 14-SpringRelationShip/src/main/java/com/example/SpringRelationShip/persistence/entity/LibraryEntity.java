package com.example.SpringRelationShip.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Entity(name = "library")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LibraryEntity {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(mappedBy = "library")
    private Set<BookEntity> books;
    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}
