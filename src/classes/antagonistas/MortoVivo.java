package classes.antagonistas;
import utils.Chance;
import classes.basicas.Antagonista;
import classes.basicas.Personagem;

public class MortoVivo extends Antagonista {

	public MortoVivo()	{
		Classe = "MortoVivo";
	}
	
	public void DefinicaoInicial2()	{
		Vida += 15;
		VidaAtual = Vida;
	}
	
	public void Canibalismo(Personagem inimigo)	{
		double ataque = DanoNormal - inimigo.getResistenciaNormal()/2;
		double antes = inimigo.getVidaAtual();
		AtaqueModificado(inimigo, ataque);
		if (VidaAtual < Vida && inimigo.getVidaAtual() < antes)	{
			VidaAtual += ataque;
			if (VidaAtual > Vida){
				VidaAtual = Vida;
			}
			EnergiaAtual -= 40;
		}
	}
	
	public void Ebola(Personagem inimigo)	{
		if (Chance.UmEm(3))	{
			inimigo.setVidaAtual(inimigo.getVidaAtual()/2);
			EnergiaAtual -= 40;
		}
	}
}
