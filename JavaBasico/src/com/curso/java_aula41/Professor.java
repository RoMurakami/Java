package com.curso.java_aula41;

public class Professor extends Pessoa {
	
	
	private double salario;
	private String nomeCurso;
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public double calcularSalarioLiquido() {
		return 0;
	}
	public String obterEnderecoEtiqueta(){
			
			String s = "Endere�o do Professor: ";
			s += super.getEndereco();
			return s;
		}
	@Override
	public String obterEtiquetaEndereco() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void imprimirEtiquetaEndereco() {
		System.out.println("Imprimindo Etiqueta do Professor");
		System.out.println(this.obterEnderecoEtiqueta());
	}
	
}
