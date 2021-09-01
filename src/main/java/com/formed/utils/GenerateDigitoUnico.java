package com.formed.utils;

import org.springframework.stereotype.Service;

@Service
public class GenerateDigitoUnico {
	
	Integer digitoUnico;
	
	/**
	 * metodo responsavel pelo calculo e geração do digito
	 * 
	 * p = ao valor oriundo da concatenização, ou o valor unitario oriundo do controlador
	 * 
	 * @param p
	 * @return Integer
	 */

	public Integer generateDigito(String p) {
		
		Integer soma = 0;
		Integer finalSoma = 0;
		
		Long integerValue = Long.parseLong(p);
		
		if(p.length() == 1) {
			finalSoma = Integer.parseInt(integerValue.toString());
		}else {
			String[] values = p.split("");
			
			for(int i = 0; i < values.length; i++) {
				soma = soma + Integer.parseInt(values[i]);
			}
			
			String[] addedValues = soma.toString().split("");
			
			for(int i = 0; i < addedValues.length; i++) {
				finalSoma = finalSoma + Integer.parseInt(addedValues[i]);
			}
			
			digitoUnico = finalSoma;
		}
		
		return digitoUnico;
	}
}
