package com.axam.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axam.springrestapi.entity.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
}