package utils;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import classes.basicas.Personagem;
import controladores.PersonagemControlador;

public class CriarNovoTimeUtils {
	
	public static void CriaPersonagem(String classe, String equipe, double danoNormal, double danoMagia, double resistenciaNormal, double resistenciaMagia )	{
		Personagem personagem = PersonagemUtils.EscolheClasse(classe);
		personagem.CriarPersonagem(danoNormal, danoMagia, resistenciaNormal, resistenciaMagia, equipe);
		System.out.println(personagem);
		PersonagemControlador.CriaPersonagem(personagem);
	}
	
	public static boolean CriaTime(String classe, String equipe, double danoNormal, double danoMagia, double resistenciaNormal, double resistenciaMagia,
								String classe1, String equipe1, double danoNormal1, double danoMagia1, double resistenciaNormal1, double resistenciaMagia1)	{
		double soma = danoMagia+danoNormal+resistenciaMagia+resistenciaNormal;
		double soma1= danoMagia1+danoNormal1+resistenciaMagia1+resistenciaNormal1;
		if (!PersonagemControlador.ListaColuna("EQUIPE").contains(equipe) && soma==12 && soma1==12)	{
			CriaPersonagem(classe1, equipe1, danoNormal1, danoMagia1, resistenciaNormal1, resistenciaMagia1);
			CriaPersonagem(classe, equipe, danoNormal, danoMagia, resistenciaNormal, resistenciaMagia);
			JOptionPane.showMessageDialog(null,"Equipe "+equipe+" criada com sucesso!");
			return true;
		} else if (soma != 12 || soma1 != 12) {
			JOptionPane.showMessageDialog(null,"Os números não são compatíveis! Cheque se está distribuindo no máximo 12 pontos pra cada personagem");
			return false;
		} else {
			JOptionPane.showMessageDialog(null,"O nome de equipe "+equipe+" já foi selecionado! Escolha outro");
			return false;
		}
	}
	
	public static void textoSelecao(Object objeto, JTextPane painel)	{
		// Protagonistas
		String textoGuerreiro 	= "Guerreiro: \r\n"
								+ "São conhecidos por sua brutalidade e violencia. "
								+ "Guerreiros tem vantagem nos atributos de Dano Normal, Dano Mágico e Energia, mas em compensação são fracos "
								+ "em Dano mágico, Resistência Mágica e Esquiva, devido a sua afinidade com o combate corpo a corpo e o peso de sua armadura.";
		//
		String textoConjurador 	= "Conjurador: \r\n"
								+ "Fazem uso das artemanhas das trevas para conjurar as piores maldições conhecidas, ninguém sabe sua origem. "
								+ "Conjuradores tem vantagem nos atributos Dano Mágico e Resistência Mágica, mas em compensação, sua Resistência Normal é fraca.";
		//
		String textoAtirador 	= "Atirador: \r\n"
								+ "São veteranos de guerra ágeis com uma precisão sobre-humana e inteligência altamente apurada. "
								+ "Atiradores tem vantagem nos atriburos Esquiva e Precisão e um pequeno incremento nos atributos Dano Normal e Energia. ";
		// Antagonistas
		String textoDemonio		= "Demônio: \r\n"
								+ "São seres originados diretamente do fundo do inferno, representam tudo o que há de errado e ruim neste mundo. "
								+ "Demonios tem vantagem no atributo Dano Mágico.";
		//
		String textoMortoVivo	= "Morto Vivo: \r\n"
								+ "Já foram humanos normais um dia, até que uma pandemia fez com que passassem de humanos para abominações. "
								+ "Mortos Vivos tem vantagem no atributo Vida.";
		//
		String textoWookie		= "Wookie: \r\n"
								+ "Os Wookiees são uma espécie de humanóides bípedes peludos que habitavam o planeta de Kashyyyk antes de fazerem da terra sua moradia. "
								+ "Wookies tem vantagem no atributo Precisão.";
		
		if (objeto == null)	{
			painel.setText("");
		} else {
			switch (objeto.toString()) {
			case "Guerreiro":
				painel.setText(textoGuerreiro);
				break;
			case "Conjurador":
				painel.setText(textoConjurador);
				break;
			case "Atirador":
				painel.setText(textoAtirador);
				break;
			case "Demonio":
				painel.setText(textoDemonio);
				break;
			case "MortoVivo":
				painel.setText(textoMortoVivo);
				break;
			case "Wookie":
				painel.setText(textoWookie);
				break;
			default:
				painel.setText("");
				break;
			}
		}
	}
	
}
