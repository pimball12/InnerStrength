package utils;

import interfaces.gui.Principal;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

	public static void AdicionaInformacoes(Personagem protagonista1, Personagem protagonista2, Personagem antagonista1, Personagem antagonista2, 
											JTable infoProtagonista1, JTable infoProtagonista2, JTable infoAntagonista1, JTable infoAntagonista2) {
		AdicionaInformacao(protagonista1, infoProtagonista1);
		AdicionaInformacao(protagonista2, infoProtagonista2);
		AdicionaInformacao(antagonista1, infoAntagonista1);
		AdicionaInformacao(antagonista2, infoAntagonista2);
	}
	
	public static void AdicionaInformacao(Personagem protagonista, JTable infoProtagonista)	{
		DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"Atributos","Valores"});
		String[] vazio = new String[]{"", ""};
		String[] campos = new String[]{"Classe","Vida","Energia","Dano","Dano Mágico","Resistência","Resistencia à magia", "Precisão", "Esquiva","Nível", "Experiência"};
		String[] valores = new String[]{protagonista.getClasse(),
										protagonista.getVidaAtual()+"/"+protagonista.getVida(),
										protagonista.getEnergiaAtual()+"/"+protagonista.getEnergia(),
										String.valueOf(protagonista.getDanoNormal()),
										String.valueOf(protagonista.getDanoMagia()),
										String.valueOf(protagonista.getResistenciaNormal()),
										String.valueOf(protagonista.getResistenciaMagia()),
										String.valueOf(protagonista.getPrecisao()),
										String.valueOf(protagonista.getEsquiva()), 
										String.valueOf(protagonista.getNivel()),
										String.valueOf(protagonista.getExperiencia())};
		while (modelo.getRowCount() > 0)	{
			modelo.removeRow(0);
		}
		for (int x = 0; x < campos.length; x++)	{
			modelo.addRow(vazio);
			modelo.setValueAt(campos[x], x, 0);
			modelo.setValueAt(valores[x], x, 1);
		}
		
		infoProtagonista.setModel(modelo);
	}
}













