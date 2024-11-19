package com.example.cpimgroup.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.cpimgroup.dto.UsuarioDto;
import com.example.cpimgroup.dto.UsuarioRequest;
import com.example.cpimgroup.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public ResponseEntity<?> findById(int id);
	
	
	public ResponseEntity<?> save(UsuarioDto usuarioDto);
	public ResponseEntity<?> delete(int id);
	
	public ResponseEntity<?> update(UsuarioRequest usuarioRequest);
	
	boolean existsByEmail(String email);

}
