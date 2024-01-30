package com.example.SpringRelationShip.models.domain;

import com.example.SpringRelationShip.persistence.entity.LibraryEntity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Address {
    private String address;
    private LibraryEntity library;
}