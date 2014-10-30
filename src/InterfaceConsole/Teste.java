package InterfaceConsole;

import classes.antagonistas.Demonio;
import classes.antagonistas.MortoVivo;
import classes.antagonistas.Wookie;
import classes.basicas.Antagonista;
import classes.basicas.Personagem;

public class Teste {

	public static void main(String[] args) {
		
		Demonio ant = new Demonio();
		ant.CriarPersonagem(2.5, 2.5, 2.5, 2.5);
		System.out.println(ant);
		
	}
}
