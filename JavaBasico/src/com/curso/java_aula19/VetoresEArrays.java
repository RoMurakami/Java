package com.curso.java_aula19;

public class VetoresEArrays {

	public static void main(String[] args) {
		// vetor lista ordenada
		
		double [] temperatura = new double [365];
		temperatura [0] = 31.7;
		temperatura [1] = 32;
		temperatura [2] = 33.5;
		temperatura [3] = 33;
		temperatura [4] = 32.1;
		temperatura [5] = 34;
		
		System.out.println("A temperatura do dia 4 é: " + temperatura[3]);
		System.out.println("A temperatura do dia 4 é: " + temperatura.length);
		System.out.println("Valores do Array: ");
		
		for (int i = 0; i<temperatura.length; i++) {
			System.out.println("A temperatura do dia " + (i+1) +" é: " + temperatura[i]);
		}
		
		for (double temp : temperatura) {
			System.out.println(temp);
			
		}
		
	}

}
