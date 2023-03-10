package com.axam.springrestapi.entity;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private String profession;
    @NotNull
    private float salaire;

    // Association
    @OneToMany(cascade = CascadeType.ALL, mappedBy="beneficiaire")
    private Set<Assurance> assurances;
}