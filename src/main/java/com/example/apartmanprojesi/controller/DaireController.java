package com.example.apartmanprojesi.controller;

import com.example.apartmanprojesi.entity.Daire;
import com.example.apartmanprojesi.service.DaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daire")
public class DaireController {

    @Autowired
    private DaireService daireService;

    @GetMapping
    public List<Daire> getAllDaire() {
        return daireService.getAllDaire();
    }

    @GetMapping("/{id}")
    public Daire getDaireById(@PathVariable Long id) {
        return daireService.getDaireById(id);
    }

    @PostMapping
    public Daire saveDaire(@RequestBody Daire daire) {
        return daireService.saveDaire(daire);
    }

    @DeleteMapping("/{id}")
    public void deleteDaire(@PathVariable Long id) {
        daireService.deleteDaire(id);
    }
}
