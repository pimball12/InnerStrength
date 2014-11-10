package utils;

import interfaces.gui.Principal;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import classes.basicas.Personagem;


public class PrincipalUtils {

	public static void AdicionaFotos(	Personagem protagonista1, Personagem protagonista2, Personagem antagonista1, Personagem antagonista2, 
										JLabel fotoTime1Per1, JLabel fotoTime2Per1, JLabel fotoTime1Per2, JLabel fotoTime2Per2) {
		AdicionaFoto(protagonista1, fotoTime1Per1, "esquerdo");
		AdicionaFoto(protagonista2, fotoTime2Per1, "direito");
		AdicionaFoto(antagonista1, fotoTime1Per2, "esquerdo");
		AdicionaFoto(antagonista2, fotoTime2Per2, "direito");
	}
	
	public static void AdicionaFoto(Personagem personagem, JLabel label, String lado)	{
		String inc = "";
		
		if (lado == "direito")	{
			inc = "1";
		}
		
		switch (personagem.getClasse()) {
		case "Guerreiro":
			label.setIcon(new ImageIcon(Principal.class.getResource("/Images/Guerreiro"+inc+".png")));
			break;
		case "Conjurador":
			label.setIcon(new ImageIcon(Principal.class.getResource("/Images/Conjurador"+inc+".png")));
			break;
		case "Atirador":
			label.setIcon(new ImageIcon(Principal.class.getResource("/Images/Atirador"+inc+".png")));
			break;
		case "Demonio":
			label.setIcon(new ImageIcon(Principal.class.getResource("/Images/Demonio"+inc+".png")));;
			break;
		case "MortoVivo":
			label.setIcon(new ImageIcon(Principal.class.getResource("/Images/MortoVivo"+inc+".png")));
			break;
		case "Wookie":
			label.setIcon(new ImageIcon(Principal.class.getResource("/Images/Wookie"+inc+".png")));
			break;
		}
	}
}
