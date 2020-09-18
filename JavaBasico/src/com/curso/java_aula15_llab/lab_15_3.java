package com.curso.java_aula15_llab;

import java.util.Scanner;

public class lab_15_3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Digite uma letra F ou M:");
		
		String input = scan.next();
		
		if (input.equalsIgnoreCase("f")) {
			System.out.println("F - Feminino");
		} else if (input.equalsIgnoreCase("M")){
			System.out.println("M - Masculino");		
		} else {
			System.out.println("Sexo Invalido");
		}
			
		
		

	}

}
