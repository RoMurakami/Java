package com.curso.java_aula15_llab;

import java.util.Scanner;

public class lab_15_2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Digite um numero:");
		
		int nNumero = scan.nextInt();
		
		if (nNumero >= 0) {
			System.out.println("Numero é positivo");
		} else {
			System.out.println("Numero é negativo");
		}
		

	}

}
