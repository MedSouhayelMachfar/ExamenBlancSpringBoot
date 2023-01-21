package com.axam.springrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axam.springrestapi.entity.Assurance;
import com.axam.springrestapi.entity.Beneficiaire;
import com.axam.springrestapi.exception.ResourceNotFoundException;
import com.axam.springrestapi.repository.AssuranceRepository;
import com.axam.springrestapi.service.AssuranceService;

@Service
public class AssuranceServiceImpl implements AssuranceService {
    @Autowired
    AssuranceRepository assuranceRepository;

    @Override
    public List<Assurance> retrieveAllAssurances() {
        return   assuranceRepository.findAll();
    }

    @Override
    public Assurance addAssurance(Assurance a) {
        return assuranceRepository.save(a);
    }

    @Override
    public Assurance updateAssurance(Long idAssurance, Assurance a) {
        Assurance assurance = assuranceRepository.findById(idAssurance)
				.orElseThrow(() -> new ResourceNotFoundException("Assurance", "idAssurance", idAssurance));

		assurance.setDesignation(a.getDesignation());
		assurance.setMontant(a.getMontant());

		Assurance updatedAssurance = assuranceRepository.save(assurance);
		return updatedAssurance;
    }

    @Override
    public Assurance retrieveAssurance(Long idAssurance) {
        return assuranceRepository.findById(idAssurance)
				.orElseThrow(() -> new ResourceNotFoundException("Assurance", "idAssurance", idAssurance));
    }

    @Override
    public void removeAssurance(Long idAssurance) {
        Assurance Assurance = assuranceRepository.findById(idAssurance).orElseThrow(() -> new ResourceNotFoundException("Assurance", "idAssurance", idAssurance));
		assuranceRepository.delete(Assurance);
    }

    @Override
    public Long ajouterAssurance(Assurance a, int cinBf) {
        Beneficiaire b = new Beneficiaire();
        b.setCin(cinBf);
        a.setBeneficiaire(b);
        return assuranceRepository.save(a).getIdAssurance();
    }
}
