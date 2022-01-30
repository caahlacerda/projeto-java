package com.osf.digital.clientes.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer idade;
	private String email;
	private Long telefone;


	public Cliente() {

	}

	public Cliente(String name, Integer idade, String email, Long telefone) {
		this.name = name;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, idade, name, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(idade, other.idade)
				&& Objects.equals(name, other.name) && Objects.equals(telefone, other.telefone);
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

}