//java 5 introduzido Wrappers
//ruby 100% OO

package com.curso.java_aula57;

public class TesteWrapper {

	public static void main(String[] args) {
		
		//tipos primitivos do java não é 100% oo
		short num1 = 1;
		byte num2 = 10;
		int num3 = 100;
		long num4 = 10000l;
		float num5 = 3.5f;
		double num6 = 3.5555;
		boolean flag = true;
		char a = 'a';
		
		
		//classes Wrapper
		Short num7 = new Short((short)1);
		Byte num8 = new Byte((byte)10);
		Integer num9 = new Integer(100);
		Long num10 = new Long(1000L); //pode ser instaciado como Long((Long)10000)
		Float num11 = new Float(3.5f);
		Double num12 = new Double(3.555);
		Boolean flag2 = new Boolean(true);
		Character b = new Character('b');
		
		Integer num13 = new Integer("10000");
		
		Double num14 = new Double("3.5");
		System.out.println(num13.intValue());
		
		Long num15 = num13.longValue();
		
		
		
		
		

	}

}
