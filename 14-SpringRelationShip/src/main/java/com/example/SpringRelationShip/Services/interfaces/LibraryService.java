package com.example.SpringRelationShip.Services.interfaces;

import com.example.SpringRelationShip.models.domain.Library;
import com.example.SpringRelationShip.models.dto.CreateOrUpdateLibraryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LibraryService {
    Page<Library> getAll(Pageable pageable);
    Library getOne(int id);
    int createOne(CreateOrUpdateLibraryRequest createRequest);
    void updateOne(int id, CreateOrUpdateLibraryRequest updateRequest);
    void deleteOne(int id);
}
