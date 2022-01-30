package com.osf.digital.lojas.controller;

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

import com.osf.digital.lojas.controller.dto.LojaDto;
import com.osf.digital.lojas.controller.form.AtualizaçãoLojaForm;
import com.osf.digital.lojas.controller.form.LojaForm;
import com.osf.digital.lojas.model.Loja;
import com.osf.digital.lojas.repository.LojasRepository;

@RestController
@RequestMapping("/lojas")
public class LojasController {

	@Autowired
	private LojasRepository lojasRepository;

	@GetMapping
	public List<LojaDto> lista(String cidade) {
		if (cidade == null) {
			List<Loja> lojas = lojasRepository.findAll();
			return LojaDto.converter(lojas);

		} else {
			List<Loja> lojas = lojasRepository.findByCidade(cidade);
			return LojaDto.converter(lojas);
		}
	}

	@PostMapping
	public ResponseEntity<LojaDto> adicionarProdutos(@RequestBody @Valid LojaForm lojaForm,
			UriComponentsBuilder uriBuilder) {
		Loja loja = lojaForm.converter(lojasRepository);
		lojasRepository.save(loja);

		URI uri = uriBuilder.path("/lojas/{id}").buildAndExpand(loja.getId()).toUri();
		return ResponseEntity.created(uri).body(new LojaDto(loja));

	}

	@GetMapping("/{id}")
	public ResponseEntity<LojaDto> detalhar(@PathVariable Long id) {
		Optional<Loja> loja = lojasRepository.findById(id);
		if (loja.isPresent()) {
			return ResponseEntity.ok(new LojaDto(loja.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LojaDto> atualizar(@PathVariable Long id, @RequestBody AtualizaçãoLojaForm form) {
		Optional<Loja> optional = lojasRepository.findById(id);
		if (optional.isPresent()) {
			Loja loja = form.atualizar(id, lojasRepository);
			return ResponseEntity.ok(new LojaDto(loja));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Loja> optional = lojasRepository.findById(id);
		if (optional.isPresent()) {
			lojasRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
