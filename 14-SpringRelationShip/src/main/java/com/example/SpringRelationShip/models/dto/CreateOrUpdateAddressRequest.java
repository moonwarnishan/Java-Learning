package com.example.SpringRelationShip.models.dto;

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
public class CreateOrUpdateAddressRequest {
    private String address;
    private LibraryEntity library;
}