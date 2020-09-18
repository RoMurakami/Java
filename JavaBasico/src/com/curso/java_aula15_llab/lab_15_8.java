package com.curso.java_aula15_llab;

import java.util.Scanner;

public class lab_15_8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Digite primeiro preço:");
		double preco1 = scan.nextDouble();
		
		System.out.println("Digite segundo preço:");
		double preco2 = scan.nextDouble();
		
		System.out.println("Digite terceiro preço:");
		double preco3 = scan.nextDouble();
		
		if (preco1 <= preco2 && preco1 <= preco3) {
			System.out.println("Compre produto 1:");
		} else if (preco2 <= preco2 && preco2 <= preco3) {
			System.out.println("Compre produto 2:");
		}else if (preco3 <= preco2 && preco3 <= preco2) {
			System.out.println("Compre produto 3:");
		}

}
}
