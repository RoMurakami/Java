package com.curso.java_aula56.labs;

public class Calculadora {

	enum Operacao{

		SOMAR("+") {
			@Override
			public double executarOperacao(double n1, double n2) {
				return n1 + n2;
			}
		}, SUBTRAIR("-") {
			@Override
			public double executarOperacao(double n1, double n2) {
				return n1 - n2;
			}
		}, MULTIPLICAR("*") {
			@Override
			public double executarOperacao(double n1, double n2) {
				return n1 * n2;
			}
		}, DIVIDIR("/") {
			@Override
			public double executarOperacao(double n1, double n2) {
				return n1 / n2;
			}
		};

		private String simbolo;
		
		Operacao(String simbolo){
			this.simbolo = simbolo;
		}
		
		public abstract double executarOperacao(double n1, double n2);
		
		public String toString() {
			return this.simbolo;
			
		}
		
	}
	public static void main(String[] args) {
		
		double n1 = 2.0;
		double n2 = 3.0;
		
		for(Operacao op : Operacao.values()) {
			System.out.print(n1 + " ");
			System.out.print(op.toString() + " ");
			System.out.print(n2 + " = ");
			System.out.println(op.executarOperacao(n1, n2));
		}

	}

}
