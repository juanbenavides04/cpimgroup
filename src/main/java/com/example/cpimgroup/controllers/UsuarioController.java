package com.example.cpimgroup.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cpimgroup.dto.UsuarioDto;
import com.example.cpimgroup.dto.UsuarioRequest;
import com.example.cpimgroup.entities.Usuario;
import com.example.cpimgroup.service.IUsuarioService;



@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	IUsuarioService iUsuarioService;
	
    @PostMapping("/save")
    public ResponseEntity<?> save( @RequestBody UsuarioDto usuarioDto) {
    	
    	
    	ResponseEntity<?> usuario = iUsuarioService.save(usuarioDto);
        return usuario;
    	/*
        try {
        	ResponseEntity<?> usuario = iUsuarioService.save(usuarioDto);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/
    }
    
    @PostMapping("/save2")
    public UsuarioDto saveBook2( @RequestBody UsuarioDto usuarioDto) {
       return usuarioDto;
    }
    
    @GetMapping("/all")
    public List<Usuario>  all() {
        return iUsuarioService.findAll();
     }
    
    @PutMapping("/update")
    public ResponseEntity<?> update( @RequestBody UsuarioRequest usuarioRequest) {
    	
    	
    	ResponseEntity<?> usuario = iUsuarioService.update(usuarioRequest);
        return usuario;
    	/*
        try {
        	ResponseEntity<?> usuario = iUsuarioService.save(usuarioDto);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
    	return  iUsuarioService.delete(id);
    }
    
    @GetMapping("/buscarid/{id}")
    public ResponseEntity<?> buscarid(@PathVariable("id") int id) {
    	return  iUsuarioService.findById(id);
    }
}
