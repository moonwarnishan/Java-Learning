package com.example.SpringRelationShip.Controllers;

import com.example.SpringRelationShip.Services.interfaces.AddressService;
import com.example.SpringRelationShip.mapper.AddressMapper;
import com.example.SpringRelationShip.models.dto.AddressResponse;
import com.example.SpringRelationShip.models.dto.BookResponse;
import com.example.SpringRelationShip.models.dto.CreateOrUpdateAddressRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @GetMapping
    public ResponseEntity<Page<AddressResponse>> getAll(Pageable pageable)
    {
        var domains = addressService.getAll(pageable);
        return ResponseEntity.ok(domains.map(addressMapper::domainToResponse));
    }
    @PostMapping
    public ResponseEntity<?> createOne(@RequestBody CreateOrUpdateAddressRequest entity)
    {
        var id = addressService.createOne(entity);
        return ResponseEntity.ok(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CreateOrUpdateAddressRequest updatedEntity)
    {
        addressService.updateOne(id,updatedEntity);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id)
    {
        addressService.deleteOne(id);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
    @GetMapping("{id}")
    public ResponseEntity<AddressResponse> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(addressMapper.domainToResponse(addressService.getOne(id)));
    }
}
