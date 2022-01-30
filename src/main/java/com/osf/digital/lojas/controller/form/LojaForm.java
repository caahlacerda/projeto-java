package com.osf.digital.lojas.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osf.digital.lojas.model.Loja;
import com.osf.digital.lojas.repository.LojasRepository;

public class LojaForm {

	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String estado;
	@NotNull
	@NotEmpty
	private String cidade;
	@NotNull
	private Long CNPJ;
	
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
	public Long getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(Long cNPJ) {
		CNPJ = cNPJ;
	}
	
	public Loja converter(LojasRepository lojasRepository) {
		return new Loja(name, estado, cidade, CNPJ);
	}

	public Loja atualizar(Long id, LojasRepository lojasRepository) {
		return null;
	}
}
