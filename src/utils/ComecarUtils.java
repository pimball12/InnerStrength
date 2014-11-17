package utils;

import interfaces.funcionamento.Rodada;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.basicas.Personagem;
import controladores.PersonagemControlador;

public class ComecarUtils {

	private static List<Personagem> lista;
	
	public static void preencherTabela(JTable tabela, String time)	{
		if (time != null){
			DefaultTableModel modeloComboBoxTime = new DefaultTableModel(null, new String[]{"Personagem", "nível"});
			while (modeloComboBoxTime.getRowCount() > 0)	{
				modeloComboBoxTime.removeRow(0);
			}
			lista = PersonagemControlador.ListaPersonagens("EQUIPE", time);
			String[] campos = new String[]{null,null};
			for (int x = 0; x < lista.size(); x++ ) {
				modeloComboBoxTime.addRow(campos);
				modeloComboBoxTime.setValueAt(lista.get(x).getClasse(), x, 0);
				modeloComboBoxTime.setValueAt(lista.get(x).getNivel(), x, 1);
			}
			
			tabela.setModel(modeloComboBoxTime);
		}
	}
	
	public static boolean DefinirTimes(String time1, String time2)	{
		List<Personagem> equipe1 = PersonagemControlador.ListaPersonagens("EQUIPE", time1);
		List<Personagem> equipe2 = PersonagemControlador.ListaPersonagens("EQUIPE", time2);
		
		if (!equipe1.isEmpty() && !equipe2.isEmpty() && time1 != time2)	{
			for (Personagem personagem : equipe1) {
				if (personagem.getClasse() == "Conjurador" || personagem.getClasse() == "Atirador" || personagem.getClasse() == "Guerreiro")	{
					Rodada.setProtagonista1(personagem);
				}
				else if (personagem.getClasse() == "Demonio" || personagem.getClasse() == "Wookie" || personagem.getClasse() == "MortoVivo")	{
					Rodada.setAntagonista1(personagem);
				}
			}
			
			for (Personagem personagem : equipe2) {
				if (personagem.getClasse() == "Conjurador" || personagem.getClasse() == "Atirador" || personagem.getClasse() == "Guerreiro")	{
					Rodada.setProtagonista2(personagem);
				}
				else if (personagem.getClasse() == "Demonio" || personagem.getClasse() == "Wookie" || personagem.getClasse() == "MortoVivo")	{
					Rodada.setAntagonista2(personagem);
				}
			}
			return true;
		} else if (time1 == time2) {
			JOptionPane.showMessageDialog(null, "Escolha dois times diferentes!");
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "Selecione os times!");
			return false;
		}
	}
	
	public static void DefinirOponente(boolean checkbox)	{
		if (checkbox)	{
			Rodada.setComputador(true);
		} else {
			Rodada.setComputador(false);
		}
	}
	
}
