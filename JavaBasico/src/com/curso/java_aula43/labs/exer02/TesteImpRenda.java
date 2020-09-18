package com.curso.java_aula43.labs.exer02;

import java.util.Scanner;

public class TesteImpRenda {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Contribuinte contrib = new Contribuinte();
		Juridico juridico = new Juridico();
		Fisico fisico = new Fisico();
		Tipo tip = new Tipo();
		
		System.out.println("Digite J - PJuridica e F - PFisica: ");
		String input = scan.next();
		contrib.setNome("Maria");
		contrib.setEdereco("Rua Dois, 272");
		contrib.setTelefone("11-999999999");
		
		//Testa tipo de contribuinte
		if(input.equalsIgnoreCase("f")) {
			System.out.println("Pessoa Fisica: ");
			
		}else if(input.equalsIgnoreCase("j")) {
			System.out.println("Pessoa Juridica: ");
		}else 
			System.out.println("Não identificado!");
		
		
		System.out.println("Nome: " + contrib.getNome());
		System.out.println("Endereço: " + contrib.getEdereco());
		System.out.println("Telefone: " + contrib.getTelefone());
		
	}
	

	
	
}
