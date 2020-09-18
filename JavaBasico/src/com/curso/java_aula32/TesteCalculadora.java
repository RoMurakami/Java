package com.curso.java_aula32;

public class TesteCalculadora {

	public static void main(String[] args) {
		
		MinhaCalculadora calculadora = new MinhaCalculadora();
		int soma1 = calculadora.soma(1, 2);
		System.out.println(soma1);
		
		int soma2 = calculadora.soma(1,2,3);
		
		System.out.println(soma2);
		

	}

}
