package com.axam.springrestapi.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axam.springrestapi.entity.Beneficiaire;
import com.axam.springrestapi.entity.TypeContrat;
import com.axam.springrestapi.exception.ResourceNotFoundException;
import com.axam.springrestapi.repository.BeneficiaireRepository;
import com.axam.springrestapi.service.BeneficiaireService;

@Service
public class BeneficiaireServiceImpl implements BeneficiaireService {
    @Autowired
    BeneficiaireRepository beneficiaireRepository;


    @Override
    public List<Beneficiaire> retrieveAllBeneficiaires() {
        return beneficiaireRepository.findAll();
    }

    @Override
    public Beneficiaire addBeneficiaire(Beneficiaire b) {
        return beneficiaireRepository.save(b);
    }

    @Override
    public Beneficiaire updateBeneficiaire(Long idBeneficiaire, Beneficiaire b) {
        Beneficiaire beneficiaire = beneficiaireRepository.findById(idBeneficiaire)
                .orElseThrow(() -> new ResourceNotFoundException("Beneficiaire", "idBeneficiaire", idBeneficiaire));

        beneficiaire.setCin(b.getCin());
        beneficiaire.setNom(b.getNom());
        beneficiaire.setPrenom(b.getPrenom());
        beneficiaire.setProfession(b.getProfession());
        beneficiaire.setSalaire(b.getSalaire());

        Beneficiaire updatedBeneficiaire = beneficiaireRepository.save(beneficiaire);
        return updatedBeneficiaire;
    }

    @Override
    public Beneficiaire retrieveBeneficiaire(Long idBeneficiaire) {
        return beneficiaireRepository.findById(idBeneficiaire)
                .orElseThrow(() -> new ResourceNotFoundException("Beneficiaire", "idBeneficiaire", idBeneficiaire));
    }

    @Override
    public void removeBeneficiaire(Long idBeneficiaire) {
        Beneficiaire Beneficiaire = beneficiaireRepository.findById(idBeneficiaire)
                .orElseThrow(() -> new ResourceNotFoundException("Beneficiaire", "idBeneficiaire", idBeneficiaire));
        beneficiaireRepository.delete(Beneficiaire);
    }

    @Override
    public int ajouterBeneficaire(Beneficiaire bf) {
        return beneficiaireRepository.save(bf).getCin();
    }

    @Override
    public float getMontantBf(int cinBf) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat) {
        // TODO Auto-generated method stub
        return null;
    }
}
