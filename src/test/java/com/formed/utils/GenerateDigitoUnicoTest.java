package com.formed.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class GenerateDigitoUnicoTest {

	@InjectMocks
	private GenerateDigitoUnico service;
	
	 @BeforeEach
	 void setUp() {
		 MockitoAnnotations.openMocks(this);
	 }

	@Test
	public void verificarConcatenacao() {
		
		Integer valorDigitoUnico = 8;
		
		Integer valorResultadoDigitoUnico = service.generateDigito("9875987598759875");
		
		assertEquals(valorResultadoDigitoUnico, valorDigitoUnico);
	}
}
