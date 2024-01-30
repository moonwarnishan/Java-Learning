package com.example.SpringRelationShip.persistence.repository;

import com.example.SpringRelationShip.persistence.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Integer> {
}
