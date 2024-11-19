package com.example.cpimgroup.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.cpimgroup.dto.Mensaje;
import com.example.cpimgroup.dto.PhonesDto;
import com.example.cpimgroup.dto.PhonesRequest;
import com.example.cpimgroup.dto.UsuarioDto;
import com.example.cpimgroup.dto.UsuarioRequest;
import com.example.cpimgroup.dto.UsuarioResponse;
import com.example.cpimgroup.entities.Usuario;
import com.example.cpimgroup.entities.Phone;
import com.example.cpimgroup.repository.UsuarioRepository;
import com.example.cpimgroup.repository.PhoneRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PhoneRepository phoneRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		// TODO Auto-generated method stub
		Mensaje mensaje=new Mensaje();
		
		if(!usuarioRepository.existsById(id)) {
			
			mensaje.setMensaje("El usuario no existe");
			return new ResponseEntity<Mensaje>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);	
		}else {
			
		//	Optional<Usuario> usuarioPorId =usuarioRepository.findById(id);
		//	return new ResponseEntity<Usuario>(HttpStatus.OK);	
			Optional<Usuario> usuarioPorId =usuarioRepository.findById(id);
			return new ResponseEntity<Usuario>(usuarioPorId.get(),HttpStatus.OK);
		}
		
	}

	
	@Override
	public ResponseEntity<?> save(UsuarioDto usuarioDto) {
		
		
		
		Mensaje mensaje=new Mensaje();
		mensaje.setMensaje("El correo ya registrado");
		if(usuarioRepository.existsByEmail(usuarioDto.getEmail())) {
		
			
			//return new ResponseEntity<Map<Mensaje, Object>>(mensaje, HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Mensaje>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);	
			
		}else {
			
			Usuario usuarioNew =new Usuario ();
			
			
			
			usuarioNew.setName(usuarioDto.getName());
			usuarioNew.setEmail(usuarioDto.getEmail());
			usuarioNew.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
			usuarioNew.setIsactive(true);
			usuarioNew.setCreated(new Date());
			
			
		//	phoneRepository.save(usuarioDto.getPhone());
			
			List<Phone> listaPhones=new ArrayList<>();
		
			for (PhonesDto p:usuarioDto.getPhones()) {
				Phone phonesNew=new Phone();
				phonesNew.setCitycode(p.getCitycode());
				phonesNew.setContrycode(p.getContrycode());
				phonesNew.setNumber(p.getNumber());
				listaPhones.add(phonesNew);
				}
		
			usuarioNew.setPhone(listaPhones);
			
			Usuario usuarioResponseSave=usuarioRepository.save(usuarioNew);
		       try {
		       
					UsuarioResponse usuarioResponse=new UsuarioResponse();
					usuarioResponse.setId(usuarioResponseSave.getId());
					usuarioResponse.setCreated(usuarioResponseSave.getCreated());
					usuarioResponse.setModified(usuarioResponseSave.getModified());
					usuarioResponse.setLast_login(usuarioResponseSave.getLast_login());
					
					return new ResponseEntity<UsuarioResponse>(usuarioResponse,HttpStatus.OK);
		        }
		        catch (Exception e){
		            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		        	mensaje.setMensaje("Error al insertar datos");
		        	return new ResponseEntity<Mensaje>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);
		        }
			
			//return usuarioRepository.save(usuarioNew);
		//	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
	
		}
		

	}

	@Override
	public ResponseEntity<?> delete(int id) {
		// TODO Auto-generated method stub
		//int idAUx=(int) (long)id;
		Mensaje mensaje=new Mensaje();
		
		if(!usuarioRepository.existsById(id)) {
			
			mensaje.setMensaje("El usuario no puede ser Eliminado por que no existe");
			return new ResponseEntity<Mensaje>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);	
		}else {

			try {
				usuarioRepository.deleteById(id);
				mensaje.setMensaje("El usuario eliminado correctamente");
				return new ResponseEntity<Mensaje>(mensaje,HttpStatus.OK);	
			} catch (Exception e) {
				mensaje.setMensaje("El usuario no pudo ser eliminado eliminado");
				return new ResponseEntity<Mensaje>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		}
		
		
	}

	@Override
	public ResponseEntity<?> update(UsuarioRequest usuarioRequest) {
		
		int id=(int) (long)usuarioRequest.getId();
		
	
		Mensaje mensaje=new Mensaje();
		
		if(!usuarioRepository.existsById(id)) {
			
			mensaje.setMensaje("El usuario mo puede ser modificado por que no existe");
			return new ResponseEntity<Mensaje>(mensaje,HttpStatus.BAD_REQUEST);	
		}else {
		
	
			Optional<Usuario> usuarioPorId =usuarioRepository.findById(id);
			
			Usuario usuarioNew =new Usuario ();
			
			
			usuarioNew.setId(usuarioRequest.getId());
			usuarioNew.setName(usuarioRequest.getName());
			usuarioNew.setEmail(usuarioRequest.getEmail());
			usuarioNew.setPassword(usuarioRequest.getPassword());
			usuarioNew.setIsactive(true);
			usuarioNew.setModified(new Date());
			usuarioNew.setCreated(usuarioPorId.get().getCreated());
			
			
		//	phoneRepository.save(usuarioDto.getPhone());
			
			List<Phone> listaPhones=new ArrayList<>();
		
			for (PhonesRequest p:usuarioRequest.getPhones()) {
				Phone phonesNew=new Phone();
				phonesNew.setCitycode(p.getCitycode());
				phonesNew.setContrycode(p.getContrycode());
				phonesNew.setNumber(p.getNumber());
				listaPhones.add(phonesNew);
				}
		
			usuarioNew.setPhone(listaPhones);
			
			Usuario usuarioResponseSave=usuarioRepository.save(usuarioNew);
		       try {
		       
					UsuarioResponse usuarioResponse=new UsuarioResponse();
					usuarioResponse.setId(usuarioResponseSave.getId());
					usuarioResponse.setCreated(usuarioResponseSave.getCreated());
					usuarioResponse.setModified(usuarioResponseSave.getModified());
					usuarioResponse.setLast_login(usuarioResponseSave.getLast_login());
					
					return new ResponseEntity<UsuarioResponse>(usuarioResponse,HttpStatus.OK);
		        }
		        catch (Exception e){
		            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		        	mensaje.setMensaje("Error al  modificar");
		        	return new ResponseEntity<Mensaje>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);
		        }
			
			//return usuarioRepository.save(usuarioNew);
		//	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
	
	}

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

}
