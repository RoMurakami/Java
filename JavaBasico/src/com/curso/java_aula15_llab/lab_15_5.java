package com.curso.java_aula15_llab;

import java.util.Scanner;

public class lab_15_5 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Digite a primeira nota:");		
		double nNota1 = scan.nextDouble();
		
		System.out.println("Digite a segunda nota:");
		double nNota2 = scan.nextDouble();
		
		double nMedia = (nNota1 + nNota2) / 2;
		
		if (nMedia == 10) {
			System.out.println("Aprovado com Distinção!!");
		} else if (nMedia >= 7) {
			System.out.println("Aprovado!");
		} else {
			System.out.println("Reprovado!");
		}	
	}

}
