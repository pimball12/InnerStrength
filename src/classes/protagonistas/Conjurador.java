package classes.protagonistas;

import utils.Chance;
import classes.basicas.Personagem;
import classes.basicas.Protagonista;

public class Conjurador extends Protagonista{

	public Conjurador()	{
		Classe = "Conjurador";
	}
	
	public void DefinicaoInicial2()	{
		DanoMagia += 4;
		DanoNormal -= 4;
		ResistenciaNormal -= 4;
		ResistenciaMagia += 4;
		Energia += 25;
		EnergiaAtual = Energia;
	}
	
	public void BolaDeFogo(Personagem inimigo)	{
		double ataque = DanoMagia - inimigo.getResistenciaMagia();
		if (Chance.ConsegueAcertar(Precisao))	{
			if (!Chance.ConsegueEsquivar(inimigo.getEsquiva()))	{
				inimigo.setVidaAtual(inimigo.getVidaAtual()-ataque);
			}
		}
		EnergiaAtual -= 20;
	}
	
	public void AtaqueMagico(Personagem inimigo, double ataque)	{
		if (Chance.ConsegueAcertar(Precisao))	{
			if (!Chance.ConsegueEsquivar(inimigo.getEsquiva()))	{
				inimigo.setVidaAtual(inimigo.getVidaAtual()-ataque);
			}
		}
	}
	
	public void Armageddon(Personagem protagonista, Personagem antagonista)	{
		double ataque1 = DanoMagia*1.8 - protagonista.getResistenciaMagia();
		double ataque2 = DanoMagia*1.8 - antagonista.getResistenciaMagia();
		AtaqueMagico(protagonista, ataque1);
		AtaqueMagico(antagonista, ataque2);
		EnergiaAtual -= 60;
	}
	
	public void Trovao(Personagem inimigo)	{
		double ataque = DanoMagia*1.5 - inimigo.getResistenciaMagia();
		AtaqueMagico(inimigo, ataque);
		EnergiaAtual -=40;
	}
	
}
