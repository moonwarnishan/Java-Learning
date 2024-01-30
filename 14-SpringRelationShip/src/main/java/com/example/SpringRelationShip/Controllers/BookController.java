package com.example.SpringRelationShip.Controllers;

import com.example.SpringRelationShip.Services.interfaces.BookService;
import com.example.SpringRelationShip.mapper.BookMapper;
import com.example.SpringRelationShip.models.dto.BookResponse;
import com.example.SpringRelationShip.models.dto.CreateUpdateBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(Pageable pageable)
    {
        var domains = bookService.getAll(pageable);
        return ResponseEntity.ok(domains.map(bookMapper::domainToResponse));
    }
    @PostMapping
    public ResponseEntity<?> createOne(@RequestBody CreateUpdateBookRequest newBook)
    {
        var id = bookService.createOne(newBook);
        return ResponseEntity.ok(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CreateUpdateBookRequest updatedEntity)
    {
        bookService.updateOne(id,updatedEntity);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id)
    {
        bookService.deleteOne(id);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(bookMapper.domainToResponse(bookService.getOne(id)));
    }
}
