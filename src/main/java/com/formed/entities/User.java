package com.formed.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<DigitoUnico> digitoUnico;
	
	public User() {
	}

	public User(Long id, String name, String email, List<DigitoUnico> digitoUnico) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.digitoUnico = digitoUnico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<DigitoUnico> getDigitoUnico() {
		return digitoUnico;
	}

	public void setDigitoUnico(List<DigitoUnico> digitoUnico) {
		this.digitoUnico = digitoUnico;
	}
}
