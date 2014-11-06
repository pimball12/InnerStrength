package utils;

import javax.swing.JOptionPane;

import controladores.PersonagemControlador;
import classes.basicas.Personagem;

public class CriarNovoTimeUtils {
	public static void CriaPersonagem(String classe, String equipe, double danoNormal, double danoMagia, double resistenciaNormal, double resistenciaMagia )	{
		double soma = danoNormal + danoMagia + resistenciaNormal + resistenciaMagia;
		if (soma == 12)	{
			Personagem personagem = PersonagemUtils.EscolheClasse(classe);
			personagem.CriarPersonagem(danoNormal, danoMagia, resistenciaNormal, resistenciaMagia, equipe);
			System.out.println(personagem);
			PersonagemControlador.CriaPersonagem(personagem);
		} else if (soma < 12)	{
			JOptionPane.showMessageDialog(null, classe+" ainda tem pontos para adicionar!");
		} else {
			JOptionPane.showMessageDialog(null, classe+" está com mais pontos do que deveria! Diminúa um dos atributos!");
		}
	}
}
