package com.formed.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.springframework.stereotype.Service;

import com.formed.entities.RSA;

@Service
public class EncriptaDecriptaRSA {

	public static final String ALGORITHM = "RSA";
	
	/**
	 * metodo responsavel por gerar as chaves publicas e privadas
	 * 
	 * @return RSA
	 */
	
	public RSA generateKeys() {
		
		RSA rsa = new RSA();
		
		try {
			final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
			
			keyGen.initialize(2048);
			
			final KeyPair key = keyGen.generateKeyPair();
			
			
			rsa.setPublicKey(key.getPublic());
			rsa.setPrivateKey(key.getPrivate());
			
		} catch (NoSuchAlgorithmException e) {
			
		}
		
		return rsa;
	}
	
	/**
	 * metodo responsavel pela criptografia do texto
	 * 
	 * @param texto
	 * @param chave
	 * @return
	 */
	public static byte[] criptografa(String texto, PublicKey chave) {
	    byte[] cipherText = null;

	    try {
	      final Cipher cipher = Cipher.getInstance(ALGORITHM);
	      cipher.init(Cipher.ENCRYPT_MODE, chave);
	      cipherText = cipher.doFinal(texto.getBytes());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	    return cipherText;
	}
	
	/**
	 * metodo responsavel pela decriptografia do texto
	 * 
	 * @param texto
	 * @param chave
	 * @return
	 */
	public static String decriptografa(byte[] texto, PrivateKey chave) {
	    byte[] dectyptedText = null;

	    try {
	      final Cipher cipher = Cipher.getInstance(ALGORITHM);
	      cipher.init(Cipher.DECRYPT_MODE, chave);
	      dectyptedText = cipher.doFinal(texto);

	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }

	    return new String(dectyptedText);
	}
}
