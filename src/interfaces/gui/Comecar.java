package interfaces.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import utils.ComecarUtils;
import controladores.PersonagemControlador;

@SuppressWarnings("serial")
public class Comecar extends JFrame {

	private JPanel contentPane;
	private JTable tableTime1;
	private JTable tableTime2;
	List<String> listaTimes = PersonagemControlador.ListaColunaDistinta("EQUIPE");
	private CriarNovoTime criarNovoTime = new CriarNovoTime();
	
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
		//setModal(true);
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
		
		final JComboBox comboBoxTime1 = new JComboBox(listaTimes.toArray());
			comboBoxTime1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ComecarUtils.preencherTabela(tableTime1, (String)comboBoxTime1.getSelectedItem());
				}
			});
			lblEscolhaOTime1.setLabelFor(comboBoxTime1);
			comboBoxTime1.setBounds(118, 8, 306, 20);
			comboBoxTime1.setSelectedItem(null);
			contentPane.add(comboBoxTime1);
		
		JLabel lblEscolhaOTime2 = new JLabel("Escolha o time 2:");
			lblEscolhaOTime2.setBounds(10, 36, 96, 14);
			contentPane.add(lblEscolhaOTime2);
		
		final JComboBox comboBoxTime2 = new JComboBox(listaTimes.toArray());
			comboBoxTime2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ComecarUtils.preencherTabela(tableTime2, (String)comboBoxTime2.getSelectedItem());
				}
			});
			lblEscolhaOTime2.setLabelFor(comboBoxTime2);
			comboBoxTime2.setBounds(118, 33, 306, 20);
			comboBoxTime2.setSelectedItem(null);
			contentPane.add(comboBoxTime2);
		
		JButton btnComecarLuta = new JButton("Come\u00E7ar Luta");
		btnComecarLuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ComecarUtils.DefinirTimes((String)comboBoxTime1.getSelectedItem(), (String)comboBoxTime2.getSelectedItem()))	{
					dispose();
				}
			}
		});
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
					comboBoxTime1.setSelectedItem(null);
					comboBoxTime2.setSelectedItem(null);
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
			lblTime1.setLabelFor(tableTime1);
				scrollPaneTime1.setViewportView(tableTime1);
		
		JScrollPane scrollPaneTime2 = new JScrollPane();
			scrollPaneTime2.setBounds(223, 143, 201, 108);
			contentPane.add(scrollPaneTime2);
			
			tableTime2 = new JTable();
			lblTime2.setLabelFor(tableTime2);
				scrollPaneTime2.setViewportView(tableTime2);
				
		criarNovoTime.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				repopularComboboxes(comboBoxTime1, comboBoxTime2);
			}
		});
	}
	
	private void mostrarCriarNovoTime()	{
		criarNovoTime.setVisible(true);
	}
	
	private void repopularComboboxes(JComboBox comboBoxTime1, JComboBox comboBoxTime2)	{
		List<String> listaTimes = PersonagemControlador.ListaColunaDistinta("EQUIPE");
		comboBoxTime1.removeAllItems();
		comboBoxTime2.removeAllItems();
		for (String time : listaTimes) {
			comboBoxTime1.addItem(time);
		}
		for (String time : listaTimes) {
			comboBoxTime2.addItem(time);
		}
		comboBoxTime1.setSelectedItem(null);
		comboBoxTime2.setSelectedItem(null);
	}
	
}
