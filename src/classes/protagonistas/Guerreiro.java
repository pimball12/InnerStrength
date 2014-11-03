package classes.protagonistas;

import classes.basicas.Protagonista;

public class Guerreiro extends Protagonista {
	
	public void DefinicaoInicial2()	{
		Classe = "Guerreiro";
		DanoNormal += 4;
		DanoMagia += 4;
		ResistenciaNormal += 3;
		ResistenciaMagia -=4;
		Esquiva -= 0.02;
		Energia += 10;
	}
	
}
