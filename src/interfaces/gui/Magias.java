package interfaces.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Magias extends JDialog {
	
	private Principal principal;

	public void setPrincipal(Principal principal) {
		this.principal = principal;
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
					System.out.println(principal.getRadioTime1Per1().isSelected());
				}
			});
			btnLanar.setBounds(10, 108, 108, 43);
			getContentPane().add(btnLanar);
		
		JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(132, 108, 108, 43);
			getContentPane().add(btnCancelar);
		
		JTextPane textPane = new JTextPane();
			textPane.setEditable(false);
			textPane.setBounds(10, 42, 230, 56);
			getContentPane().add(textPane);
		
		JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 11, 230, 20);
			getContentPane().add(comboBox);
	}
}
