package com.example.apartmanprojesi.service;

import com.example.apartmanprojesi.entity.Apartman;

import java.util.List;

public interface ApartmanService {
    List<Apartman> getAllApartman();
    Apartman getApartmanById(Long id);
    Apartman saveApartman(Apartman apartman);
    void deleteApartman(Long id);
}
