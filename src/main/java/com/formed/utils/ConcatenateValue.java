package com.formed.utils;

import org.springframework.stereotype.Service;

@Service
public class ConcatenateValue {
	
	//valor referente a concatenação dos valores recebidos via parametro do metodo.
	String p;
	
	/**
	 * metodo responsavel por concatenar em uma unica string
	 * n = a string de um valor inteiro recebido via controlador
	 * k = inteiro responsavel pela quantidade de repetições da concatenização 
	 * 
	 * @param n
	 * @param k
	 * @return String
	 */
	public String concatenate(String n, Integer k) {
		
		for(int i = 0; i < k; i++) {
			if(i == 0) {
				p = n;
			}else {
				p = p + n;
			}
		}
		
		return p;
	}
}
