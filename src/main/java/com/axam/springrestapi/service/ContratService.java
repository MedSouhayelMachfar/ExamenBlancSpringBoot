package com.axam.springrestapi.service;

import java.util.List;

import com.axam.springrestapi.entity.Contrat;

public interface ContratService {
    // Wanted Methods
    public Contrat getContratBf (int idBf);

    // CRUD Operations
    List<Contrat> retrieveAllContrats();

    Contrat addContrat(Contrat e);

    Contrat updateContrat(Long idContrat, Contrat e);

    Contrat retrieveContrat(Long idContrat);

    void removeContrat(Long idContrat);
}
