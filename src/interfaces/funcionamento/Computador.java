package interfaces.funcionamento;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import utils.Chance;
import utils.ComputadorUtils;
import utils.MagiasUtils;

public class Computador {
	public static void acao(JRadioButton radioTime1Per1, JRadioButton radioTime1Per2, JRadioButton radioTime2Per1, JRadioButton radioTime2Per2)	{
		boolean AtaqueOuMagia = Chance.BoleanoAleatorio();
		boolean PersonagemSelecionado = Chance.BoleanoAleatorio();
		boolean InimigoSelecionado = Chance.BoleanoAleatorio();

		Selecao(PersonagemSelecionado, InimigoSelecionado, radioTime1Per1, radioTime1Per2, radioTime2Per1, radioTime2Per2);
		
		if (Rodada.SelecionaPersonagem("atual", true).getEnergiaAtual() > 5)	{ 
			if (AtaqueOuMagia)	{
				Rodada.Atacar();
				Mensagem("ataque");
			} else {
				String magia = ComputadorUtils.selecionaMagia();
				if (Rodada.SelecionaPersonagem("atual", true).getEnergiaAtual() > 40)	{
					if (MagiasUtils.podeExecutar(magia, Rodada.SelecionaPersonagem("atual", true)))	{
						Rodada.executaMagias(ComputadorUtils.selecionaMagia());
						Mensagem("magia",magia);
					} else {
						Rodada.Atacar();
						Mensagem("ataque");
					}
				} else {
					Rodada.Atacar();
					Mensagem("ataque");
				}
			}
		}
	}
	
	private static void Mensagem(String tipo)	{
			JOptionPane.showMessageDialog(null, Rodada.SelecionaPersonagem("atual", true).getClasse()+" do time "
					+Rodada.SelecionaPersonagem("atual", true).getEquipe()+" atacou "
					+Rodada.SelecionaPersonagem("outro", true).getClasse()+" do time "
					+Rodada.SelecionaPersonagem("outro", true).getEquipe());
	}
	
	private static void Mensagem(String tipo, String magia)	{
			JOptionPane.showMessageDialog(null, Rodada.SelecionaPersonagem("atual", true).getClasse()+" do time "
					+Rodada.SelecionaPersonagem("atual", true).getEquipe()+" lancou a magia "+magia);
	}
	
	private static void Selecao(boolean PersonagemSelecionado, boolean InimigoSelecionado, JRadioButton radioTime1Per1, JRadioButton radioTime1Per2, JRadioButton radioTime2Per1, JRadioButton radioTime2Per2)	{
		if(PersonagemSelecionado) {
			if (radioTime2Per1.isEnabled())	{ radioTime2Per1.setSelected(true);}
		} else {
			if (radioTime2Per2.isEnabled())	{ radioTime2Per2.setSelected(true);}
		}
		
		if(InimigoSelecionado) {
			if (radioTime1Per1.isEnabled())	{ radioTime1Per1.setSelected(true);}
		} else {
			if (radioTime1Per2.isEnabled())	{ radioTime1Per2.setSelected(true);}
		}
		
		if (Rodada.SelecionaPersonagem("atual", true).getEnergiaAtual() < 5)	{
			if (radioTime1Per1.isSelected()){ radioTime1Per2.setSelected(true);}
			else if (radioTime1Per2.isSelected()){ radioTime1Per1.setSelected(true);}
		}
	}
	
}
