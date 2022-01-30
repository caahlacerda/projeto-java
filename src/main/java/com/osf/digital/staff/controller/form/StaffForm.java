package com.osf.digital.staff.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osf.digital.staff.model.Staff;
import com.osf.digital.staff.repository.StaffsRepository;


public class StaffForm {

	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String cargo;
	@NotNull
	@NotEmpty
	private String setor;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Staff converter(StaffsRepository staffsRepository) {
		return new Staff(name, cargo, setor);
	}

	public Staff atualizar(Long id, StaffsRepository staffsRepository) {
		return null;
	}
}