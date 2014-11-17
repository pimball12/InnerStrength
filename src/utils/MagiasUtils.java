package utils;

import interfaces.funcionamento.Rodada;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

import classes.basicas.Personagem;

public class MagiasUtils {
	
	
	@SuppressWarnings({ "serial" })
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
			listaDeMagias = new ArrayList<String>(){{add("Garras Amaldi�oadas");add("Drenar For�as");}};
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
		case "Garras Amaldi�oadas":
			personagem.GarrasAmaldicoadas(inimigo);
			break;
		case "Drenar For�as":
			if (Rodada.getComputador() == false)	{
				personagem.DrenarForcas(inimigo,parceiro);
			} else {
				personagem.DrenarForcasAleatorio(inimigo, parceiro);
			}
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
		case "Grito de Guerra":
			personagem.RugidoDeGuerra(parceiro);
			break;
		case "Curar":
			if (Rodada.getComputador() == false)	{
				personagem.CuraPersonagem(parceiro);
			} else {
				personagem.CuraPersonagemAleatorio(parceiro);
			}
			break;
		default:
			break;
		}
	}
	
	public static boolean podeExecutar(String magia, Personagem personagem)	{
		switch (magia) {
		case "Descontrole":
			if (personagem.getEnergiaAtual() >= 50) { return true; } else { return false; }
		case "Ataque Brutal":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		case "Violencia":
			if (personagem.getEnergiaAtual() >= 30) { return true; } else { return false; }
		case "Bola de Fogo":
			if (personagem.getEnergiaAtual() >= 20) { return true; } else { return false; }
		case "Armageddon":
			if (personagem.getEnergiaAtual() >= 50) { return true; } else { return false; }
		case "Trovao":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		case "Chuva de Granadas":
			if (personagem.getEnergiaAtual() >= 45) { return true; } else { return false; }
		case "Tiro Certeiro":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		case "Bala Conjurada":
			if (personagem.getEnergiaAtual() >= 30) { return true; } else { return false; }
		case "Garras Amaldi�oadas":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		case "Drenar For�as":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		case "Canibalismo":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		case "Ebola":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		case "Tiro ao Alto":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		case "Grito de Guerra":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		case "Curar":
			if (personagem.getEnergiaAtual() >= 40) { return true; } else { return false; }
		default:
			break;
		}
		return false;
	}
	
	public static void preencheTexto(String magia, JTextPane painelTexto)	{
		String texto;
		if (magia == null)	{
			painelTexto.setText("");
		} else {
			switch (magia) {
			case "Descontrole":
				texto = "O guerreiro come�a a dar uma sequencia de golpes fortes no inimigo at� errar, � um golpe de sorte pois"
						+ " pode tanto matar o advers�rio em uma rodada como n�o tirar dano nenhum. \r\n"
						+ "Gasta: 50 de energia.";
				break;
			case "Ataque Brutal":
				texto = "D� um golpe estocado no inimigo, causando bastante dano e reduzindo a defesa do inimigo. \r\n"
						+ "Gasta: 40 de energia.";
				break;
			case "Violencia":
				texto = "Um golpe descontrolado aflingindo dano no inimigo, por�m, o guerreiro tamb�m perde um pouco de vida. \r\n"
						+ "Gasta: 30 de energia.";
				break;
			case "Bola de Fogo":
				texto = "Ataque b�sico de conjurador que aflinge dano no inimigo de acordo com o Dano M�gico do atacante. \r\n"
						+ "Gasta: 20 de Energia.";
				break;
			case "Armageddon":
				texto = "O conjurador invoca uma chuva de mete�ros que atinge a todos os personagens do outro time. \r\n"
						+ "Gasta: 60 de energia.";
				break;
			case "Trovao":
				texto = "Lan�a uma descarga el�trica sobre o inimigo selecionado. \r\n"
						+ "Gasta: 40 de energia.";
				break;
			case "Chuva de Granadas":
				texto = "O atirador bombardeia o campo inimigo inflingindo dano em todos do territ�rio. \r\n"
						+ "Gasta: 45 de energia.";
				break;
			case "Tiro Certeiro":
				texto = "Acerta um tiro nas zonas vitais do inimigo selecionado, inflingindo mais dano. \r\n"
						+ "Gasta: 40 de energia.";
				break;
			case "Bala Conjurada":
				texto = "Atira no oponente com balas m�gicas, tem seu dano influenciado pelo Dano M�gico do atirador. \r\n"
						+ "Gasta: 30 de energia.";
				break;
			case "Garras Amaldi�oadas":
				texto = "Difere um golpe fatal no oponente influenciado pelo Dano Normal e o Dano M�gico do demonio. \r\n"
						+ "Gasta: 40 de energia.";
				break;
			case "Drenar For�as":
				texto = "Tem a chance de 33% de chance de atacar o outro personagem e recuperar energia equivalente ao dano inferido."
						+ "A energia pode ser transferida ao pr�prio dem�nio ou ao seu parceiro. \r\n"
						+ "Gasta: 40 de energia, caso falhe.";
				break;
			case "Canibalismo":
				texto = "O MortoVivo arranca um peda�o do inimigo selecionado e se alimenta dela, recuperando a pr�pria vida equivalente ao dano inferido. \r\n"
						+ "Gasta: 40 de energia.";
				break;
			case "Ebola":
				texto = "Tem 33% de chance de contaminar o inimigo selecionado e reduzir sua vida pela metade. \r\n"
						+ "Gasta: 40 de energia.";
				break;
			case "Tiro ao Alto":
				texto = "D� um tiro poderoso pro alto acertanto aleat�riamente um dos personagens inimigos. \r\n"
						+ "Gasta: 40 de energia.";
				break;
			case "Grito de Guerra":
				texto = "Tem 33% de chance de recuperar 1/3 da energia de seu parceiro. \r\n"
						+ "Gasta: 40 de energia se der errado.";
				break;
			case "Curar":
				texto = "Recupera 30% da vida de quem for escolhido. Voc� pode curar a s� mesmo ou ao seu parceiro. \r\n"
						+ "Gasta: 30 de energia.";
				break;
			default:
				texto = "";
				break;
			}
			painelTexto.setText(texto);
		}
	}
	
}
