package com.osf.digital.clientes.controller;

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

import com.osf.digital.clientes.controller.dto.ClienteDto;
import com.osf.digital.clientes.controller.form.AtualizaçãoClienteForm;
import com.osf.digital.clientes.controller.form.ClienteForm;
import com.osf.digital.clientes.model.Cliente;
import com.osf.digital.clientes.repository.ClientesRepository;



@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClientesRepository clientesRepository;

	@GetMapping
	public List<ClienteDto> lista(String name) {
		if (name == null) {
			List<Cliente> clientes = clientesRepository.findAll();
			return ClienteDto.converter(clientes);

		} else {
			List<Cliente> clientes = clientesRepository.findByName(name);
			return ClienteDto.converter(clientes);
		}
	}

	@PostMapping
	public ResponseEntity<ClienteDto> adicionarProdutos(@RequestBody @Valid ClienteForm clienteForm,
			UriComponentsBuilder uriBuilder) {
		Cliente cliente = clienteForm.converter(clientesRepository);
		clientesRepository.save(cliente);

		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));

	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> detalhar(@PathVariable Long id) {
		Optional<Cliente> cliente = clientesRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody AtualizaçãoClienteForm form) {
		Optional<Cliente> optional = clientesRepository.findById(id);
		if (optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clientesRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Cliente> optional = clientesRepository.findById(id);
		if (optional.isPresent()) {
			clientesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}