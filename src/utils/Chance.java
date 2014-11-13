package utils;

import java.util.Random;

public class Chance {

	static Random random = new Random();
	
	public static boolean ConsegueEsquivar(float esquiva)	{
		float minimo = 0.01f;
		float maximo = 1f;
		float resultado = random.nextFloat() * (maximo - minimo) + minimo; 
		return esquiva > resultado ? true : false;
	}
	
	public static boolean ConsegueAcertar(float precisao)	{
		float minimo = 0.01f;
		float maximo = 1f;
		float resultado = random.nextFloat() * (maximo - minimo) + minimo; 
		return precisao < resultado ? false : true;
	}
	
	public static boolean UmEm(int numero)	{
		int resultado = random.nextInt(numero+1);
		return numero == resultado ? true : false;
	}
	
	public static boolean BoleanoAleatorio()	{
		boolean resultado = random.nextBoolean();
		return resultado;
	}

}
