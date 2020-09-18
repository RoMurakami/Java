package com.curso.java_aula43;

import java.util.Arrays;

public class Aluno {
	
	private String curso;
	private double[] notas;
	
	
	
	public Aluno() {
		super ();
	}
	
	
	
	public Aluno(String nome, String endereco, String telefone, String curso) {
		//super(nome, endereco, telefone);
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
		
		String t = "Endereço do Aluno: ";
		//t += super.getEndereco();
		return t;
	}



	//@Override
	public String obterEtiquetaEndereco() {
		return null;
	}



	//@Override
	public void imprimirEtiquetaEndereco() {
		
		System.out.println(this.obterEnderecoEtiqueta());
	}



	@Override
	public String toString() {
		return "Aluno [curso=" + curso + ", notas=" + Arrays.toString(notas) + "]";
	}
	
	
	
	/*public String toString() {
		String s = curso + "\n";
		for(double nota : notas) {
		s += nota + " ";
		}
		return s;
	}*/
	
	
			
}
