package com.formed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formed.cache.ICacheImpl;
import com.formed.entities.DigitoUnico;
import com.formed.entities.User;
import com.formed.entities.repository.DigitoUnicoRepository;
import com.formed.utils.ConcatenateValue;
import com.formed.utils.GenerateDigitoUnico;

@Service
public class DigitoUnicoService {

	@Autowired
	private ConcatenateValue concatenateValue;
	
	@Autowired
	private DigitoUnicoRepository repository;
	
	@Autowired
	private GenerateDigitoUnico generateDigitoUnico;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ICacheImpl cache;
	
	/**
	 * metodo responsavel por gerar o digito unico
	 * 
	 * @param k
	 * @param n
	 * @param user
	 * @return DigitoUnico
	 */
	
	public DigitoUnico generate(Integer k, String n, Long user) {
		
		cache.getInstance();
		
		DigitoUnico digitoUnicoInCache = cache.get(n);
		
		if(digitoUnicoInCache != null) {
			if(digitoUnicoInCache.getK() == k) {
				return digitoUnicoInCache;
			}
		}
		
		DigitoUnico digitoUnico = new DigitoUnico();
		digitoUnico.setK(k);
		digitoUnico.setN(n);
		
		User existingUser = userService.user(user);
		if(existingUser != null) {
			digitoUnico.setUser(existingUser);
		}else {
			digitoUnico.setUser(null);
		}
		
		String concatenatedValue = concatenateValue.concatenate(n, k);
		
		Integer typeValue = generateDigitoUnico.generateDigito(concatenatedValue);
		digitoUnico.setDigitoUnico(typeValue);
		
		DigitoUnico digitoUnicoSalvo = repository.save(digitoUnico);
		
		cache.add(n, digitoUnicoSalvo);
		
		return digitoUnicoSalvo;
		
	}
}
