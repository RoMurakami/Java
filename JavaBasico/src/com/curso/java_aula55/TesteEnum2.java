package com.curso.java_aula55;

import com.curso.java_aula53.DiaSemana;

public class TesteEnum2 {

	public static void main(String[] args) {
		
		System.out.println(Enum.valueOf(DiaSemana.class, "SEGUNDA"));
		
		DiaSemana dia = Enum.valueOf(DiaSemana.class, "SEGUNDA");
		System.out.println(dia);
		

	}

}
