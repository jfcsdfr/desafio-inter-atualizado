package com.formed.entities;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RSA implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	@Lob
	@Column(name = "publicKey" , length = 3000)
	private PublicKey publicKey;
	@Lob
	@Column(name = "privateKey" ,length = 3000)
	private PrivateKey privateKey;
	private Long idUser;
	
	public RSA() {
	}

	public RSA(Long id, PublicKey publicKey, PrivateKey privateKey, Long idUser) {
		super();
		this.id = id;
		this.publicKey = publicKey;
		this.privateKey = privateKey;
		this.idUser = idUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
}
