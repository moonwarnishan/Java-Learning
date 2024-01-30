package com.example.SpringRelationShip.Controllers;

import com.example.SpringRelationShip.Services.interfaces.AuthorService;
import com.example.SpringRelationShip.mapper.AuthorMapper;
import com.example.SpringRelationShip.models.dto.AuthorResponse;
import com.example.SpringRelationShip.models.dto.CreateOrUpdateAuthorRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authors")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @GetMapping
    public ResponseEntity<Page<AuthorResponse>> getAll(Pageable pageable)
    {
        var domains = authorService.getAll(pageable);
        return ResponseEntity.ok(domains.map(authorMapper::domainToResponse));
    }
    @PostMapping
    public ResponseEntity<?> createOne(@RequestBody CreateOrUpdateAuthorRequest entity)
    {
        var id = authorService.createOne(entity);
        return ResponseEntity.ok(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CreateOrUpdateAuthorRequest updatedEntity)
    {
        authorService.updateOne(id,updatedEntity);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id)
    {
        authorService.deleteOne(id);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorResponse> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(authorMapper.domainToResponse(authorService.getOne(id)));
    }
}
