package com.curso.java_aula37;

public class Aluno extends Pessoa {
	
	
	private String curso;
	private double[] notas;
	
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
