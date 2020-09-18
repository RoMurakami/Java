package br.com.projetojsf;

import javax.persistence.Persistence;

public class TesteJpa {
	
	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("projeto-jsf");
		
		
	}

}
