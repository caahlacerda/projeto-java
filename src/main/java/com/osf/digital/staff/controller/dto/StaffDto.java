package com.osf.digital.staff.controller.dto;

import com.osf.digital.staff.model.Staff;

public class StaffDto {

	private Long id;
	private String name;
	private String cargo;
	private String setor;

	public StaffDto(Staff staff) {
		this.id = staff.getId();
		this.name = staff.getName();
		this.cargo = staff.getCargo();
		this.setor = staff.getSetor();
	}
}