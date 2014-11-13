package classes.protagonistas;

import classes.basicas.Personagem;
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
	
	//Magias
	
	public void ChuvaDeGranadas(Personagem protagonista, Personagem antagonista)	{
		AtaqueModificado(antagonista);
		AtaqueModificado(protagonista);
		EnergiaAtual -= 45;
	}
	
	public void TiroCerteiro(Personagem inimigo)	{
		double ataque = DanoNormal + Precisao*10 - inimigo.getResistenciaNormal()/2;
		AtaqueModificado(inimigo, ataque);
		EnergiaAtual -= 40;
	}
	
	public void BalaConjurada(Personagem inimigo)	{
		double ataque = DanoNormal + (DanoMagia*Precisao)/2 - inimigo.getResistenciaNormal()/2;
		AtaqueModificado(inimigo, ataque);
		EnergiaAtual -= 30;
	}
	
}
