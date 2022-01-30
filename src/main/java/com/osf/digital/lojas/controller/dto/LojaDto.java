package com.osf.digital.lojas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.osf.digital.lojas.model.Loja;

public class LojaDto {

	private Long id;
	private String name;
	private String estado;
	private String cidade;
	private Long cnpj;

	public LojaDto(Loja loja) {
		this.id = loja.getId();
		this.name = loja.getName();
		this.estado = loja.getEstado();
		this.cidade = loja.getCidade();
		this.cnpj = loja.getCnpj();
	}
	
	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getEstado() {
		return estado;
	}



	public String getCidade() {
		return cidade;
	}



	public Long getCnpj() {
		return cnpj;
	}

	public static List<LojaDto> converter(List<Loja> lojas) {
		return lojas.stream().map(LojaDto::new).collect(Collectors.toList());
	}
	
}