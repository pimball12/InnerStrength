package utils;

import java.util.List;

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
}
