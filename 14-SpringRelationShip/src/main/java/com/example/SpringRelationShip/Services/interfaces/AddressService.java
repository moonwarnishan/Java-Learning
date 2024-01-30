package com.example.SpringRelationShip.Services.interfaces;

import com.example.SpringRelationShip.models.domain.Address;
import com.example.SpringRelationShip.models.dto.CreateOrUpdateAddressRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {
    Page<Address> getAll(Pageable pageable);
    Address getOne(int id);
    int createOne(CreateOrUpdateAddressRequest createRequest);
    void updateOne(int id, CreateOrUpdateAddressRequest updateRequest);
    void deleteOne(int id);
}
