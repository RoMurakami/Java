package com.curso.java_aula56;

import javax.print.Doc;

public class Teste {

	public static void main(String[] args) {

		for (TipoDocumento doc : TipoDocumento.values()) {

			System.out.println(doc + " - " + doc.geraNumeroDocumento());
		}

	}
}	
