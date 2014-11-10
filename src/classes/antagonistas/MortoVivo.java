package classes.antagonistas;
import classes.basicas.Antagonista;

public class MortoVivo extends Antagonista {

	public MortoVivo()	{
		Classe = "MortoVivo";
	}
	
	public void DefinicaoInicial2()	{
		Vida += 15;
		VidaAtual = Vida;
	}
	
}
