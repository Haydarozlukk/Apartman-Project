package com.example.apartmanprojesi.repository;

import com.example.apartmanprojesi.entity.Apartman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmanRepository extends JpaRepository<Apartman, Long> {
}
