package com.curso.java_aula15_llab;

import java.util.Scanner;

public class lab_15_7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Digite primeiro numero:");
		int nNum1 = scan.nextInt();
		
		System.out.println("Digite segundo numero:");
		int nNum2 = scan.nextInt();
		
		System.out.println("Digite terceiro numero:");
		int nNum3 = scan.nextInt();
		
		if (nNum1 >= nNum2 && nNum1 >= nNum3) {
			System.out.println("Maior numero nNum1: " + nNum1);
		} else if (nNum2 >= nNum1 && nNum2 >= nNum3) {
			System.out.println("Maior numero nNum2: " + nNum2);
		} else if (nNum3 >= nNum1 && nNum3 >= nNum2) {
			System.out.println("Maior numero nNum3: " + nNum3);
	}
		if (nNum1 <= nNum2 && nNum1 <= nNum3) {
			System.out.println("Menor numero nNum1: " + nNum1);
		} else if (nNum2 <= nNum1 && nNum2 <= nNum3) {
			System.out.println("Menor numero nNum2: " + nNum2);
		} else if (nNum3 <= nNum1 && nNum3 <= nNum2) {
			System.out.println("Menor numero nNum3: " + nNum3);
	}

	}

}
