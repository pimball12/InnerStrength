package interfaces.funcionamento;

import interfaces.gui.Principal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import utils.MagiasUtils;
import classes.basicas.Personagem;
import controladores.PersonagemControlador;

public class Rodada extends Principal	{
	private static Personagem Protagonista1;
	private static Personagem Antagonista1;
	private static Personagem Protagonista2;
	private static Personagem Antagonista2;
	private static int rodadaAtual = 0;
	private static boolean computador = false;
	private static Personagem SelecionadoJogando;
	private static Personagem SelecionadoEsperando;
	private static JRadioButton Time1Per1 = new JRadioButton();
	private static JRadioButton Time1Per2;
	private static JRadioButton Time2Per1 = new JRadioButton();
	private static JRadioButton Time2Per2;
	
	public static void setRadios(JRadioButton time1Per1, JRadioButton time1Per2, JRadioButton time2Per1, JRadioButton time2Per2){
		Time1Per1 = time1Per1;
		Time1Per2 = time1Per2;
		Time2Per1 = time2Per1;
		Time2Per2 = time2Per2;
	}
	
	public static JRadioButton getTime1Per1() {
		return Time1Per1;
	}
	public static JRadioButton getTime1Per2() {
		return Time1Per2;
	}
	public static JRadioButton getTime2Per1() {
		return Time2Per1;
	}
	public static JRadioButton getTime2Per2() {
		return Time2Per2;
	}
	public static Personagem getProtagonista1() {
		return Protagonista1;
	}
	public static void setProtagonista1(Personagem protagonista1) {
		Protagonista1 = protagonista1;
	}
	public static Personagem getAntagonista1() {
		return Antagonista1;
	}
	public static void setAntagonista1(Personagem antagonista1) {
		Antagonista1 = antagonista1;
	}
	public static Personagem getProtagonista2() {
		return Protagonista2;
	}
	public static void setProtagonista2(Personagem protagonista2) {
		Protagonista2 = protagonista2;
	}
	public static Personagem getAntagonista2() {
		return Antagonista2;
	}
	public static void setAntagonista2(Personagem antagonista2) {
		Antagonista2 = antagonista2;
	}
	public static Personagem getSelecionadoJogando() {
		return SelecionadoJogando;
	}
	public static void setSelecionadoJogando(Personagem selecionadoJogando) {
		SelecionadoJogando = selecionadoJogando;
	}
	public static Personagem getSelecionadoEsperando() {
		return SelecionadoEsperando;
	}
	public static void setSelecionadoEsperando(Personagem selecionadoEsperando) {
		SelecionadoEsperando = selecionadoEsperando;
	}
	public static int getRodadaAtual() {
		return rodadaAtual;
	}
	public static void setRodadaAtual(int RodadaAtual) {
		rodadaAtual = RodadaAtual;
	}
	
	public static boolean getComputador() {
		return computador;
	}
	
	public static void setComputador(boolean computador) {
		Rodada.computador = computador;
	}

	public static Personagem SelecionadoTime(int time, boolean selecionado)	{
		if (time == 1)	{
			if (Time1Per1.isSelected())	{
				return selecionado ? Protagonista1 : Antagonista1;
			} else {
				return selecionado ? Antagonista1 : Protagonista1;
			}
		} else if (time == 2) {
			if (Time2Per1.isSelected())	{
				return selecionado ? Protagonista2 : Antagonista2;
			} else {
				return selecionado ? Antagonista2 : Protagonista2;
			}
		}
		return null;
	}
	
	public static Personagem SelecionaPersonagem(String turno, boolean selecionado)	{
		if (turno == "atual")	{
			if (rodadaAtual %2 == 0)	{
				return SelecionadoTime(1, selecionado);
			} else if (rodadaAtual %2 != 0)	{
				return SelecionadoTime(2, selecionado);
			}
			return null;
		} else if (turno == "outro") {
			if (rodadaAtual %2 == 0)	{
				return SelecionadoTime(2, selecionado);
			} else if (rodadaAtual %2 != 0)	{
				return SelecionadoTime(1, selecionado);
			}
			return null;
		}
		return null;
	}
	
	public static Boolean PassaRodada()	{
		if ((Protagonista1.getVidaAtual() > 0 || Antagonista1.getVidaAtual() > 0) && 
			(Protagonista2.getVidaAtual() > 0 || Antagonista2.getVidaAtual() > 0))	{
			rodadaAtual += 1;
			if (rodadaAtual %2 == 0)	{
				Mensagens.setInformacoes("Rodada: "+rodadaAtual+"\r\nVez do Time 1: "+Protagonista1.getEquipe());
				IncrementaEnergias(Protagonista2, Antagonista2);
			} else if (rodadaAtual %2 != 0) {
				Mensagens.setInformacoes("Rodada: "+rodadaAtual+"\r\nVez do Time 2: "+Protagonista2.getEquipe());
				IncrementaEnergias(Protagonista1, Antagonista1);
			}
			return false;
		} else if (Protagonista1.getVidaAtual() <= 0 && Antagonista1.getVidaAtual() <= 0)	{
			// Desabilita os botões, limpa as telas e imagens e manda uma mensagem falando que o Protagonista1.Time Venceu, e depois colocar As variáveis de Rodada como nulo e salvar o que foi mudado no banco de dados.
			JOptionPane.showMessageDialog(null, "Parabéns, equipe "+Protagonista2.getEquipe()+", vocês venceram!");
			AtualizaPersonagens();
			rodadaAtual = 0;
			return true;
		} else if (Protagonista2.getVidaAtual() <= 0 && Antagonista2.getVidaAtual() <= 0)	{
			JOptionPane.showMessageDialog(null, "Parabéns, equipe "+Protagonista1.getEquipe()+", vocês venceram!");
			AtualizaPersonagens();
			rodadaAtual = 0;
			return true;
		} else {
			JOptionPane.showInternalMessageDialog(null, "Ocorreu um erro!");
			return false;
		}
	}
	
	public static void ChecaRadio(JRadioButton Time1Per1, JRadioButton Time1Per2, JRadioButton Time2Per1, JRadioButton Time2Per2)	{
		if (rodadaAtual % 2 != 0)	{
			if (Protagonista1.getVidaAtual() <= 0)	{
				Time1Per1.setEnabled(false);
				Time1Per2.setSelected(true);
			} else if (Antagonista1.getVidaAtual() <= 0)	{
				Time1Per2.setEnabled(false);
				Time1Per1.setSelected(true);
			}
		} else if (rodadaAtual % 2 == 0) {
			if (Protagonista2.getVidaAtual() <= 0)	{
				Time2Per1.setEnabled(false);
				Time2Per2.setSelected(true);
			} else if (Antagonista2.getVidaAtual() <= 0)	{
				Time2Per2.setEnabled(false);
				Time2Per1.setSelected(true);
			}
		}
	}
	
	public static void Atacar()	{
		Personagem personagem = SelecionaPersonagem("atual", true);
		Personagem inimigo = SelecionaPersonagem("outro", true);
		Double VidaInicial = inimigo.getVidaAtual();
		if (personagem.getEnergiaAtual() >= 5)	{
			personagem.AtacaPersonagem(inimigo);
			Mensagens.incrementaOcorrencias(personagem.getClasse()+" do time "+personagem.getEquipe()+" atacou "+inimigo.getClasse()+" do time "+inimigo.getEquipe());
		} else {
			JOptionPane.showMessageDialog(null, SelecionaPersonagem("atual", true).getClasse()+" não tem energia suficiente para atacar! Essa rodada será pulada.");
		}
		if (VidaInicial == inimigo.getVidaAtual())	{ Mensagens.incrementaOcorrencias(personagem.getClasse()+" do time "+personagem.getEquipe()+" errou!");}
		if (inimigo.getVidaAtual() <= 0)	{
			personagem.Evolui(inimigo.getNivel());
			Mensagens.incrementaOcorrencias(personagem.getClasse()+" do time "+personagem.getEquipe()+" derrotou "+inimigo.getClasse()+" do time "+inimigo.getEquipe());
		}
	}
	
	public static void executaMagias(JComboBox comboBox)	{
		Personagem personagem = SelecionaPersonagem("atual", true);
		Personagem parceiro = SelecionaPersonagem("atual", false);
		Personagem inimigo = SelecionaPersonagem("outro", true);
		Personagem parceiroinimigo = SelecionaPersonagem("outro", false);
		Double VidaInicial = inimigo.getVidaAtual();
		MagiasUtils.executaMagias((String)comboBox.getSelectedItem(),personagem,parceiro,inimigo,parceiroinimigo);
		Mensagens.incrementaOcorrencias(personagem.getClasse()+" do time "+personagem.getEquipe()+" lançou uma magia sobre o "+inimigo.getClasse()+" do time "+inimigo.getEquipe());
		if (VidaInicial == inimigo.getVidaAtual())	{ Mensagens.incrementaOcorrencias("A vida de "+inimigo.getClasse()+" do time "+ inimigo.getEquipe()+ " não foi alterada.");}
		if (inimigo.getVidaAtual() <= 0)	{
			personagem.Evolui(inimigo.getNivel());
			Mensagens.incrementaOcorrencias(personagem.getClasse()+" do time "+personagem.getEquipe()+" derrotou "+inimigo.getClasse()+" do time "+inimigo.getEquipe());
		}
	}
	
	public static void executaMagias(String magia)	{
		Personagem personagem = SelecionaPersonagem("atual", true);
		Personagem parceiro = SelecionaPersonagem("atual", false);
		Personagem inimigo = SelecionaPersonagem("outro", true);
		Personagem parceiroinimigo = SelecionaPersonagem("outro", false);
		Double VidaInicial = inimigo.getVidaAtual();
		MagiasUtils.executaMagias(magia,personagem,parceiro,inimigo,parceiroinimigo);
		Mensagens.incrementaOcorrencias(personagem.getClasse()+" do time "+personagem.getEquipe()+" lançou uma magia sobre o "+inimigo.getClasse()+" do time "+inimigo.getEquipe());
		if (VidaInicial == inimigo.getVidaAtual())	{ Mensagens.incrementaOcorrencias("A vida de "+inimigo.getClasse()+" do time "+ inimigo.getEquipe()+ " não foi alterada.");}
		if (inimigo.getVidaAtual() <= 0)	{
			personagem.Evolui(inimigo.getNivel());
			Mensagens.incrementaOcorrencias(personagem.getClasse()+" do time "+personagem.getEquipe()+" derrotou "+inimigo.getClasse()+" do time "+inimigo.getEquipe());
		}
	}
	
	public static void AtualizaPersonagens()	{
		@SuppressWarnings("serial")
		List<Personagem> personagens = new ArrayList<Personagem>(){{add(Antagonista1); add(Antagonista2); add(Protagonista1); add(Protagonista2);}};
		for (Personagem personagem : personagens) {
			personagem.setVidaAtual(personagem.getVida());
			personagem.setEnergiaAtual(personagem.getEnergia());
		}
		PersonagemControlador.AtualizaPersonagens(personagens);
	}
	
	private static void IncrementaEnergias(Personagem protagonista, Personagem antagonista)	{
		IncrementaEnergia(protagonista);
		IncrementaEnergia(antagonista);
	}
	
	private static void IncrementaEnergia(Personagem personagem){
		if (personagem.getEnergiaAtual() < personagem.getEnergia())	{
			personagem.setEnergiaAtual(personagem.getEnergiaAtual() + 5);
			if (personagem.getEnergiaAtual() > personagem.getEnergia())	{
				personagem.setEnergiaAtual(personagem.getEnergia());
			}
		}
	}

}