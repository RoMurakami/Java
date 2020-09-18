package com.curso.java_aula15_llab;

import java.util.Scanner;

public class lab_15_9 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Digite primeiro numero:");
		int nNum1 = scan.nextInt();
		
		System.out.println("Digite segundo numero:");
		int nNum2 = scan.nextInt();
		
		System.out.println("Digite terceiro numero:");
		int nNum3 = scan.nextInt();
		
		if (nNum1 <= nNum2 && nNum1 <= nNum3 && nNum2 <= nNum3) {
				// num1 é menor
				// num3 é maior
				// num1 < num2 < num3
			System.out.println(nNum3 + " - " + nNum2 + " - " + nNum1);
			
		} else if (nNum1 <= nNum2 && nNum1 <= nNum3 && nNum3 <= nNum2) {
			// num1 é menor
			// num3 é maior
			// num1 < num3 < num2			
		System.out.println(nNum2 + " - " + nNum3 + " - " + nNum1);
		
		} else if (nNum1 <= nNum2 && nNum1 <= nNum3 && nNum3 <= nNum2) {
			// num2 é menor
			// num3 é maior
			// num2 < num1 < num3
		System.out.println(nNum3 + " - " + nNum2 + " - " + nNum1);
		
		} else if (nNum2 <= nNum1 && nNum2 <= nNum3 && nNum1 <= nNum3) {
			// num2 é menor
			// num3 é maior
			// num2 < num1 < num3
		System.out.println(nNum3 + " - " + nNum1 + " - " + nNum2);
		} else if (nNum2 <= nNum1 && nNum2 <= nNum3 && nNum3 <= nNum1) {
			// num2 é menor
			// num1 é maior
			// num2 < num3 < num2
		System.out.println(nNum2 + " - " + nNum3 + " - " + nNum2);
		} else if (nNum3 <= nNum1 && nNum3 <= nNum2 && nNum1 <= nNum2) {
			// num3 é menor
			// num2 é maior
			// num3 < num1 < num2
		System.out.println(nNum2 + " - " + nNum1 + " - " + nNum3);
		} else if (nNum3 <= nNum1 && nNum3 <= nNum2 && nNum2 <= nNum1) {
			// num3 é menor
			// num1 é maior
			// num3 < num2 < num1
		System.out.println(nNum1 + " - " + nNum2 + " - " + nNum3);
		}
}
}
