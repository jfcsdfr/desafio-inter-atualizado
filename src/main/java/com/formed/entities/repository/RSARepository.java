package com.formed.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formed.entities.RSA;

public interface RSARepository extends JpaRepository<RSA, Long> {

	RSA findByIdUser(Long id);
}
