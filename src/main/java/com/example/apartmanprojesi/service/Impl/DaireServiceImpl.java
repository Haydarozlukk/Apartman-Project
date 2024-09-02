package com.example.apartmanprojesi.serviceImpl;

import com.example.apartmanprojesi.entity.Daire;
import com.example.apartmanprojesi.repository.DaireRepository;
import com.example.apartmanprojesi.service.DaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaireServiceImpl implements DaireService {

    @Autowired
    private DaireRepository daireRepository;

    @Override
    public List<Daire> getAllDaire() {
        return daireRepository.findAll();
    }

    @Override
    public Daire getDaireById(Long id) {
        return daireRepository.findById(id).orElse(null);
    }

    @Override
    public Daire saveDaire(Daire daire) {
        return daireRepository.save(daire);
    }

    @Override
    public void deleteDaire(Long id) {
        daireRepository.deleteById(id);
    }
}
