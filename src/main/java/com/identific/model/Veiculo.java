package com.identific.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Veiculo {

	// Chave primaria
	@Id
	private Long id;
	
	private String tipo_veiculo="";
	
	private String marca="";
	
	private String modelo="";
	
	private String cor="";
	
	private String placa="";
	
	private String placa_cid="";
	
	private Long cnh;
	
	

	public Long getCnh() {
		return cnh;
	}

	public void setCnh(Long cnh) {
		this.cnh = cnh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo_veiculo() {
		return tipo_veiculo;
	}

	public void setTipo_veiculo(String tipo_veiculo) {
		this.tipo_veiculo = tipo_veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca_cid() {
		return placa_cid;
	}

	public void setPlaca_cid(String placa_cid) {
		this.placa_cid = placa_cid;
	}
	
}
