package classes.basicas;

import javax.swing.JOptionPane;

import utils.Chance;

public abstract class Protagonista extends Personagem {

	public void DefinicaoInicial1() {
		
	}
	
	public void CuraPersonagem(Personagem personagem)	{
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja curar ao outro personagem? Caso contrário, você irá curar a sí mesmo.", "Curar", JOptionPane.YES_NO_CANCEL_OPTION);
		if (opcao == JOptionPane.YES_OPTION)	{
			if (personagem.getVidaAtual() < personagem.getVida())	{
				personagem.setVidaAtual(personagem.getVidaAtual() + personagem.getVida() * 0.3);
				EnergiaAtual -= 30;
				if (personagem.getVidaAtual() > personagem.getVida())	{
					personagem.setVidaAtual(personagem.getVida());
				}
			}
		} else if (opcao == JOptionPane.NO_OPTION) {
			if (VidaAtual < Vida)	{
				VidaAtual = VidaAtual + Vida*0.3;
				EnergiaAtual -= 30;
				if (VidaAtual > Vida)	{
					VidaAtual = Vida;
				}
			}
		}
	}
	
	public void CuraPersonagemAleatorio(Personagem personagem)	{
		boolean opcao = Chance.BoleanoAleatorio();
		if (opcao == true)	{
			if (personagem.getVidaAtual() < personagem.getVida())	{
				personagem.setVidaAtual(personagem.getVidaAtual() + personagem.getVida() * 0.3);
				EnergiaAtual -= 30;
				if (personagem.getVidaAtual() > personagem.getVida())	{
					personagem.setVidaAtual(personagem.getVida());
				}
			}
		} else if (opcao == false) {
			if (VidaAtual < Vida)	{
				VidaAtual = VidaAtual + Vida*0.3;
				EnergiaAtual -= 30;
				if (VidaAtual > Vida)	{
					VidaAtual = Vida;
				}
			}
		}
	}
}
