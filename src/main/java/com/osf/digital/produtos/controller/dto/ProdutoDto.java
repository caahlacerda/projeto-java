package com.osf.digital.produtos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.osf.digital.produtos.model.Produto;

public class ProdutoDto {

	private Long id;
	private String name;
	private Double preco;
	private String categoria;

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.name = produto.getName();
		this.preco = produto.getPreco();
		this.categoria = produto.getCategoria();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPreco() {
		return preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public static List<ProdutoDto> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}

}
