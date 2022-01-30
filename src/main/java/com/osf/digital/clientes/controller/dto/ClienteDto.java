package com.osf.digital.clientes.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.osf.digital.clientes.model.Cliente;

public class ClienteDto {

	private Long id;
	private String name;
	private Integer idade;
	private String email;
	private Long telefone;

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.name = cliente.getName();
		this.idade = cliente.getIdade();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
	}
	
	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public Integer getIdade() {
		return idade;
	}



	public String getEmail() {
		return email;
	}



	public Long getTelefone() {
		return telefone;
	}


	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
}