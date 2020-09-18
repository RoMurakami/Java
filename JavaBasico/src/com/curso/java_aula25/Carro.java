package com.curso.java_aula25;

public class Carro {
	String marca;
	String modelo;
	int numPassageiro;
	double capCombustivel;
	double consCombustivel;
	
	// declaração de metodo é o tipo de retorno
	
	void exibirAutonomia() {
		
		System.out.println("A autonomia do carro é:" + capCombustivel * consCombustivel + "Km");
	}

}
