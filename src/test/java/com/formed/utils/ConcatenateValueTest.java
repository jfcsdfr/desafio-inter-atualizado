package com.formed.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ConcatenateValueTest {
	
	@InjectMocks
	private ConcatenateValue service;
	
	 @BeforeEach
	 void setUp() {
		 MockitoAnnotations.openMocks(this);
	 }

	@Test
	public void verificarConcatenacao() {
		
		String valorConcatenado = "9875987598759875";
		
		String valorResultado = service.concatenate("9875", 4);
		
		assertEquals(valorResultado, valorConcatenado);
	}
}
