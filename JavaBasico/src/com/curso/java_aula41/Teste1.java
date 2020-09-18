package com.curso.java_aula41;

import com.curso.java_aula40.Aluno;
import com.curso.java_aula40.Pessoa;
import com.curso.java_aula40.Professor;

public class Teste1 {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		Pessoa aluno = new Aluno();
		Pessoa professor = new Professor();
		
		pessoa.setEndereco("Rua Hum, 2");
		aluno.setEndereco("Rua Dois, 45");
		professor.setEndereco("Rua Quatro, 25");
		
		//System.out.println(pessoa.obterEqiquetaEndereco());
		//System.out.println(aluno.obterEqiquetaEndereco());
		//System.out.println(professor.obterEqiquetaEndereco());
		
		//aluno.imprimirEtiquetaEndereco();
		professor.obterEqiquetaEndereco();

	}

}
