package classes.protagonistas;

import classes.basicas.Protagonista;

public class Conjurador extends Protagonista{

	public Conjurador()	{
		Classe = "Conjurador";
	}
	
	public void DefinicaoInicial2()	{
		DanoMagia += 4;
		ResistenciaNormal -= 3;
		ResistenciaMagia += 4;
	}
}
