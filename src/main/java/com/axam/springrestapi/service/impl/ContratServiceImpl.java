package com.axam.springrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axam.springrestapi.entity.Contrat;
import com.axam.springrestapi.exception.ResourceNotFoundException;
import com.axam.springrestapi.repository.ContratRepository;
import com.axam.springrestapi.service.ContratService;

@Service
public class ContratServiceImpl implements ContratService {
    @Autowired
    ContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return   contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Long idContrat, Contrat c) {
        Contrat contrat = contratRepository.findById(idContrat)
				.orElseThrow(() -> new ResourceNotFoundException("Contrat", "idContrat", idContrat));

		contrat.setMatricule(c.getMatricule());
		contrat.setDateEffet(c.getDateEffet());
		contrat.setType(c.getType());

		Contrat updatedContrat = contratRepository.save(contrat);
		return updatedContrat;
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat)
				.orElseThrow(() -> new ResourceNotFoundException("Contrat", "idContrat", idContrat));
    }

    @Override
    public void removeContrat(Long idContrat) {
        Contrat contrat = contratRepository.findById(idContrat).orElseThrow(() -> new ResourceNotFoundException("Contrat", "idContrat", idContrat));
		contratRepository.delete(contrat);
    }

    @Override
    public Contrat getContratBf(int idBf) {
        // TODO Auto-generated method stub
        return null;
    }
}
