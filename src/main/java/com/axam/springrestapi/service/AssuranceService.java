package com.axam.springrestapi.service;

import java.util.List;

import com.axam.springrestapi.entity.Assurance;

public interface AssuranceService {
    List<Assurance> retrieveAllAssurances();

    Assurance addAssurance(Assurance e);

    Assurance updateAssurance(Long idAssurance, Assurance e);

    Assurance retrieveAssurance(Long idAssurance);

    void removeAssurance(Long idAssurance);
}