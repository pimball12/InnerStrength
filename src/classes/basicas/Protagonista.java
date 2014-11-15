package classes.basicas;

import javax.swing.JOptionPane;

public abstract class Protagonista extends Personagem {

	public void DefinicaoInicial1() {
		
	}
	
	public void CuraPersonagem(Personagem personagem)	{
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja curar ao outro personagem? Caso contrário, você irá curar a sí mesmo.", "Curar", JOptionPane.YES_NO_CANCEL_OPTION);
		if (opcao == JOptionPane.YES_OPTION)	{
			if (personagem.getVidaAtual() < personagem.getVida())	{
				personagem.setVidaAtual(personagem.getVidaAtual() + personagem.getVidaAtual() * 0.3);
				EnergiaAtual -= 30;
				if (personagem.getVidaAtual() > personagem.getVida())	{
					personagem.setVidaAtual(personagem.getVida());
				}
			}
		} else if (opcao == JOptionPane.NO_OPTION) {
			if (VidaAtual < Vida)	{
				VidaAtual = VidaAtual + VidaAtual*0.3;
				EnergiaAtual -= 30;
				if (VidaAtual > Vida)	{
					VidaAtual = Vida;
				}
			}
		}
	}
	
}
