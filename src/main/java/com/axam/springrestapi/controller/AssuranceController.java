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

import com.axam.springrestapi.entity.Assurance;
import com.axam.springrestapi.service.AssuranceService;

import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Assurance")
@RestController
@RequestMapping("/api/v1/assurances")
public class AssuranceController {
	@Autowired
	AssuranceService assuranceService;

	@GetMapping()
	public List<Assurance> getAllAssurances() {
		return assuranceService.retrieveAllAssurances();
	}

	@PostMapping()
	public ResponseEntity<Assurance> createAssurance(@RequestBody Assurance assurance) {
		 Assurance createdAssurance = assuranceService.addAssurance(assurance);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdAssurance);
	}

	@GetMapping("/{id}")
	public Assurance getAssuranceById(@PathVariable(value = "id") Long idAssurance) {
		return assuranceService.retrieveAssurance(idAssurance);
	}

	@PutMapping("/{id}")
	public Assurance updateAssurance(@PathVariable(value = "id") Long idAssurance, @RequestBody Assurance assuranceDetails) {
		Assurance updatedAssurance = assuranceService.updateAssurance(idAssurance, assuranceDetails);
		return updatedAssurance;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteAssurance(@PathVariable(value = "id") Long idAssurance) {
		assuranceService.removeAssurance(idAssurance);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}