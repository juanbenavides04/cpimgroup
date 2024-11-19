package com.example.cpimgroup.entities;


import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="phone")
public class Phone{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   

	private String number;
	private String citycode;
	private String contrycode;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "id_usuario")
	//@ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="idUsuario")
	@ManyToOne
    @JoinColumn(name = "fk_usu_id")
	@JsonIgnoreProperties(value={"phone","hibernateLazyInitializer","handler"},allowSetters = true)
    private Usuario usuario;
	
	public Phone() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
