package com.axam.springrestapi.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "Beneficiaire")
@Getter @Setter @NoArgsConstructor
public class Beneficiaire implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idBenef")
    private Long idBenef; // Clé primaire
    private int cin;
    private String nom;
    private String prenom;
    private String profession;
    private float salaire;
}