package com.curso.java_aula46.labs;

public class Circulo extends Figura2D {
	
	private double raio;
	
	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}



	@Override
	public double calcularArea() {
		return (raio * raio) * Math.PI ;
	}

}
