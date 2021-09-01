package com.formed.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.formed.entities.DigitoUnico;
import com.formed.entities.User;
import com.formed.entities.repository.UserRepository;
import com.formed.exception.NotFoundException;

public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository repository;
	
	private User user;
	private DigitoUnico digitoUnico;
	private List<DigitoUnico> listDigitoUnico;
	 
	
	 @BeforeEach
	 void setUp() {
		 MockitoAnnotations.openMocks(this);
		 user = new User();
		 digitoUnico = new DigitoUnico();
		 listDigitoUnico = new ArrayList<>();
	 }
	
	@org.junit.jupiter.api.Test
	public void retornaUsuario() {
		
		digitoUnico.setId(1L);
		digitoUnico.setK(1);
		digitoUnico.setN("1");
		digitoUnico.setUser(null);
		
		listDigitoUnico.add(digitoUnico);
		
		user.setId(1L);
		user.setName("teste");
		user.setEmail("teste@gmail.com.br");
		user.setDigitoUnico(listDigitoUnico);
		
		when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		
		User userRetorno = userService.user(1L);
		
		assertEquals(userRetorno, user);
		
	}
	
	@org.junit.jupiter.api.Test
	public void retornaDigitos() {
		
		digitoUnico.setId(1L);
		digitoUnico.setK(1);
		digitoUnico.setN("1");
		digitoUnico.setUser(null);
		
		listDigitoUnico.add(digitoUnico);
		
		user.setId(1L);
		user.setName("teste");
		user.setEmail("teste@gmail.com.br");
		user.setDigitoUnico(listDigitoUnico);
		
		when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		
		User userRetorno = userService.user(1L);
		
		assertEquals(userRetorno.getDigitoUnico(), user.getDigitoUnico());
		
	}
	
	@org.junit.jupiter.api.Test
	public void retornaExceptionSeIdAoDeletarNaoExistir() {
		
		 Assertions.assertThrows(NotFoundException.class, () -> {
			 userService.deleteUser(1L);
		 });
	}
}
