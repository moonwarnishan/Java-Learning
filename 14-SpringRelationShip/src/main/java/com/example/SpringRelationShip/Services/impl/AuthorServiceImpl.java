package com.example.SpringRelationShip.Services.impl;

import com.example.SpringRelationShip.mapper.AuthorMapper;
import com.example.SpringRelationShip.models.domain.Author;
import com.example.SpringRelationShip.models.dto.CreateOrUpdateAuthorRequest;
import com.example.SpringRelationShip.persistence.entity.AuthorEntity;
import com.example.SpringRelationShip.Services.interfaces.AuthorService;
import com.example.SpringRelationShip.persistence.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public Page<Author> getAll(Pageable pageable)
    {
        log.info("getting all authors");
        var entities = authorRepository.findAll(pageable);
        return entities.map(authorMapper::entityToDomain);
    }
    public Author getOne(int id) {
        log.info("getting author by id : {}",id);
        var entity = authorRepository.findById(id).orElseThrow();
        return authorMapper.entityToDomain(entity);
    }

    public int createOne(CreateOrUpdateAuthorRequest createRequest) {
        var entity = new AuthorEntity();
        entity.setName(createRequest.getName())
                .setBooks(createRequest.getBooks());
        var createdEntity = authorRepository.save(entity);
        log.info("new author created with id : {}",createdEntity.getId());
        return createdEntity.getId();
    }

    public void updateOne(int id, CreateOrUpdateAuthorRequest updateRequest) {
        var entity = authorRepository.findById(id)
                .orElseThrow();
        entity.setName(updateRequest.getName())
                .setBooks(updateRequest.getBooks());
        log.info("author updated with id : {}",entity.getId());
        authorRepository.save(entity);
    }

    public void deleteOne(int id) {
        authorRepository.deleteById(id);
        log.info("author deleted : {}",id);
    }

}
