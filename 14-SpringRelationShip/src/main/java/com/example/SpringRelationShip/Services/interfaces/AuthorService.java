package com.example.SpringRelationShip.Services.interfaces;

import com.example.SpringRelationShip.models.domain.Author;
import com.example.SpringRelationShip.models.dto.CreateOrUpdateAuthorRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    Page<Author> getAll(Pageable pageable);
    Author getOne(int id);
    int createOne(CreateOrUpdateAuthorRequest createRequest);
    void updateOne(int id, CreateOrUpdateAuthorRequest updateRequest);
    void deleteOne(int id);
}
