package com.curso.java_aula15_llab;

import java.util.Scanner;

public class lab_aula15 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite uma data");
				
		int nData = scan.nextInt();
		System.out.println("Digite outra data");
		int nData2 = scan.nextInt();
		
		if (nData > nData2) {
			System.out.print(nData);
		} else {
			System.out.println(nData2);
		}

	}

}
