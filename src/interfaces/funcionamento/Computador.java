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
		
		if (AtaqueOuMagia)	{
			Rodada.Atacar();
		} else {
			String magia = ComputadorUtils.selecionaMagia();
			if (Rodada.SelecionaPersonagem("atual", true).getEnergiaAtual() > 40)	{
				if (MagiasUtils.podeExecutar(magia, Rodada.SelecionaPersonagem("atual", true)))	{
					Rodada.executaMagias(ComputadorUtils.selecionaMagia());
					JOptionPane.showMessageDialog(null, Rodada.SelecionaPersonagem("atual", true).getClasse()+" do time "
					+Rodada.SelecionaPersonagem("atual", true).getEquipe()+" lancou a magia "+magia);
				} else {
					Rodada.Atacar();
				}
			} else {
				Rodada.Atacar();
			}
		}
	}
}
