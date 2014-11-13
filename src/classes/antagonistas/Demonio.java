package classes.antagonistas;
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
	
	public void DrenarForcas(Personagem inimigo)	{
		double ataque = DanoMagia - inimigo.getResistenciaMagia();
		double antes = inimigo.getVidaAtual();
		if (Chance.UmEm(3))	{
			AtaqueModificado(inimigo, ataque);
			if (inimigo.getVidaAtual() < antes)	{
				EnergiaAtual += ataque;
			} else {
				EnergiaAtual -= 40;
			}
		} else {
			EnergiaAtual -= 40;
		}
	}
}
