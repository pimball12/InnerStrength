package interfaces.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private JTable InfoTime1Per1;
	private JTable InfoTime1Per2;
	private JScrollPane scrollPane_1;
	private JTable InfoTime2Per1;
	private JScrollPane scrollPane_2;
	private JTable InfoTime2Per2;
	private JScrollPane scrollPane_3;
	private JTable tblInformacoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(253, 245, 230));
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 127, 154);
		frame.getContentPane().add(scrollPane);
		
		InfoTime1Per1 = new JTable();
		scrollPane.setViewportView(InfoTime1Per1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 176, 127, 154);
		frame.getContentPane().add(scrollPane_1);
		
		InfoTime1Per2 = new JTable();
		scrollPane_1.setViewportView(InfoTime1Per2);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(597, 11, 127, 154);
		frame.getContentPane().add(scrollPane_2);
		
		InfoTime2Per1 = new JTable();
		scrollPane_2.setViewportView(InfoTime2Per1);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(597, 177, 127, 154);
		frame.getContentPane().add(scrollPane_3);
		
		InfoTime2Per2 = new JTable();
		scrollPane_3.setViewportView(InfoTime2Per2);
		
		JPanel panel = new JPanel();
		panel.setBounds(147, 11, 127, 154);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel FotoTime1Per1 = new JLabel((String) null);
		FotoTime1Per1.setIcon(null);
		FotoTime1Per1.setBounds(0, 0, 127, 154);
		panel.add(FotoTime1Per1);
		FotoTime1Per1.setLabelFor(InfoTime1Per1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(147, 177, 127, 154);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel FotoTime1Per2 = new JLabel("");
		FotoTime1Per2.setBounds(0, 0, 127, 154);
		panel_1.add(FotoTime1Per2);
		FotoTime1Per2.setLabelFor(InfoTime1Per2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(460, 11, 127, 154);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel FotoTime2Per1 = new JLabel("");
		FotoTime2Per1.setBounds(0, 0, 127, 154);
		panel_2.add(FotoTime2Per1);
		FotoTime2Per1.setLabelFor(InfoTime2Per1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(460, 176, 127, 154);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel FotoTime2Per2 = new JLabel("");
		FotoTime2Per2.setBounds(0, 0, 127, 154);
		panel_3.add(FotoTime2Per2);
		FotoTime2Per2.setLabelFor(InfoTime2Per2);
		
		JRadioButton radioTime1Per1 = new JRadioButton("");
		radioTime1Per1.setBounds(278, 75, 21, 23);
		frame.getContentPane().add(radioTime1Per1);
		
		JRadioButton radioTime1Per2 = new JRadioButton("");
		radioTime1Per2.setBounds(278, 244, 21, 23);
		frame.getContentPane().add(radioTime1Per2);
		
		JRadioButton radioTime2Per1 = new JRadioButton("");
		radioTime2Per1.setBounds(434, 75, 21, 23);
		frame.getContentPane().add(radioTime2Per1);
		
		JRadioButton radioTime2Per2 = new JRadioButton("");
		radioTime2Per2.setBounds(434, 244, 21, 23);
		frame.getContentPane().add(radioTime2Per2);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.setBounds(305, 11, 123, 76);
		frame.getContentPane().add(btnAtacar);
		
		JButton btnMagia = new JButton("Lan\u00E7ar Magia");
		btnMagia.setBounds(305, 89, 123, 76);
		frame.getContentPane().add(btnMagia);
		
		JTextArea textAreaDisplay = new JTextArea();
		textAreaDisplay.setBackground(new Color(192, 192, 192));
		textAreaDisplay.setEnabled(false);
		textAreaDisplay.setBounds(10, 341, 724, 51);
		frame.getContentPane().add(textAreaDisplay);
		
		tblInformacoes = new JTable();
		tblInformacoes.setBackground(new Color(192, 192, 192));
		tblInformacoes.setBounds(305, 177, 123, 153);
		frame.getContentPane().add(tblInformacoes);
		
		JButton btnComecar = new JButton("Come\u00E7ar");
		btnComecar.setBounds(10, 403, 353, 48);
		frame.getContentPane().add(btnComecar);
		
		JButton btnPararLuta = new JButton("Parar Luta");
		btnPararLuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPararLuta.setBounds(373, 403, 351, 48);
		frame.getContentPane().add(btnPararLuta);
	}
}
