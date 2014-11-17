package utils;

import interfaces.funcionamento.Rodada;

import java.util.ArrayList;
import java.util.List;

import classes.basicas.Personagem;

public class ComputadorUtils {
	@SuppressWarnings("serial")
	public static String selecionaMagia()	{
		Personagem personagem = Rodada.SelecionaPersonagem("atual", true);
		List<String> listaDeMagias;
		if (personagem != null)	{
			switch (personagem.getClasse()) {
			case "Guerreiro":
				listaDeMagias = new ArrayList<String>(){{add("Descontrole");add("Ataque Brutal");add("Violencia");add("Curar");}};
				break;
			case "Conjurador":
				listaDeMagias = new ArrayList<String>(){{add("Bola de Fogo");add("Armageddon");add("Trovao");add("Curar");}};
				break;
			case "Atirador":
				listaDeMagias = new ArrayList<String>(){{add("Chuva de Granadas");add("Tiro Certeiro");add("Bala Conjurada");add("Curar");}};
				break;
			case "Demonio":
				listaDeMagias = new ArrayList<String>(){{add("Garras Amaldiçoadas");add("Drenar Forças");}};
				break;
			case "MortoVivo":
				listaDeMagias = new ArrayList<String>(){{add("Canibalismo");add("Ebola");}};
				break;
			case "Wookie":
				listaDeMagias = new ArrayList<String>(){{add("Tiro ao Alto");add("Grito de Guerra");}};
				break;
			default:
				listaDeMagias =new ArrayList<String>(){{add("Vazio");}};
				break;
			}
			int aleatorio = Chance.numeroAleatorio(listaDeMagias.size());
			return listaDeMagias.get(aleatorio);
		} else {
			return "";
		}
	}
}
