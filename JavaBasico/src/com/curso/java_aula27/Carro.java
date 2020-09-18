package com.curso.java_aula27;

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
	// utiliza o tipo de dado que será mostrado na tela
	// declaração de metodo double necessário palavra return para concluir 
	// o metodo
	
	double obterAutonomia() {
		
		System.out.println("Metodo oberAutonomia foi chamado");
		return capCombustivel * consCombustivel;
	}
	
	double calcularCombustivel(double km) {
		
		double qtdCombustivel = km/consCombustivel;
		return qtdCombustivel;
	}
}
