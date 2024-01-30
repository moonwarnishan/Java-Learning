package com.example.SpringRelationShip.Services.interfaces;

import com.example.SpringRelationShip.models.domain.Book;
import com.example.SpringRelationShip.models.dto.CreateUpdateBookRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> getAll(Pageable pageable);
    Book getOne(int id);
    int createOne(CreateUpdateBookRequest createRequest);
    void updateOne(int id, CreateUpdateBookRequest updateRequest);
    void deleteOne(int id);
}
