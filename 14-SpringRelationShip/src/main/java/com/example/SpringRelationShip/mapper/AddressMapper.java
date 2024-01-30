package com.example.SpringRelationShip.mapper;

import com.example.SpringRelationShip.models.domain.Address;
import com.example.SpringRelationShip.models.dto.AddressResponse;
import com.example.SpringRelationShip.persistence.entity.AddressEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address entityToDomain(AddressEntity entity);

    AddressResponse domainToResponse(Address address);
}
