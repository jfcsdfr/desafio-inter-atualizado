package com.formed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formed.entities.DigitoUnico;
import com.formed.entities.RSA;
import com.formed.entities.User;
import com.formed.entities.repository.RSARepository;
import com.formed.entities.repository.UserRepository;
import com.formed.exception.NotFoundException;
import com.formed.security.EncriptaDecriptaRSA;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RSARepository rsaRepository;
	
	@Autowired
	private EncriptaDecriptaRSA encript;

	public List<User> listUser() {
		return repository.findAll();
	}
	
	/**
	 * metodo retorna o user por id
	 * 
	 * @param id
	 * @return User
	 */

	public User user(long id) {
		Optional<User> user = repository.findById(id);

		if (user.isPresent()) {
			return user.get();
		} else {
			throw new NotFoundException("User com o Id: " + id + " não encontrado em nossa base de dados!");
		}

	}
	
	/**
	 * metodo retorna uma lista de DigitoUnico
	 * 
	 * @param id
	 * @return List<DigitoUnico>
	 */
	
	public List<DigitoUnico> listOfdigits(Long id) {
		Optional<User> user = repository.findById(id);

		if (user.isPresent()) {

			return user.get().getDigitoUnico();
		} else {
			throw new NotFoundException("User com o Id: " + id + " não encontrado em nossa base de dados!");
		}
	}

	/**
	 * metodo responsavel por deletar um user
	 * 
	 * @param id
	 */
	public void deleteUser(Long id) {
		Optional<User> user = repository.findById(id);

		if (user.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new NotFoundException("User com o Id: " + id + " não encontrado em nossa base de dados!");
		}
	}
	
	/**
	 * metodo retorno um user atualizado
	 * 
	 * @param user
	 * @param id
	 * @return User
	 */
	public User updateUser(User user, Long id) {
		User existingUser = repository.findById(id).get();
		
		RSA rsaUser = rsaRepository.findByIdUser(id);
		
		String nameEncript = encript.criptografa(user.getName(), rsaUser.getPublicKey()).toString();
		
		String emailEncript = encript.criptografa(user.getEmail(), rsaUser.getPublicKey()).toString();
		
		if(existingUser != null) {
			existingUser.setName(nameEncript);
			existingUser.setEmail(emailEncript);
		}else {
			throw new NotFoundException("User com o Id: " + id + " não encontrado em nossa base de dados!");
		}
		
		repository.save(existingUser);
		
		return existingUser;
	}
	
	/**
	 * metodo retorna user salvo
	 * 
	 * @param user
	 * @return User
	 */
	
	public User saveUser(User user) {
		
		RSA rsaUser = encript.generateKeys();
		
		String nameEncript = encript.criptografa(user.getName(), rsaUser.getPublicKey()).toString();
		
		String emailEncript = encript.criptografa(user.getEmail(), rsaUser.getPublicKey()).toString();
		
		user.setEmail(emailEncript);
		user.setName(nameEncript);
		
		User userSalvo = repository.save(user);
		
		rsaUser.setIdUser(userSalvo.getId());
		
		rsaRepository.save(rsaUser);
		
		return userSalvo;
	}
}
