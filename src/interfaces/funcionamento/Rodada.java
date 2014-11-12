package interfaces.funcionamento;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import controladores.PersonagemControlador;
import classes.basicas.Personagem;

public class Rodada {
	private static Personagem Protagonista1;
	private static Personagem Antagonista1;
	private static Personagem Protagonista2;
	private static Personagem Antagonista2;
	private static int rodadaAtual = 0;
	
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
	
	public static String ShowRodada() {
		return "Rodada ["+Protagonista1+", "+Antagonista1+", "+Protagonista2+", "+Antagonista2+"]";
	}
	
	public static int getRodadaAtual() {
		return rodadaAtual;
	}
	public static void setRodadaAtual(int RodadaAtual) {
		rodadaAtual = RodadaAtual;
	}
	
	public static Personagem SelecionadoTime1(JRadioButton Time1Per1)	{
		if (Time1Per1.isSelected())	{
			return Protagonista1;
		} else {
			return Antagonista1;
		}
	}
	
	public static Personagem SelecionadoTime2(JRadioButton Time2Per1)	{
		if (Time2Per1.isSelected())	{
			return Protagonista2;
		} else {
			return Antagonista2;
		}
	}
	
	public static Boolean PassaRodada()	{
		if ((Protagonista1.getVidaAtual() > 0 || Antagonista1.getVidaAtual() > 0) && 
			(Protagonista2.getVidaAtual() > 0 || Antagonista2.getVidaAtual() > 0))	{
			rodadaAtual += 1;
			if (rodadaAtual %2 == 0)	{
				Mensagens.setInformacoes("Rodada: "+rodadaAtual+"\r\nVez de: "+Protagonista1.getEquipe());
				IncrementaEnergias(Protagonista2, Antagonista2);
			} else if (rodadaAtual %2 != 0) {
				Mensagens.setInformacoes("Rodada: "+rodadaAtual+"\r\nVez de: "+Protagonista2.getEquipe());
				IncrementaEnergias(Protagonista1, Antagonista1);
			}
			return false;
		} else if (Protagonista1.getVidaAtual() <= 0 && Antagonista1.getVidaAtual() <= 0)	{
			// Desabilita os botões, limpa as telas e imagens e manda uma mensagem falando que o Protagonista1.Time Venceu, e depois colocar As variáveis de Rodada como nulo e salvar o que foi mudado no banco de dados.
			JOptionPane.showMessageDialog(null, "Parabéns, equipe "+Protagonista2.getEquipe()+", vocês venceram!");
			AtualizaPersonagens();
			Mensagens.setInformacoes("");
			Mensagens.setOcorrencias("");
			rodadaAtual = 0;
			return true;
		} else if (Protagonista2.getVidaAtual() <= 0 && Antagonista2.getVidaAtual() <= 0)	{
			JOptionPane.showMessageDialog(null, "Parabéns, equipe "+Protagonista1.getEquipe()+", vocês venceram!");
			AtualizaPersonagens();
			Mensagens.setInformacoes("");
			Mensagens.setOcorrencias("");
			rodadaAtual = 0;
			return true;
		} else {
			JOptionPane.showInternalMessageDialog(null, "Ocorreu um erro!");
			return false;
		}
	}
	
	private static void ChecaRadio1(JRadioButton Time1Per1, JRadioButton Time1Per2)	{
		if (Protagonista1.getVidaAtual() <= 0)	{
			Time1Per1.setEnabled(false);
			Time1Per2.setSelected(true);
		} else if (Antagonista1.getVidaAtual() <= 0)	{
			Time1Per2.setEnabled(false);
			Time1Per1.setSelected(true);
		}
	}
	
	private static void ChecaRadio2(JRadioButton Time2Per1, JRadioButton Time2Per2)	{
		if (Protagonista2.getVidaAtual() <= 0)	{
			Time2Per1.setEnabled(false);
			Time2Per2.setSelected(true);
		} else if (Antagonista2.getVidaAtual() <= 0)	{
			Time2Per2.setEnabled(false);
			Time2Per1.setSelected(true);
		}
	}
	
	public static void Atacar(JRadioButton Time1Per1, JRadioButton Time1Per2, JRadioButton Time2Per1, JRadioButton Time2Per2) {
		Personagem time1 = SelecionadoTime1(Time1Per1);
		Personagem time2 = SelecionadoTime2(Time2Per1);
		if (rodadaAtual%2 == 0)	{
			time1.AtacaPersonagem(time2);
			Mensagens.incrementaOcorrencias(time1.getClasse()+" do time "+time1.getEquipe()+" atacou "+time2.getClasse()+" do time "+time2.getEquipe());
			if (time2.getVidaAtual() <= 0)	{
				time1.Evolui(time2.getNivel());
				Mensagens.incrementaOcorrencias(time1.getClasse()+" do time "+time1.getEquipe()+" derrotou "+time2.getClasse()+" do time "+time2.getEquipe());
			}
			ChecaRadio2(Time2Per1,Time2Per2);
		} else if (rodadaAtual%2 != 0)	{
			time2.AtacaPersonagem(time1);
			Mensagens.incrementaOcorrencias(time2.getClasse()+" do time "+time2.getEquipe()+" atacou "+time1.getClasse()+" do time "+time1.getEquipe());
			if (time1.getVidaAtual() <= 0)	{
				time2.Evolui(time1.getNivel());
				Mensagens.incrementaOcorrencias(time2.getClasse()+" do time "+time2.getEquipe()+" derrotou "+time1.getClasse()+" do time "+time1.getEquipe());
			}
			ChecaRadio1(Time1Per1, Time1Per2);
		}
	}
	
	public static void AtualizaPersonagens()	{
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
			personagem.setEnergiaAtual(personagem.getEnergiaAtual() + 3);
			if (personagem.getEnergiaAtual() > personagem.getEnergia())	{
				personagem.setEnergiaAtual(personagem.getEnergia());
			}
		}
	}

}