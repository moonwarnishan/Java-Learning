package com.example.SpringRelationShip.Controllers;

import com.example.SpringRelationShip.Services.interfaces.LibraryService;
import com.example.SpringRelationShip.mapper.LibraryMapper;
import com.example.SpringRelationShip.models.dto.CreateOrUpdateLibraryRequest;
import com.example.SpringRelationShip.models.dto.LibraryResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libraries")
@AllArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;
    private final LibraryMapper libraryMapper;

    @GetMapping
    public ResponseEntity<Page<LibraryResponse>> getAll(Pageable pageable) {
        var domains = libraryService.getAll(pageable);
        return ResponseEntity.ok(domains.map(libraryMapper::domainToResponse));
    }

    @PostMapping
    public ResponseEntity<?> createOne(@RequestBody CreateOrUpdateLibraryRequest entity)
    {
        var id = libraryService.createOne(entity);
        return ResponseEntity.ok(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CreateOrUpdateLibraryRequest updatedEntity)
    {
        libraryService.updateOne(id,updatedEntity);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id)
    {
        libraryService.deleteOne(id);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryResponse> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(libraryMapper.domainToResponse(libraryService.getOne(id)));
    }
}
