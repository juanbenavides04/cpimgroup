package com.example.cpimgroup.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;


import com.example.cpimgroup.dto.PhonesDto;
import com.example.cpimgroup.dto.UsuarioDto;
import com.example.cpimgroup.dto.UsuarioResponse;
import com.example.cpimgroup.entities.Phone;
import com.example.cpimgroup.repository.UsuarioRepository;



@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTests {
	
    @Mock
    private UsuarioRepository usuarioRepository ;

    @InjectMocks
    private UsuarioServiceImp UsuarioService;	
    
    
    @DisplayName("Test para guardar un empleado")
    @Test
    void testGuardarUsuario() throws ParseException{
    	
    	List<PhonesDto> listaPhones=new ArrayList<>();
    	
    	PhonesDto phonesDtoNew=new PhonesDto();
    	phonesDtoNew.setNumber("1234567");
    	phonesDtoNew.setCitycode("1");
    	phonesDtoNew.setContrycode("57");
    	
    	listaPhones.add(phonesDtoNew);
    	
    	
    	UsuarioDto usuarioDtoNew= new UsuarioDto();
    	usuarioDtoNew.setName("Juan Rodriguez");
    	usuarioDtoNew.setEmail("juan@rodriguez.org");
    	usuarioDtoNew.setPassword("hunter2");
    	usuarioDtoNew.setPhones(listaPhones);
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    	String dateInString = "2024-11-18T19:08:44.961-03:00";
    	Date date = formatter.parse(dateInString);
    	
    	UsuarioResponse usuarioResponse=new UsuarioResponse();
    	usuarioResponse.setId(1L);
    	usuarioResponse.setCreated(date);
    	usuarioResponse.setModified(date);
    	usuarioResponse.setLast_login(date);
    	
    	
        //given
        given(usuarioRepository.existsByEmail(usuarioDtoNew.getEmail()))
                .willReturn(true);
        given(usuarioRepository.save(usuarioDtoNew)).willReturn(usuarioResponse);

        //when
        ResponseEntity<?> usuarioGuarda = UsuarioService.save(usuarioDtoNew);

        //then
        assertThat(usuarioGuarda).isNotNull();
    }

}
