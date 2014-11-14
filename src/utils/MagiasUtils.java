package utils;

import interfaces.funcionamento.Rodada;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import classes.basicas.Personagem;

public class MagiasUtils {
	
	
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public static List<String> retornaMagias()	{
		Personagem personagem = Rodada.SelecionaPersonagem("atual", true);
		List<String> listaDeMagias;
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
		return listaDeMagias;
	}
	
	public static void executaMagias(String magia, Personagem personagem, Personagem parceiro, Personagem inimigo, Personagem parceiroinimigo)	{
		switch (magia) {
		case "Descontrole":
			personagem.Descontrole(inimigo);
			break;
		case "Ataque Brutal":
			personagem.AtaqueBrutal(inimigo);
			break;
		case "Violencia":
			personagem.Violencia(inimigo);
			break;
		case "Bola de Fogo":
			personagem.BolaDeFogo(inimigo);
			break;
		case "Armageddon":
			personagem.Armageddon(inimigo,parceiroinimigo);
			break;
		case "Trovao":
			personagem.Trovao(inimigo);
			break;
		case "Chuva de Granadas":
			personagem.ChuvaDeGranadas(inimigo,parceiroinimigo);
			break;
		case "Tiro Certeiro":
			personagem.TiroCerteiro(inimigo);
			break;
		case "Bala Conjurada":
			personagem.BalaConjurada(inimigo);
			break;
		case "Garras Amaldiçoadas":
			personagem.GarrasAmaldicoadas(inimigo);
			break;
		case "Drenar Forças":
			personagem.DrenarForcas(inimigo,parceiro);
			break;
		case "Canibalismo":
			personagem.Canibalismo(inimigo);
			break;
		case "Ebola":
			personagem.Ebola(inimigo);
			break;
		case "Tiro ao Alto":
			personagem.TiroProAlto(inimigo,parceiroinimigo);
			break;
		case "Rugido de Guerra":
			personagem.RugidoDeGuerra(parceiro);
			break;
		case "Curar":
			personagem.CuraPersonagem(parceiro);
			break;
		default:
			break;
		}
	}
	
	public static boolean podeExecutar(String magia, Personagem personagem)	{
		switch (magia) {
		case "Descontrole":
			if (personagem.getEnergiaAtual() > 50) { return true; } else { return false; }
		case "Ataque Brutal":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		case "Violencia":
			if (personagem.getEnergiaAtual() > 30) { return true; } else { return false; }
		case "Bola de Fogo":
			if (personagem.getEnergiaAtual() > 20) { return true; } else { return false; }
		case "Armageddon":
			if (personagem.getEnergiaAtual() > 50) { return true; } else { return false; }
		case "Trovao":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		case "Chuva de Granadas":
			if (personagem.getEnergiaAtual() > 45) { return true; } else { return false; }
		case "Tiro Certeiro":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		case "Bala Conjurada":
			if (personagem.getEnergiaAtual() > 30) { return true; } else { return false; }
		case "Garras Amaldiçoadas":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		case "Drenar Forças":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		case "Canibalismo":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		case "Ebola":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		case "Tiro ao Alto":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		case "Rugido de Guerra":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		case "Curar":
			if (personagem.getEnergiaAtual() > 40) { return true; } else { return false; }
		default:
			break;
		}
		return false;
	}
	
	
	
}
