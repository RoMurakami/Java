package com.curso.java_aula43.labs.exer02;

public class Contribuinte {

	private String nome;
	private String edereco;
	private String telefone;
	private double rendaBruta;
	private double valorImposto;
	private double aliquota;
	
	public Contribuinte() {
		
	}
	
	public Contribuinte(double rendaBruta, double valorImposto, double aliqiota) {
		super();
		this.rendaBruta = rendaBruta;
		this.valorImposto = valorImposto;
		this.aliquota = aliqiota;
	}
	
	public Contribuinte(String nome, String edereco, String telefone) {
		super();
		this.nome = nome;
		this.edereco = edereco;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}public String getEdereco() {
		return edereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEdereco(String edereco) {
		this.edereco = edereco;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public boolean Tipo() {
		return true;
	}

	public double getRendaBruta() {
		return rendaBruta;
	}

	public void setRendaBruta(double rendaBruta) {
		this.rendaBruta = rendaBruta;
	}

	public double getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}

	public double getAliquota() {
		return aliquota;
	}

	public void setAliquota(double aliquota) {
		this.aliquota = aliquota;
	}
	
	

}
