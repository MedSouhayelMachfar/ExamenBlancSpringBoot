package com.axam.springrestapi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "Contrat")
@Getter @Setter @NoArgsConstructor
public class Contrat implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Long idContrat; // Clé primaire
    private String matricule;
    @Temporal(TemporalType.DATE)
    private Date dateEffet;
    @Enumerated(EnumType.STRING)
    private TypeContrat type;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Assurance> assurances;
}