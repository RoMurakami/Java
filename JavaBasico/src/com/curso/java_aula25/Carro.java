package com.curso.java_aula25;

public class Carro {
	String marca;
	String modelo;
	int numPassageiro;
	double capCombustivel;
	double consCombustivel;
	
	// declara��o de metodo � o tipo de retorno
	
	void exibirAutonomia() {
		
		System.out.println("A autonomia do carro �:" + capCombustivel * consCombustivel + "Km");
	}

}
