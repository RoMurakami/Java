package com.curso.java_aula45;

public class Teste {
	
	/*Aluno aluno = new Aluno();
	Pessoa pessoaAluno = aluno; // chamado de upcasting
	
	Pessoa aluno2 = (Pessoa) new Aluno(); //mais comum*/
	
	
	Pessoa pessoa = new Pessoa();
	Aluno aluno = new Aluno();
	Professor prof = new Professor();
	
	if (pessoa instanceof Pessoa){
		System.out.println("é do tipo Pessoa");
	}
	if (aluno instanceof Aluno){
		System.out.println("é do tipo Aluno");
	}
	if (prof instanceof Professor){
		System.out.println("é do tipo Professor");
	
	

}
