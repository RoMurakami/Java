package com.curso.java_aula46.labs;

public class Triangulo extends Figura2D{
	
	private int altura;
	private int base;
	
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}

	@Override
	public double calcularArea() {
		return ((base * altura)/2);
	}
	

}
