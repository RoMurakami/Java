package com.curso.java_aula25;

import com.curso.java_aula25.Carro;

public class TesteCarro {

	public static void main(String[] args) {
		
		Carro van = new Carro();
		van.marca = "Fiat";
		van.modelo = "Ducato";
		van.numPassageiro = 10;
		van.capCombustivel = 100;
		van.consCombustivel = 0.2;
		
		
		System.out.println(van.marca);
		System.out.println(van.modelo);
		
		van.exibirAutonomia();

	}

}
