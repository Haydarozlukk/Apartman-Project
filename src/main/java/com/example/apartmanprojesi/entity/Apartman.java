package com.example.apartmanprojesi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Apartman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apartmanId;
    private String adi;
    private String il;
    private String ilce;
    private String caddeSokak;
    private String kapiNo;
    private String koordinat;

    @OneToMany(mappedBy = "apartman", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Daire> daireler;
}
