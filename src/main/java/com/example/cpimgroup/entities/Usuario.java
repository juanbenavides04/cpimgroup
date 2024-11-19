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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private String name;
	private String email;
	private String password;
	private boolean isactive;
	private Date created;
	private Date modified;
	private Date last_login;
	
	//@OneToMany(mappedBy = "phone", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)   
	//@OneToMany(mappedBy = "phone", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true) 
	//@OneToMany(cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "usuario_id")
	//@OneToMany(fetch=FetchType.LAZY,mappedBy = "phone",cascade = jakarta.persistence.CascadeType.ALL)
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="usuario",cascade = jakarta.persistence.CascadeType.ALL )
	// @OneToMany(mappedBy = "usuario_id", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario",cascade = jakarta.persistence.CascadeType.ALL )
	@OneToMany(cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "fk_usu_id",referencedColumnName = "id")
	@JsonIgnoreProperties(value={"usuario","hibernateLazyInitializer","handler"},allowSetters = true)
	private List<Phone> phone;
	

	public Usuario() {
	
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isIsactive() {
		return isactive;
	}


	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getModified() {
		return modified;
	}


	public void setModified(Date modified) {
		this.modified = modified;
	}


	public Date getLast_login() {
		return last_login;
	}


	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}


	public List<Phone> getPhone() {
		return phone;
	}


	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}



}
