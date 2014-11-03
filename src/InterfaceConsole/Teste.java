package InterfaceConsole;

import classes.antagonistas.Demonio;
import classes.protagonistas.Guerreiro;


public class Teste {

	public static void main(String[] args) {
		
		Demonio ant = new Demonio();
		Guerreiro gue = new Guerreiro();
		ant.CriarPersonagem(2.5, 2.5, 2.5, 2.5);
		gue.CriarPersonagem(2.5, 2.5, 2.5, 2.5);
		System.out.println(ant);
		System.out.println(gue);
		ant.AtacaPersonagem(gue);
		System.out.println(gue);
		
		gue.Definicao(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, "2");
		System.out.println(gue);
		
	}
}
