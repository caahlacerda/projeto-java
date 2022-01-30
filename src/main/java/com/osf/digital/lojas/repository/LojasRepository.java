package com.osf.digital.lojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.digital.lojas.model.Loja;

public interface LojasRepository extends JpaRepository<Loja, Long> {

	List<Loja> findByCidade(String cidade);

	
	
}
