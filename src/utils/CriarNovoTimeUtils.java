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
			JOptionPane.showMessageDialog(null,"Os n�meros n�o s�o compat�veis! Cheque se est� distribuindo no m�ximo 12 pontos pra cada personagem");
			return false;
		} else {
			JOptionPane.showMessageDialog(null,"O nome de equipe "+equipe+" j� foi selecionado! Escolha outro");
			return false;
		}
	}
	
	public static void textoSelecao(Object objeto, JTextPane painel)	{
		// Protagonistas
		String textoGuerreiro 	= "Guerreiro: \r\n"
								+ "S�o conhecidos por sua brutalidade e violencia. "
								+ "Guerreiros tem vantagem nos atributos de Dano Normal, Dano M�gico e Energia, mas em compensa��o s�o fracos "
								+ "em Dano m�gico, Resist�ncia M�gica e Esquiva, devido a sua afinidade com o combate corpo a corpo e o peso de sua armadura.";
		//
		String textoConjurador 	= "Conjurador: \r\n"
								+ "Fazem uso das artemanhas das trevas para conjurar as piores maldi��es conhecidas, ningu�m sabe sua origem. "
								+ "Conjuradores tem vantagem nos atributos Dano M�gico e Resist�ncia M�gica, mas em compensa��o, sua Resist�ncia Normal � fraca.";
		//
		String textoAtirador 	= "Atirador: \r\n"
								+ "S�o veteranos de guerra �geis com uma precis�o sobre-humana e intelig�ncia altamente apurada. "
								+ "Atiradores tem vantagem nos atriburos Esquiva e Precis�o e um pequeno incremento nos atributos Dano Normal e Energia. ";
		// Antagonistas
		String textoDemonio		= "Dem�nio: \r\n"
								+ "S�o seres originados diretamente do fundo do inferno, representam tudo o que h� de errado e ruim neste mundo. "
								+ "Demonios tem vantagem no atributo Dano M�gico.";
		//
		String textoMortoVivo	= "Morto Vivo: \r\n"
								+ "J� foram humanos normais um dia, at� que uma pandemia fez com que passassem de humanos para abomina��es. "
								+ "Mortos Vivos tem vantagem no atributo Vida.";
		//
		String textoWookie		= "Wookie: \r\n"
								+ "Os Wookiees s�o uma esp�cie de human�ides b�pedes peludos que habitavam o planeta de Kashyyyk antes de fazerem da terra sua moradia. "
								+ "Wookies tem vantagem no atributo Precis�o.";
		
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
