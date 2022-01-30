package com.osf.digital.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.digital.staff.model.Staff;

public interface StaffsRepository extends JpaRepository<Staff, Long> {

	List<Staff> findByName(String name);

	
	
}