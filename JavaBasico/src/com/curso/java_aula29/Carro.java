package com.curso.java_aula29;

public class Carro {
	
	String marca;
	String modelo;
	int numPassageiro;
	double capCombustivel;
	double consCombustivel;
		// declaração da classe
	
	Carro() {
		System.out.println("Classe Carro foi instaciada");
		numPassageiro = 4;	
	}
	
	Carro(String marca_, String modelo_, int numPassageiro_, double capCombustivel_, double consCombustivel_){
		marca= marca_;
		modelo = modelo_;
		numPassageiro = numPassageiro_;
		capCombustivel = capCombustivel_;
		consCombustivel = consCombustivel_;	
		
	}	
	void exibirAutonomia() {
		
		System.out.println("A autonomia do carro é:" + capCombustivel * consCombustivel + "Km");
	}
	
	double obterAutonomia() {
		
		System.out.println("Metodo oberAutonomia foi chamado");
		return capCombustivel * consCombustivel;
	}
	
	double calcularCombustivel(double km) {
		
		double qtdCombustivel = km/consCombustivel;
		return qtdCombustivel;
	}

}
