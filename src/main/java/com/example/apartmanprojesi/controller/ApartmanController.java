package com.example.apartmanprojesi.controller;

import com.example.apartmanprojesi.entity.Apartman;
import com.example.apartmanprojesi.entity.Daire;
import com.example.apartmanprojesi.service.ApartmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartman")
public class ApartmanController {

    @Autowired
    private ApartmanService apartmanService;

    // Tüm apartmanları listele
    @GetMapping
    public List<Apartman> getAllApartman() {
        return apartmanService.getAllApartman();
    }

    // Belirli bir apartmanı ID'si ile getir
    @GetMapping("/{id}")
    public Apartman getApartmanById(@PathVariable Long id) {
        return apartmanService.getApartmanById(id);
    }

    // Yeni bir apartman ekle
    @PostMapping
    public Apartman saveApartman(@RequestBody Apartman apartman) {
        if (apartman.getDaireler() != null) {
            for (Daire daire : apartman.getDaireler()) {
                daire.setApartman(apartman); // Daireye ilgili apartmanı set ediyoruz
            }
        }
        return apartmanService.saveApartman(apartman);
    }

    // Belirli bir apartmanı güncelle
    @PutMapping("/{id}")
    public Apartman updateApartman(@PathVariable Long id, @RequestBody Apartman apartman) {
        Apartman existingApartman = apartmanService.getApartmanById(id);
        if (existingApartman != null) {
            existingApartman.setAdi(apartman.getAdi());
            existingApartman.setIl(apartman.getIl());
            existingApartman.setIlce(apartman.getIlce());
            existingApartman.setCaddeSokak(apartman.getCaddeSokak());
            existingApartman.setKapiNo(apartman.getKapiNo());
            existingApartman.setKoordinat(apartman.getKoordinat());

            if (apartman.getDaireler() != null) {
                existingApartman.getDaireler().clear();
                for (Daire daire : apartman.getDaireler()) {
                    daire.setApartman(existingApartman); // Daireye ilgili apartmanı set ediyoruz
                    existingApartman.getDaireler().add(daire);
                }
            }

            return apartmanService.saveApartman(existingApartman);
        } else {
            return null; // ya da uygun bir hata mesajı döndürebilirsiniz
        }
    }

    // Belirli bir apartmanı sil
    @DeleteMapping("/{id}")
    public void deleteApartman(@PathVariable Long id) {
        apartmanService.deleteApartman(id);
    }
}
