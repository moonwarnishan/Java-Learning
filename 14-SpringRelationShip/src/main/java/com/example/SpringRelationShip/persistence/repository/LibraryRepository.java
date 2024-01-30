package com.example.SpringRelationShip.persistence.repository;

import com.example.SpringRelationShip.persistence.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {
}
