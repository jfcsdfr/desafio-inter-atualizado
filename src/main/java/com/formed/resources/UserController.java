package com.formed.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formed.entities.DigitoUnico;
import com.formed.entities.User;
import com.formed.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
@Api(value = "users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retorna uma lista de usuários")
	public ResponseEntity<List<User>> listUser() {
		return ResponseEntity.ok(service.listUser());
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retorna um usuario pelo id")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		return ResponseEntity.ok(service.user(id));
	}
	
	@GetMapping(value = "{id}/digitos", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retorna uma lista de calculos pelo id do usuário")
	public ResponseEntity<List<DigitoUnico>> listOfDigits(@PathVariable Long id) {
		return ResponseEntity.ok(service.listOfdigits(id));
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retorna um usuário salvo")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveUser(user));
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "atualiza um usuário")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
		return ResponseEntity.ok(service.updateUser(user, id));
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "deleta um usuário")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
