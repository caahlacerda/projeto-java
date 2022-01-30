package com.osf.digital.staff.controller;

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

import com.osf.digital.staff.controller.dto.StaffDto;
import com.osf.digital.staff.controller.form.AtualizaçãoStaffForm;
import com.osf.digital.staff.controller.form.StaffForm;
import com.osf.digital.staff.model.Staff;
import com.osf.digital.staff.repository.StaffsRepository;


	@RestController
	@RequestMapping("/staff")
	public class StaffController {

		@Autowired
		private StaffsRepository staffsRepository;

		@GetMapping
		public List<StaffDto> lista(String name) {
			if (name == null) {
				List<Staff> staffs = staffsRepository.findAll();
				return StaffDto.converter(staffs);

			} else {
				List<Staff> staffs = staffsRepository.findByName(name);
				return StaffDto.converter(staffs);
			}
		}

		@PostMapping
		public ResponseEntity<StaffDto> adicionarProdutos(@RequestBody @Valid StaffForm staffForm,
				UriComponentsBuilder uriBuilder) {
			Staff staff = staffForm.converter(staffsRepository);
			staffsRepository.save(staff);

			URI uri = uriBuilder.path("/lojas/{id}").buildAndExpand(staff.getId()).toUri();
			return ResponseEntity.created(uri).body(new StaffDto(staff));

		}

		@GetMapping("/{id}")
		public ResponseEntity<StaffDto> detalhar(@PathVariable Long id) {
			Optional<Staff> staff = staffsRepository.findById(id);
			if (staff.isPresent()) {
				return ResponseEntity.ok(new StaffDto(staff.get()));
			}

			return ResponseEntity.notFound().build();
		}

		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<StaffDto> atualizar(@PathVariable Long id, @RequestBody AtualizaçãoStaffForm form) {
			Optional<Staff> optional = staffsRepository.findById(id);
			if (optional.isPresent()) {
				Staff staff = form.atualizar(id, staffsRepository);
				return ResponseEntity.ok(new StaffDto(staff));
			}

			return ResponseEntity.notFound().build();
		}

		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> remover(@PathVariable Long id) {
			Optional<Staff> optional = staffsRepository.findById(id);
			if (optional.isPresent()) {
				staffsRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();
		}

	}
