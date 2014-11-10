package utils;

import classes.basicas.Personagem;

public class Rodada {
	private static Personagem Protagonista1;
	private static Personagem Antagonista1;
	private static Personagem Protagonista2;
	private static Personagem Antagonista2;
	
	public static Personagem getProtagonista1() {
		return Protagonista1;
	}
	public static void setProtagonista1(Personagem protagonista1) {
		Protagonista1 = protagonista1;
	}
	public static Personagem getAntagonista1() {
		return Antagonista1;
	}
	public static void setAntagonista1(Personagem antagonista1) {
		Antagonista1 = antagonista1;
	}
	public static Personagem getProtagonista2() {
		return Protagonista2;
	}
	public static void setProtagonista2(Personagem protagonista2) {
		Protagonista2 = protagonista2;
	}
	public static Personagem getAntagonista2() {
		return Antagonista2;
	}
	public static void setAntagonista2(Personagem antagonista2) {
		Antagonista2 = antagonista2;
	}
	
	public static String ShowRodada() {
		return "Rodada ["+Protagonista1+", "+Antagonista1+", "+Protagonista2+", "+Antagonista2+"]";
	}
	
	
}
