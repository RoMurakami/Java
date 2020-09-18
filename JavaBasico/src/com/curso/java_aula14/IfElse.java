package com.curso.java_aula14;

import java.util.Scanner;


public class IfElse {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite sua idade:");
		
		int idade = scan.nextInt();
		
		if (idade >= 18) {
			System.out.println("É maior de idade");		
		} else {
			System.out.println("Não é maior de idade");
			}
		//barato <= 10
		//10 < valor < 15 pedir desconto
		//15 <= valor 17 - pesquisa mais
		//>= 17 muito caro
		
		System.out.println("entre com um valor");
		double valor = scan.nextDouble();
		
		if (valor <=10) {
			System.out.println("Esta barato, pode comprar!");
		} else if (valor > 10 && valor < 15) {
			System.out.println("pode pedir um desconto");
		} else if (valor >= 15 && valor < 17) {
			System.out.println("pesquisar mais!");
		} else {
			System.out.println("muito caro!");
		}
			
			
		}

}
