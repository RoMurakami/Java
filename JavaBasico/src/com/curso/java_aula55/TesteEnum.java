package com.curso.java_aula55;

import com.curso.java_aula54.DiaSemana;

public class TesteEnum {

	public static void main(String[] args) {
		DiaSemana[] dias = DiaSemana.values();
		
		for (int i=0; i<dias.length; i++) {
			System.out.println(dias[i]);		
		}
		
		for (DiaSemana data: DiaSemana.values()){
				System.out.println(data);
		}
	}

}
