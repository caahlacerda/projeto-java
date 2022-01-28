package com.osf.digital.produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.digital.produtos.model.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByCategoria(String categoria);

	
	
}
