package com.curso.java_aula15_llab;

import java.util.Scanner;

public class lab_15_10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Digite qual periodo estuda: ");
		
		String turno = scan.next();
		
		switch (turno) {
		case "m":
		case "M": 
			System.out.println("Bom dia"); break;
		case "v":
		case "V":
			System.out.println("Boa tarde!"); break;
		case "n":
		case "N":
			System.out.println("Boa Noite!"); break;
		default: System.out.println("Valor invalido!");
		}
			

	}

}
