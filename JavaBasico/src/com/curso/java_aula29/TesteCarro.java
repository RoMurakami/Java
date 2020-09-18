package com.curso.java_aula29;

public class TesteCarro {

	public static void main(String[] args) {

		Carro van = new Carro();
		van.marca = "Fiat";
		van.modelo = "Ducato";
		//van.numPassageiro = 10;
		van.capCombustivel = 100;
		van.consCombustivel = 0.2;
		
		System.out.println(van.numPassageiro);

	}
	
		// Carro van2 = new Carro("Fiat");
		
		// System.out.println(van2.marca);
			
		
}
