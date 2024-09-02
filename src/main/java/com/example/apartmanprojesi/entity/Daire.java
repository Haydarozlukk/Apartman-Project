package com.example.apartmanprojesi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Daire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long daireId;
    private String daireNo;
    private int kat;
    private int odaSayisi;


    @ManyToOne
    @JoinColumn(name = "apartman_id")
    private Apartman apartman;
}

