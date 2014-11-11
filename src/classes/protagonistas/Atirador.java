package classes.protagonistas;

import classes.basicas.Protagonista;

public class Atirador extends Protagonista{
	
	public Atirador()	{
		Classe = "Atirador";
	}
	
	public void DefinicaoInicial2()	{
		Esquiva+=0.1;
		Precisao+=0.1;
		Energia+=10;
		DanoNormal+=2;
		EnergiaAtual = Energia;
	}
}
