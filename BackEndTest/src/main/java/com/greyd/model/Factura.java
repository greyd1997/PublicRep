package com.greyd.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Factura {
	
	@Id
	private Integer id; 
	
	@Column 
	private String clientId;
	
	@Column
	private String productsList;
	
	@Column
	private Double priceNoIva;
	
	@Column 
	private Double priceIva;
	
	@Column
	private Double shipping; 
	
	@Column 
	private java.sql.Time Time;
 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getProductsList() {
		return productsList;
	}

	public void setProductsList(String productsList) {
		this.productsList = productsList;
	}

	public Double getPriceNoIva() {
		return priceNoIva;
	}

	public void setPriceNoIva(Double priceNoIva) {
		this.priceNoIva = priceNoIva;
	}

	public Double getPriceIva() {
		return priceIva;
	}

	public void setPriceIva(Double priceIva) {
		this.priceIva = priceIva;
	}

	public Double getShipping() {
		return shipping;
	}

	public void setShipping(Double shipping) {
		this.shipping = shipping;
	}

	public java.sql.Time getTime() {
		return Time;
	}

	public void setTime(java.sql.Time time) {
		Time = time;
	}
	
	
		

}
