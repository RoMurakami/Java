package com.curso.java_aula18;

import java.util.Scanner;

public class BreakContinue {

	public static void main(String[] args) {
		/* Scanner scan = new Scanner(System.in);
		
		System.out.println("Entre com um numero: ");
		int num = scan.nextInt();
		
		System.out.println("Digite limite: ");
		int max = scan.nextInt();
		
		for (int i=num; i <= max; i++) {
			System.out.println(i);
		if (i % 7 == 0) {
			System.out.println("Valor de i é: " +i);
			break;
		}
		} */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entre com um numero: ");
		int num = scan.nextInt();
		
		System.out.println("Digite limite: ");
		int max = scan.nextInt();
		
		for (int i=num; i <= max; i++) {
			System.out.println(i);
		if (i % 7 == 0) {
			continue;
		}
		System.out.println("Valo de i é: " + i);
	}
}

}
