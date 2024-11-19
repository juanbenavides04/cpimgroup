package com.example.cpimgroup.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.cpimgroup.dto.PhonesDto;
import com.example.cpimgroup.dto.UsuarioDto;
import com.example.cpimgroup.dto.UsuarioResponse;
import com.example.cpimgroup.service.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class UsuarioControllerTests {
	
    @Autowired
    private MockMvc mockMvc;
	
	@MockBean 
    private IUsuarioService iUsuarioService;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Test
    void testGuardarUsuario() throws Exception {
		
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
    	
    	
        //when
        ResultActions response = mockMvc.perform(post("/api/save")
                .contentType(MediaType.APPLICATION_JSON) // le decimos el tipo que le eviados al servicio o controlador
                .content(objectMapper.writeValueAsString(usuarioDtoNew))); // combierte el objeto que enviamos en un json

        //then
        response.andDo(print())
                .andExpect(status().isCreated());
		
	}

}
