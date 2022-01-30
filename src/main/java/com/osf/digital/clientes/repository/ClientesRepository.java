package com.osf.digital.clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.digital.clientes.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByName(String name);

	
	
}