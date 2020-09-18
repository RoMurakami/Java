package com.curso.java_aula60;

public class EscopoVariaveis {

	private int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int calculaValor(int valor) {
		valor = valor + 10;
		return valor;
	}

	public int teste(){
		int valor = 5;
		if (true) {
			valor--;
		}
		this.valor = valor;
		return valor;
	}
	public void outroTeste() {

		for (int i=0; i<10; i++) {
			System.out.println(i);
		}
	}

}
