package com.axam.springrestapi.service;

import java.util.List;

import com.axam.springrestapi.entity.Beneficiaire;

public interface BeneficiaireService {
    List<Beneficiaire> retrieveAllBeneficiaires();

    Beneficiaire addBeneficiaire(Beneficiaire e);

    Beneficiaire updateBeneficiaire(Long idBeneficiaire, Beneficiaire e);

    Beneficiaire retrieveBeneficiaire(Long idBeneficiaire);

    void removeBeneficiaire(Long idBeneficiaire);
}