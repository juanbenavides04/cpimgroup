package com.example.cpimgroup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cpimgroup.dto.UsuarioDto;
import com.example.cpimgroup.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	boolean existsByEmail(String email);

	Object save(UsuarioDto usuarioDtoNew);
	
	Optional<Usuario> findByEmail(String email);

}
