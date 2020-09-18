package com.curso.java_aula48;

public class MultiplosCatch {

	public static void main(String[] args) {

		int[] numero = {4, 8, 16, 32, 64, 128};
		int[] denon = {2, 0, 4, 8, 0};

		for(int i=0; i<numero.length; i++) {
			try {
				System.out.println(numero[i] + "/" + denon[i] + " = " +(numero[i])/denon[i]);				
			}
			catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Aconteceu um erro");
			}
		}

	}
}
