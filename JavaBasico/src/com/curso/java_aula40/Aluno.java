package com.curso.java_aula40;

public class Aluno extends Pessoa {
	
	private String curso;
	private double[] notas;
	
	
	
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
	
	public String obterEnderecoEtiqueta(){
		
		String t = "Endere�o do Aluno: ";
		t += super.getEndereco();
		return t;
	}
			
}
