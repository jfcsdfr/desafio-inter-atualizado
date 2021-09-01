package com.formed.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DigitoUnico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	private String n;
	private Integer k;
	private Integer digitoUnico;
	
	@ManyToOne
	@JoinColumn(name="user")
	@JsonIgnore
	private User user;
	
	public DigitoUnico() {
	}

	public DigitoUnico(Long id, String n, Integer k, Integer digitoUnico, User user) {
		super();
		this.id = id;
		this.n = n;
		this.k = k;
		this.digitoUnico = digitoUnico;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public Integer getK() {
		return k;
	}

	public void setK(Integer k) {
		this.k = k;
	}

	public Integer getDigitoUnico() {
		return digitoUnico;
	}

	public void setDigitoUnico(Integer digitoUnico) {
		this.digitoUnico = digitoUnico;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
