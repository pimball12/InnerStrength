package classes.protagonistas;

import javax.swing.JOptionPane;

import classes.basicas.Personagem;
import classes.basicas.Protagonista;

public class Guerreiro extends Protagonista {
	
	public Guerreiro()	{
		Classe = "Guerreiro";
	}
	
	public void DefinicaoInicial2()	{
		DanoNormal += 4;
		DanoMagia -= 4;
		ResistenciaNormal += 3;
		ResistenciaMagia -=4;
		Esquiva -= 0.02;
		Energia += 5;
		EnergiaAtual = Energia;
	}
	
	//Especiais
	
	public void Descontrole(Personagem inimigo)	{
		double ataque = DanoNormal*0.5 - inimigo.getResistenciaNormal()/2;
		int hit = 0;
		while (true)	{
			double antes = inimigo.getVidaAtual();
			AtaqueModificado(inimigo, ataque);
			if (antes == inimigo.getVidaAtual()) { break; }
			JOptionPane.showMessageDialog(null,"Golpe numero "+(hit+=1)+"!");
		}
		EnergiaAtual -= 50;
	}
	
	public void AtaqueBrutal(Personagem inimigo)	{
		double ataque = DanoNormal*1.5 - inimigo.getResistenciaNormal()/4;
		AtaqueModificado(inimigo, ataque);
		EnergiaAtual -= 40;
	}
	
	public void Violencia(Personagem inimigo)	{
		double ataque = DanoNormal*1.5 - inimigo.getResistenciaNormal()/2;
		AtaqueModificado(inimigo, ataque);
		AtaqueModificado(this, DanoNormal/10);
		EnergiaAtual -= 30;
	}
	
}
