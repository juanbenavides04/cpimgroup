package com.example.cpimgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cpimgroup.entities.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
	


}
