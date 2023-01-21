package com.axam.springrestapi.service;

import java.util.List;
import java.util.Set;

import com.axam.springrestapi.entity.Beneficiaire;
import com.axam.springrestapi.entity.TypeContrat;

public interface BeneficiaireService {
    // Wanted Methods
    int ajouterBeneficaire (Beneficiaire bf);
    public float getMontantBf (int cinBf);
    public Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat);

    
    // CRUD Operations
    List<Beneficiaire> retrieveAllBeneficiaires();

    Beneficiaire addBeneficiaire(Beneficiaire b);

    Beneficiaire updateBeneficiaire(Long idBeneficiaire, Beneficiaire b);

    Beneficiaire retrieveBeneficiaire(Long idBeneficiaire);

    void removeBeneficiaire(Long idBeneficiaire);
}