package com.axam.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axam.springrestapi.entity.Beneficiaire;
import com.axam.springrestapi.service.BeneficiaireService;

import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Beneficiaire")
@RestController
@RequestMapping("/api/v1/Beneficiaires")
public class BeneficiaireController {
	@Autowired
	BeneficiaireService beneficiaireService;

	@GetMapping()
	public List<Beneficiaire> getAllBeneficiaires() {
		return beneficiaireService.retrieveAllBeneficiaires();
	}

	@PostMapping()
	public ResponseEntity<Beneficiaire> createBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
		 Beneficiaire createdBeneficiaire = beneficiaireService.addBeneficiaire(beneficiaire);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdBeneficiaire);
	}

	@GetMapping("/{id}")
	public Beneficiaire getBeneficiaireById(@PathVariable(value = "id") Long idBeneficiaire) {
		return beneficiaireService.retrieveBeneficiaire(idBeneficiaire);
	}

	@PutMapping("/{id}")
	public Beneficiaire updateBeneficiaire(@PathVariable(value = "id") Long idBeneficiaire, @RequestBody Beneficiaire beneficiaireDetails) {
		Beneficiaire updatedBeneficiaire = beneficiaireService.updateBeneficiaire(idBeneficiaire, beneficiaireDetails);
		return updatedBeneficiaire;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteBeneficiaire(@PathVariable(value = "id") Long idBeneficiaire) {
		beneficiaireService.removeBeneficiaire(idBeneficiaire);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}