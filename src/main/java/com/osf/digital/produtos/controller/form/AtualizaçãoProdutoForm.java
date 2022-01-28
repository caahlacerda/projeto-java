package com.osf.digital.produtos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osf.digital.produtos.model.Produto;
import com.osf.digital.produtos.repository.ProdutosRepository;

public class AtualizaçãoProdutoForm {

	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	private Double preco;
	@NotNull
	@NotEmpty
	private String categoria;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Produto atualizar(Long id, ProdutosRepository produtosRepository) {
		Produto produto = produtosRepository.getById(id);

		produto.setName(this.name);
		produto.setPreco(this.preco);
		produto.setCategoria(this.categoria);

		return produto;
	}
}
