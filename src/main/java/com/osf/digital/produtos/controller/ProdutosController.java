package com.osf.digital.produtos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.osf.digital.produtos.controller.dto.ProdutoDto;
import com.osf.digital.produtos.controller.form.AtualizaçãoProdutoForm;
import com.osf.digital.produtos.controller.form.ProdutoForm;
import com.osf.digital.produtos.model.Produto;
import com.osf.digital.produtos.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutosRepository produtosRepository;

	@GetMapping
	public List<ProdutoDto> lista(String categoria) {
		if (categoria == null) {
			List<Produto> produtos = produtosRepository.findAll();
			return ProdutoDto.converter(produtos);

		} else {
			List<Produto> produtos = produtosRepository.findByCategoria(categoria);
			return ProdutoDto.converter(produtos);
		}
	}

	@PostMapping
	public ResponseEntity<ProdutoDto> adicionarProdutos(@RequestBody @Valid ProdutoForm produtoForm,
			UriComponentsBuilder uriBuilder) {
		Produto produto = produtoForm.converter(produtosRepository);
		produtosRepository.save(produto);

		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDto> detalhar(@PathVariable Long id) {
		Optional<Produto> produto = produtosRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(new ProdutoDto(produto.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody AtualizaçãoProdutoForm form) {
		Optional<Produto> optional = produtosRepository.findById(id);
		if (optional.isPresent()) {
			Produto produto = form.atualizar(id, produtosRepository);
			return ResponseEntity.ok(new ProdutoDto(produto));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Produto> optional = produtosRepository.findById(id);
		if (optional.isPresent()) {
			produtosRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
