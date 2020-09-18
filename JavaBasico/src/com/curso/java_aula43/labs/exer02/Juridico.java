package com.curso.java_aula43.labs.exer02;

public class Juridico extends Contribuinte {
	
	private int cnpj;
	private int inscest;
	
	
	
	public Juridico() {
	}
	public Juridico(String nome, String edereco, String telefone) {
		super(nome, edereco, telefone);
		
	}
	public Juridico(int cnpj, int inscest) {
		super();
		this.cnpj = cnpj;
		this.inscest = inscest;
	}
	public int getCnpj() {
		return cnpj;
	}
	public int getInscest() {
		return inscest;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public void setInscest(int inscest) {
		this.inscest = inscest;
	}
	
}
