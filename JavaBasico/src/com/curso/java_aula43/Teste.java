package com.curso.java_aula43;

public class Teste {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		
		aluno.setCurso("Cinecias da Computação");
		double notas[] = {10, 9, 8, 7};
		aluno.setNotas(notas);

		System.out.println(aluno);
	}

}
