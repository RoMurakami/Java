package com.curso.java_aula30;

public class Carro {
	
	String marca;
	String modelo;
	int numPassageiro;
	double capCombustivel;
	double consCombustivel;
		// declaração da classe
	
	
	public Carro(String marca, String modelo, int numPassageiro, double capCombustivel, double consCombustivel) {
			
			this.marca = marca;
			this.modelo = modelo;
			this.numPassageiro = numPassageiro;
			this.capCombustivel = capCombustivel;
			this.consCombustivel = consCombustivel;
		}
	
	public Carro() {}
	
	
	

	
	public Carro(String marca, String modelo, int numPassageiro) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.numPassageiro = numPassageiro;
		
		System.out.println("Chamada do construtor com 2 parametros");
	}
	
	public Carro(String marca, String modelo) {
		this(marca, modelo, 10);		
		
		System.out.println("Chamada do construtor com 3 parametros");
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
