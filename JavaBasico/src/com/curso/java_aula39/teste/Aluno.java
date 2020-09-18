package com.curso.java_aula39.teste;

import com.curso.java_aula39.Pessoa;

public class Aluno extends Pessoa {
	
	private String curso;
	private double[] notas;
	
	public void verificaAcesso() {
	
		this.nomeVisibilidade = "asdajda";
		super.nomeVisibilidade = "adsdask";
	
	}
	
	
	public Aluno() {
		super ();
	}
	
	
	
	
	public Aluno(String nome, String endereco, String telefone, String curso) {
		super(nome, endereco, telefone);
		this.curso = curso;
	}



	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public double[] getNotas() {
		return notas;
	}
	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	public double calculaMedia() {
		return 0;
	}
	public boolean verificarAprovado(){
		return true;
	}
}
