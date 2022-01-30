package com.osf.digital.clientes.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osf.digital.clientes.model.Cliente;
import com.osf.digital.clientes.repository.ClientesRepository;


public class AtualizaçãoClienteForm {

	@NotNull
	private Integer idade;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	private Long telefone;
	
	
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


	public Cliente atualizar(Long id, ClientesRepository clientesRepository) {
		Cliente cliente = clientesRepository.getById(id);

		cliente.setIdade(this.idade);
		cliente.setEmail(this.email);
		cliente.setTelefone(this.telefone);

		return cliente;
	}
}
