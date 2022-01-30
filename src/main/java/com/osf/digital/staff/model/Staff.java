package com.osf.digital.staff.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String cargo;
	private String setor;

	public Staff() {

	}

	public Staff(String name, String cargo, String setor) {
		this.name = name;
		this.cargo = cargo;
		this.setor = setor;

	}

	@Override
	public int hashCode() {
		return Objects.hash(cargo, id, name, setor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return Objects.equals(cargo, other.cargo) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(setor, other.setor);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
}