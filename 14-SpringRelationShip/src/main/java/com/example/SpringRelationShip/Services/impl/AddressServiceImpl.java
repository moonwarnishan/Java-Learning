package com.example.SpringRelationShip.Services.impl;

import com.example.SpringRelationShip.mapper.AddressMapper;
import com.example.SpringRelationShip.models.domain.Address;
import com.example.SpringRelationShip.models.dto.CreateOrUpdateAddressRequest;
import com.example.SpringRelationShip.persistence.entity.AddressEntity;
import com.example.SpringRelationShip.Services.interfaces.AddressService;
import com.example.SpringRelationShip.persistence.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public Page<Address> getAll(Pageable pageable)
    {
        log.info("getting all addresses");
        var entities = addressRepository.findAll(pageable);
        return entities.map(addressMapper::entityToDomain);
    }
    public Address getOne(int id) {
        log.info("getting address by id : {}",id);
        var entity = addressRepository.findById(id).orElseThrow();
        return addressMapper.entityToDomain(entity);
    }

    public int createOne(CreateOrUpdateAddressRequest createRequest) {
        var entity = new AddressEntity();
        entity.setAddress(createRequest.getAddress())
                .setLibrary(createRequest.getLibrary());
        var createdEntity = addressRepository.save(entity);
        log.info("new address created with id : {}",createdEntity.getId());
        return createdEntity.getId();
    }

    public void updateOne(int id, CreateOrUpdateAddressRequest updateRequest) {
        var entity = addressRepository.findById(id)
                .orElseThrow();
        entity.setAddress(updateRequest.getAddress())
                .setLibrary(updateRequest.getLibrary());
        log.info("address updated with id : {}",entity.getId());
        addressRepository.save(entity);
    }

    public void deleteOne(int id) {
        addressRepository.deleteById(id);
        log.info("address deleted : {}",id);
    }

}
