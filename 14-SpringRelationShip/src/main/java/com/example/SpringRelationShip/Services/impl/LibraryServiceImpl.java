package com.example.SpringRelationShip.Services.impl;

import com.example.SpringRelationShip.mapper.LibraryMapper;
import com.example.SpringRelationShip.models.domain.Library;
import com.example.SpringRelationShip.models.dto.CreateOrUpdateLibraryRequest;
import com.example.SpringRelationShip.persistence.entity.LibraryEntity;
import com.example.SpringRelationShip.Services.interfaces.LibraryService;
import com.example.SpringRelationShip.persistence.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public Page<Library> getAll(Pageable pageable)
    {
        log.info("getting all Libraries");
        var entities = libraryRepository.findAll(pageable);
        return entities.map(libraryMapper::entityToDomain);
    }
    public Library getOne(int id) {
        log.info("getting Library by id : {}",id);
        var entity = libraryRepository.findById(id).orElseThrow();
        return libraryMapper.entityToDomain(entity);
    }

    public int createOne(CreateOrUpdateLibraryRequest createRequest) {
        var entity = new LibraryEntity();
        entity.setBooks(createRequest.getBooks())
                .setAddress(createRequest.getAddress());
        var createdEntity = libraryRepository.save(entity);
        log.info("new Library created with id : {}",createdEntity.getId());
        return createdEntity.getId();
    }

    public void updateOne(int id, CreateOrUpdateLibraryRequest updateRequest) {
        var entity = libraryRepository.findById(id)
                .orElseThrow();
        entity.setBooks(updateRequest.getBooks())
                .setAddress(updateRequest.getAddress());
        log.info("Library updated with id : {}",entity.getId());
        libraryRepository.save(entity);
    }

    public void deleteOne(int id) {
        libraryRepository.deleteById(id);
        log.info("Library deleted : {}",id);
    }

}
