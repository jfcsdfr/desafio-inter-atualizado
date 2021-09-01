package com.formed.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formed.entities.DigitoUnico;
import com.formed.service.DigitoUnicoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/digitosUnicos")
@Api(value = "digitosUnicos")
public class DigitoUnicoController {
	
	@Autowired
	private DigitoUnicoService service;

	@GetMapping(value = "/calculo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retorna um caclulo de digito único!")
	public ResponseEntity<DigitoUnico> getDigitoUnico(@RequestParam(name = "n", required = true) String n, 
									  @RequestParam(name = "k", required = false) Integer k,
									  @RequestParam(name = "user", required = false) Long user) {
		return ResponseEntity.ok(service.generate(k, n, user));
	}
} 
