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

import com.axam.springrestapi.entity.Contrat;
import com.axam.springrestapi.service.ContratService;

import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Contrat")
@RestController
@RequestMapping("/api/v1/contrats")
public class ContratController {
	@Autowired
	ContratService contratService;

	@GetMapping()
	public List<Contrat> getAllContrats() {
		return contratService.retrieveAllContrats();
	}

	@PostMapping()
	public ResponseEntity<Contrat> createContrat(@RequestBody Contrat contrat) {
		 Contrat createdContrat = contratService.addContrat(contrat);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdContrat);
	}

	@GetMapping("/{id}")
	public Contrat getContratById(@PathVariable(value = "id") Long idContrat) {
		return contratService.retrieveContrat(idContrat);
	}

	@PutMapping("/{id}")
	public Contrat updateContrat(@PathVariable(value = "id") Long idContrat, @RequestBody Contrat contratDetails) {
		Contrat updatedContrat = contratService.updateContrat(idContrat, contratDetails);
		return updatedContrat;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteContrat(@PathVariable(value = "id") Long idContrat) {
		contratService.removeContrat(idContrat);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}