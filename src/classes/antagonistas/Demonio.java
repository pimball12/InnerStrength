package classes.antagonistas;
import javax.swing.JOptionPane;

import utils.Chance;
import classes.basicas.Antagonista;
import classes.basicas.Personagem;

public class Demonio extends Antagonista {
	
	public Demonio()	{
		Classe = "Demonio";
	}
	
	public void DefinicaoInicial2()	{
		DanoMagia += 3;
	}
	
	public void GarrasAmaldicoadas(Personagem inimigo)	{
		double ataque = (DanoMagia + DanoNormal)*0.8 - (inimigo.getResistenciaNormal() + inimigo.getResistenciaMagia())*0.25;
		AtaqueModificado(inimigo, ataque);
		EnergiaAtual -= 40;
	}
	
	public void DrenarForcas(Personagem inimigo, Personagem parceiro)	{
		double ataque = DanoMagia - inimigo.getResistenciaMagia();
		double antes = inimigo.getVidaAtual();
		
		if (Chance.UmEm(3))	{
			AtaqueModificado(inimigo, ataque);
			if (inimigo.getVidaAtual() < antes)	{
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja transferir a energia ao outro personagem? Caso contrário, você irá toma-la para sí.", "Drenar", JOptionPane.YES_NO_CANCEL_OPTION);
				if (opcao == JOptionPane.YES_OPTION)	{
					parceiro.setEnergiaAtual((int) (parceiro.getEnergiaAtual()+ataque));
					if (parceiro.getEnergiaAtual() > parceiro.getEnergia())	{parceiro.setEnergiaAtual(parceiro.getEnergia());}
				} else if (opcao == JOptionPane.NO_OPTION) {
					EnergiaAtual += ataque; 
					if (EnergiaAtual > Energia)	{EnergiaAtual = Energia;}
				}
			} else {
				EnergiaAtual -= 40;
			}
		} else {
			EnergiaAtual -= 40;
		}
	}
	
	public void DrenarForcasAleatorio(Personagem inimigo, Personagem parceiro)	{
		double ataque = DanoMagia - inimigo.getResistenciaMagia();
		double antes = inimigo.getVidaAtual();
		boolean opcao = Chance.BoleanoAleatorio();
		
		if (Chance.UmEm(3))	{
			AtaqueModificado(inimigo, ataque);
			if (inimigo.getVidaAtual() < antes)	{
				if (opcao == true)	{
					parceiro.setEnergiaAtual((int) (parceiro.getEnergiaAtual()+ataque));
					if (parceiro.getEnergiaAtual() > parceiro.getEnergia())	{parceiro.setEnergiaAtual(parceiro.getEnergia());}
				} else if (opcao == false) {
					EnergiaAtual += ataque; 
					if (EnergiaAtual > Energia)	{EnergiaAtual = Energia;}
				}
			} else {
				EnergiaAtual -= 40;
			}
		} else {
			EnergiaAtual -= 40;
		}
	}

}
