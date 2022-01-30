package com.osf.digital.staff.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

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

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCargo() {
		return cargo;
	}

	public String getSetor() {
		return setor;
	}
	
	public static List<StaffDto> converter(List<Staff> staffs) {
		return staffs.stream().map(StaffDto::new).collect(Collectors.toList());
	}
}