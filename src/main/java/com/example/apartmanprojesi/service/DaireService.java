package com.example.apartmanprojesi.service;

import com.example.apartmanprojesi.entity.Daire;

import java.util.List;

public interface DaireService {
    List<Daire> getAllDaire();
    Daire getDaireById(Long id);
    Daire saveDaire(Daire daire);
    void deleteDaire(Long id);
}
