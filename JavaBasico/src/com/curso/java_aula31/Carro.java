package com.curso.java_aula31;

public class Carro {
	
	String marca;
	String modelo;
	int numPassageiro;
	double capCombustivel;
	double consCombustivel;
	
void exibirAutonomia() {
		
		System.out.println("A autonomia do carro é:" + capCombustivel * consCombustivel + "Km");
	}
	
		double obterAutonomia() {
		
		System.out.println("Metodo oberAutonomia foi chamado");
		return capCombustivel * consCombustivel;
	}
	
		private double dividekmporconsCombustivel(double km) {
			return km/this.consCombustivel;
		}
		
		
	public double calcularCombustivel(double km) {	
		return this.dividekmporconsCombustivel(km);
	}


}
