package com.axam.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axam.springrestapi.entity.Assurance;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance, Long> {
}