package com.curso.java_aula48;

public class MUltiposCatchAteJva7 {

	public static void main(String[] args) {

		int[] numero = {4, 8, 16, 32, 64, 128};
		int[] denon = {2, 0, 4, 8, 0};

		for(int i=0; i<numero.length; i++) {
			try {
				System.out.println(numero[i] + "/" + denon[i] + " = " +(numero[i])/denon[i]);				
			}
			catch(ArithmeticException e) {
				System.out.println("Erro ao dividirpor zero");
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Posi��o do Array invalida");
			}
		}

	}
}
