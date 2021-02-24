package com.greyd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	
	@Id
	private Integer id;
	
	@Column
	private String identification;
	
	@Column
	private String address;

	public Integer getId() {
		return id;
	}

	
	//Gets & Sets
	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
