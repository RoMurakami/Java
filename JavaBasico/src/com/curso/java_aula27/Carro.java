package com.curso.java_aula27;

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
	// utiliza o tipo de dado que ser� mostrado na tela
	// declara��o de metodo double necess�rio palavra return para concluir 
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
