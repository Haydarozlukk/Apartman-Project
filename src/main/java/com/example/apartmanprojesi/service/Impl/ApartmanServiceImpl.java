package com.example.apartmanprojesi.serviceImpl;

import com.example.apartmanprojesi.entity.Apartman;
import com.example.apartmanprojesi.repository.ApartmanRepository;
import com.example.apartmanprojesi.service.ApartmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmanServiceImpl implements ApartmanService {

    @Autowired
    private ApartmanRepository apartmanRepository;

    @Override
    public List<Apartman> getAllApartman() {
        return apartmanRepository.findAll();
    }

    @Override
    public Apartman getApartmanById(Long id) {
        return apartmanRepository.findById(id).orElse(null);
    }

    @Override
    public Apartman saveApartman(Apartman apartman) {
        return apartmanRepository.save(apartman);
    }

    @Override
    public void deleteApartman(Long id) {
        apartmanRepository.deleteById(id);
    }
}
