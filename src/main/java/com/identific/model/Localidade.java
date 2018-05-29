package com.identific.model;

import javax.persistence.*;

@Entity
public class Localidade {

	@Id
	private Long id;
	
	private String estacao="";
	
	private String rua="";
	
	private Long nro;
	
	private String bairro="";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstacao() {
		return estacao;
	}

	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Long getNro() {
		return nro;
	}

	public void setNro(Long nro) {
		this.nro = nro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	

}
