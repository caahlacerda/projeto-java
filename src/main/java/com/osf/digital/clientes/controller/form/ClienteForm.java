package com.osf.digital.clientes.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osf.digital.clientes.model.Cliente;
import com.osf.digital.clientes.repository.ClientesRepository;

public class ClienteForm {

	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	private Integer idade;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	private Long telefone;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Cliente converter(ClientesRepository clientesRepository) {
		return new Cliente(name, idade, email, telefone);
	}

	public Cliente atualizar(Long id, ClientesRepository clientesRepository) {
		return null;
	}
}