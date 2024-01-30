package com.example.SpringRelationShip.models.domain;

import com.example.SpringRelationShip.persistence.entity.AddressEntity;
import com.example.SpringRelationShip.persistence.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Library {
    private Set<BookEntity> books;
    private AddressEntity address;
}
