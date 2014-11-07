package interfaces.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Comecar extends JDialog {

	private JPanel contentPane;
	private JTable tableTime1;
	private JTable tableTime2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comecar frame = new Comecar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Comecar() {
		setModal(true);
		setTitle("Escolha de Times");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscolhaOTime1 = new JLabel("Escolha o time 1:");
			lblEscolhaOTime1.setBounds(10, 11, 96, 14);
			contentPane.add(lblEscolhaOTime1);
		
		JComboBox comboBoxTime1 = new JComboBox();
		lblEscolhaOTime1.setLabelFor(comboBoxTime1);
			comboBoxTime1.setBounds(118, 8, 306, 20);
			contentPane.add(comboBoxTime1);
		
		JLabel lblEscolhaOTime2 = new JLabel("Escolha o time 2:");
			lblEscolhaOTime2.setBounds(10, 36, 96, 14);
			contentPane.add(lblEscolhaOTime2);
		
		JComboBox comboBoxTime2 = new JComboBox();
		lblEscolhaOTime2.setLabelFor(comboBoxTime2);
			comboBoxTime2.setBounds(118, 33, 306, 20);
			contentPane.add(comboBoxTime2);
		
		JButton btnComecarLuta = new JButton("Come\u00E7ar Luta");
			btnComecarLuta.setBounds(10, 61, 133, 46);
			contentPane.add(btnComecarLuta);
			
		JButton btnCriarNovoTime = new JButton("Criar Novo Time");
			btnCriarNovoTime.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarCriarNovoTime();
				}
			});
			btnCriarNovoTime.setBounds(153, 61, 133, 46);
			contentPane.add(btnCriarNovoTime);
		
		JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener()	{
				public void actionPerformed(ActionEvent e){
					dispose();
				}
			});
			btnCancelar.setBounds(297, 61, 127, 46);
			contentPane.add(btnCancelar);
		
		JLabel lblTime1 = new JLabel("Time 1:");
			lblTime1.setBounds(10, 118, 46, 14);
			contentPane.add(lblTime1);
		
		JLabel lblTime2 = new JLabel("Time 2:");
			lblTime2.setBounds(223, 118, 46, 14);
			contentPane.add(lblTime2);
		
		JScrollPane scrollPaneTime1 = new JScrollPane();
			scrollPaneTime1.setBounds(10, 143, 203, 108);
			contentPane.add(scrollPaneTime1);
		
			tableTime1 = new JTable();
			tableTime1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Personagem", "N\u00EDvel"
				}
			));
			lblTime1.setLabelFor(tableTime1);
				scrollPaneTime1.setViewportView(tableTime1);
		
		JScrollPane scrollPaneTime2 = new JScrollPane();
			scrollPaneTime2.setBounds(223, 143, 201, 108);
			contentPane.add(scrollPaneTime2);
			
			tableTime2 = new JTable();
			tableTime2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Personagem", "N\u00EDvel"
				}
			));
			lblTime2.setLabelFor(tableTime2);
				scrollPaneTime2.setViewportView(tableTime2);
	}
	
	CriarNovoTime criarNovoTime;
	
	private void mostrarCriarNovoTime()	{
		if (criarNovoTime == null)	{
			criarNovoTime = new CriarNovoTime();
			criarNovoTime.setVisible(true);
		} else {
			criarNovoTime.setVisible(true);
		}
	}
}
