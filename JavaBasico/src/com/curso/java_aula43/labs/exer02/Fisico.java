package com.curso.java_aula43.labs.exer02;

public class Fisico extends Contribuinte {
	private int cpf;
	private int rg;
	
	
	public Fisico() {}	
	public Fisico(String nome, String edereco, String telefone) {
		super(nome, edereco, telefone);
	}
	public int getCpf() {
		return cpf;
	}
	public int getRg() {
		return rg;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	
	public void aliqutaImposto() {}
	
	public boolean calcularImposto(){}
	
}
