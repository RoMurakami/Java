package com.curso.java_aula34;

public class TesteCalculadora {
	
	static int resultaSoma;

	public static void main(String[] args) {
		
		resultaSoma = MinhaCalculadora.soma(1,2);
			
		// MinhaCalculadora calculadora = new MinhaCalculadora();
		
		  //	calculadora.soma(1, 2);
		
		soma2Valores(1,2);
	}
	
	static int soma2Valores(int num1, int num2) {
		return MinhaCalculadora.soma(num1, num2);
		
	}

}
