package classes.antagonistas;
import classes.basicas.Antagonista;
import classes.basicas.Personagem;

public class Demonio extends Antagonista {
	
	public void DefinicaoInicial2()	{
		DanoMagia += 5;
	}
	
	public void AtacaPersonagem(Personagem p)	{
		double ataque = DanoNormal*Precisao - (DanoNormal*Precisao*p.getEsquiva())-p.getResistenciaNormal()/2; 
		p.setVidaAtual(p.getVidaAtual()-ataque);
	}
}
