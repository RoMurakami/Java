package com.curso.java_aula52;

public class UsandoMinhaException {

	public static void main(String[] args) {

		int[] numero = {4, 8, 5, 16, 32, 21, 64, 128};
		int[] denon = {2, 0, 4, 8, 0, 2, 4};

		for(int i=0; i<numero.length; i++) {
			try {
				if (numero[i] % 2 != 0) {
					//lançar exception aqui
					throw new DivisaoNaoExata(numero[i], denon[i]);
				}
			System.out.println(numero[i] + "/" + denon[i] + " = " +(numero[i])/denon[i]);
			}

			catch(ArithmeticException | ArrayIndexOutOfBoundsException | DivisaoNaoExata e) {
				System.out.println("Aconteceu um erro!");
			}
			catch(Exception e) {
				System.out.println("Aconteceu um erro!");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}

}
