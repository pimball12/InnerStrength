package interfaces.gui;

import interfaces.funcionamento.Rodada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import utils.MagiasUtils;

public class Magias extends JFrame {
	
	List<String> listaPoderes = MagiasUtils.retornaMagias();
	JComboBox<String> comboBox;

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	/**
	 * Create the dialog.
	 */
	
	public Magias() {		
		
		setBounds(100, 100, 266, 200);
		getContentPane().setLayout(null);
		
		JButton btnLanar = new JButton("Lan\u00E7ar");
			btnLanar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Magia();
				}
			});
			btnLanar.setBounds(10, 108, 108, 43);
			getContentPane().add(btnLanar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.setSelectedItem(null);
				dispose();
			}
		});
			btnCancelar.setBounds(132, 108, 108, 43);
			getContentPane().add(btnCancelar);
		
		JTextPane textPane = new JTextPane();
			textPane.setEditable(false);
			textPane.setBounds(10, 42, 230, 56);
			getContentPane().add(textPane);
			
		comboBox = new JComboBox(listaPoderes.toArray());
			comboBox.setSelectedItem(null);
			comboBox.setBounds(10, 11, 230, 20);
			getContentPane().add(comboBox);
			
	}
	
	private void Magia()	{
		if (MagiasUtils.podeExecutar((String)comboBox.getSelectedItem(), Rodada.SelecionaPersonagem("atual", true)))	{
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Voc� n�o tem energia o suficiente!");
		}
	}
	
}