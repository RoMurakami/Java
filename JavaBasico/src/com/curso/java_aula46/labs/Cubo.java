package com.curso.java_aula46.labs;

public class Cubo extends Figura3D {
	
	private int lado;
	

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	@Override
	public double calcularArea() {
		return 6 * (lado * lado * lado);
	}

	@Override
	public double calcularVolume() {
		return lado * lado * lado;
		//return volume do cubo
	}

}
