package classes.antagonistas;

import utils.Chance;
import classes.basicas.Antagonista;
import classes.basicas.Personagem;

public class Wookie extends Antagonista {
	
	public Wookie()	{
		Classe = "Wookie";
	}
	
	public void DefinicaoInicial2()	{
		Precisao += 0.05;
	}
	
	public void TiroProAlto(Personagem protagonista, Personagem antagonista)	{
		boolean chance = Chance.BoleanoAleatorio();
		double ataque;
		if (chance == true)	{
			ataque = DanoNormal*1.5 - protagonista.getResistenciaNormal();
			AtaqueModificado(protagonista, ataque);
		} else {
			ataque = DanoNormal*1.5 - antagonista.getResistenciaNormal();
			AtaqueModificado(antagonista, ataque);
		}
		EnergiaAtual -= 40;
	}
	
	public void RugidoDeGuerra(Personagem parceiro)	{
		if (Chance.UmEm(3) == true)	{
			if (EnergiaAtual < Energia)	{
				EnergiaAtual += EnergiaAtual/3;
				if (EnergiaAtual > Energia)	{
					EnergiaAtual = Energia;
				}
			}
			if (parceiro.getEnergiaAtual() < parceiro.getEnergia())	{
				parceiro.setEnergiaAtual(parceiro.getEnergiaAtual()+parceiro.getEnergiaAtual()/3);
				if (parceiro.getEnergiaAtual() > parceiro.getEnergia())	{
					parceiro.setEnergiaAtual(Energia);
					
				}
			}
		} else {
			EnergiaAtual -= 40;
		}
	}
	
}
