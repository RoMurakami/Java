package com.curso.java_aula50;

public class ExceptionGeneric {

	public static void main(String[] args) {

		int[] numero = {4, 8, 16, 32, 64, 128};
		int[] denon = {2, 0, 4, 8, 0};

		for(int i=0; i<numero.length; i++) {
			try {
				System.out.println(numero[i] + "/" + denon[i] + " = " +(numero[i])/denon[i]);				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			

		}
	}
}
