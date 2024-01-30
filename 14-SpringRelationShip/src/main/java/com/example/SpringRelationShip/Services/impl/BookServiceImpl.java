package com.example.SpringRelationShip.Services.impl;

import com.example.SpringRelationShip.Services.interfaces.BookService;
import com.example.SpringRelationShip.mapper.BookMapper;
import com.example.SpringRelationShip.models.domain.Book;
import com.example.SpringRelationShip.models.dto.CreateUpdateBookRequest;
import com.example.SpringRelationShip.persistence.entity.BookEntity;
import com.example.SpringRelationShip.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Page<Book> getAll(Pageable pageable)
    {
        log.info("getting all books");
        var entities = bookRepository.findAll(pageable);
        return entities.map(bookMapper::entityToDomain);
    }
    public Book getOne(int id) {
        log.info("getting book by id : {}",id);
        var entity = bookRepository.findById(id).orElseThrow();
        return bookMapper.entityToDomain(entity);
    }

    public int createOne(CreateUpdateBookRequest createRequest) {
        var entity = new BookEntity();
        entity.setBookName(createRequest.getBookName())
                .setAuthor(createRequest.getAuthor())
                .setLibrary(createRequest.getLibrary());
        var createdEntity = bookRepository.save(entity);
        log.info("new book created with id : {}",createdEntity.getId());
        return createdEntity.getId();
    }

    public void updateOne(int id, CreateUpdateBookRequest updateRequest) {
        var entity = bookRepository.findById(id)
                .orElseThrow();
        entity.setBookName(updateRequest.getBookName())
                .setAuthor(updateRequest.getAuthor())
                .setLibrary(updateRequest.getLibrary());
        log.info("book updated with id : {}",entity.getId());
        bookRepository.save(entity);
    }

    public void deleteOne(int id) {
        bookRepository.deleteById(id);
        log.info("book deleted : {}",id);
    }
}
