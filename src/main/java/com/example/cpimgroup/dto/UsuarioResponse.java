package com.example.cpimgroup.dto;


import java.util.Date;
import java.util.List;

public class UsuarioResponse{

	private Long id;
	private Date created;
	private Date modified;
	private Date last_login;

	public UsuarioResponse() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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



	

}
