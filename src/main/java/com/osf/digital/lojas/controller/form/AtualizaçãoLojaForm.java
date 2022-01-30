package com.osf.digital.lojas.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osf.digital.lojas.model.Loja;
import com.osf.digital.lojas.repository.LojasRepository;

public class AtualizaçãoLojaForm {

	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String estado;
	@NotNull
	private String cidade;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Loja atualizar(Long id, LojasRepository lojasRepository) {
		Loja loja = lojasRepository.getById(id);

		loja.setName(this.name);
		loja.setEstado(this.estado);
		loja.setCidade(this.cidade);

		return loja;
	}
	
}