package com.curso.java_aula27.labs;

public class Exer01 {

	public static void main(String[] args) {
		
		Lampada lampada = new Lampada();
		
		lampada.ligar();
		System.out.println("A lampada esta " + lampada.ligada);
		
		lampada.desligar();
		System.out.println("A lampada esta " + lampada.ligada);
			

	}

}
