package utils;

import classes.antagonistas.Demonio;
import classes.antagonistas.MortoVivo;
import classes.antagonistas.Wookie;
import classes.basicas.Personagem;
import classes.protagonistas.Atirador;
import classes.protagonistas.Conjurador;
import classes.protagonistas.Guerreiro;

public class PersonagemUtils {

	public PersonagemUtils() {

	}
	
	public static Personagem EscolheClasse(String classe)	{
		Personagem personagem = null;
		switch(classe)	{
			case "Guerreiro":
				personagem = new Guerreiro();
				break;
			case "Atirador":
				personagem = new Atirador();
				break;
			case "Conjurador":
				personagem = new Conjurador();
				break;
			case "Demonio":
				personagem = new Demonio();
				break;
			case "MortoVivo":
				personagem = new MortoVivo();
				break;
			case "Wookie":
				personagem = new Wookie();
				break;
		}
		return personagem;
	}
	
}
