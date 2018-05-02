package com.identific.model;

import javax.persistence.*;

@Entity
public class Localidade {

	@Id
	private Long id;
	
	private String cidade="";
	
	private String uf="";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
