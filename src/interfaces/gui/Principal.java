package interfaces.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import utils.PrincipalUtils;

public class Principal {

	private JFrame frmInnerStrenght;
	private JTable InfoTime1Per1;
	private JTable InfoTime1Per2;
	private JScrollPane scrollPaneTime1Per2;
	private JTable InfoTime2Per1;
	private JScrollPane scrollPaneTime2Per1;
	private JTable InfoTime2Per2;
	private JScrollPane scrollPaneTime2Per2;
	private JTable tblInformacoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmInnerStrenght.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		frmInnerStrenght = new JFrame();
		frmInnerStrenght.setTitle("Inner Strength");
		frmInnerStrenght.getContentPane().setBackground(new Color(253, 245, 230));
		frmInnerStrenght.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmInnerStrenght.setBounds(100, 100, 750, 500);
		frmInnerStrenght.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInnerStrenght.getContentPane().setLayout(null);
		
		JScrollPane scrollPaneTime1Per1 = new JScrollPane();
			scrollPaneTime1Per1.setBounds(10, 11, 127, 154);
			frmInnerStrenght.getContentPane().add(scrollPaneTime1Per1);
		
			InfoTime1Per1 = new JTable();
			scrollPaneTime1Per1.setViewportView(InfoTime1Per1);
		
		scrollPaneTime1Per2 = new JScrollPane();
			scrollPaneTime1Per2.setBounds(10, 176, 127, 154);
			frmInnerStrenght.getContentPane().add(scrollPaneTime1Per2);
		
			InfoTime1Per2 = new JTable();
			scrollPaneTime1Per2.setViewportView(InfoTime1Per2);
		
		scrollPaneTime2Per1 = new JScrollPane();
			scrollPaneTime2Per1.setBounds(597, 11, 127, 154);
			frmInnerStrenght.getContentPane().add(scrollPaneTime2Per1);
		
			InfoTime2Per1 = new JTable();
			scrollPaneTime2Per1.setViewportView(InfoTime2Per1);
		
		scrollPaneTime2Per2 = new JScrollPane();
			scrollPaneTime2Per2.setBounds(597, 177, 127, 154);
			frmInnerStrenght.getContentPane().add(scrollPaneTime2Per2);
			
			InfoTime2Per2 = new JTable();
			scrollPaneTime2Per2.setViewportView(InfoTime2Per2);
		
		JPanel panelTime1Per1 = new JPanel();
			panelTime1Per1.setBounds(147, 11, 127, 154);
			frmInnerStrenght.getContentPane().add(panelTime1Per1);
			panelTime1Per1.setLayout(null);
		
			JLabel FotoTime1Per1 = new JLabel((""));
				FotoTime1Per1.setBounds(0, 0, 127, 154);
				panelTime1Per1.add(FotoTime1Per1);
				FotoTime1Per1.setLabelFor(InfoTime1Per1);
		
		JPanel panelTime1Per2 = new JPanel();
			panelTime1Per2.setBounds(147, 177, 127, 154);
			frmInnerStrenght.getContentPane().add(panelTime1Per2);
			panelTime1Per2.setLayout(null);
		
			JLabel FotoTime1Per2 = new JLabel("");
				FotoTime1Per2.setBounds(0, 0, 127, 154);
				panelTime1Per2.add(FotoTime1Per2);
				FotoTime1Per2.setLabelFor(InfoTime1Per2);
		
		JPanel panelTime2Per1 = new JPanel();
			panelTime2Per1.setBounds(460, 11, 127, 154);
			frmInnerStrenght.getContentPane().add(panelTime2Per1);
			panelTime2Per1.setLayout(null);
		
			JLabel FotoTime2Per1 = new JLabel("");
				FotoTime2Per1.setBounds(0, 0, 127, 154);
				panelTime2Per1.add(FotoTime2Per1);
				FotoTime2Per1.setLabelFor(InfoTime2Per1);
		
		JPanel panelTime2Per2 = new JPanel();
			panelTime2Per2.setBounds(460, 176, 127, 154);
			frmInnerStrenght.getContentPane().add(panelTime2Per2);
			panelTime2Per2.setLayout(null);
			
			JLabel FotoTime2Per2 = new JLabel("");
				FotoTime2Per2.setBounds(0, 0, 127, 154);
				panelTime2Per2.add(FotoTime2Per2);
				FotoTime2Per2.setLabelFor(InfoTime2Per2);
		
		ButtonGroup RadioTime1 = new ButtonGroup();
		ButtonGroup RadioTime2 = new ButtonGroup();
				
		JRadioButton radioTime1Per1 = new JRadioButton("");
			radioTime1Per1.setBounds(278, 75, 21, 23);
			frmInnerStrenght.getContentPane().add(radioTime1Per1);
			RadioTime1.add(radioTime1Per1);
		
		JRadioButton radioTime1Per2 = new JRadioButton("");
			radioTime1Per2.setBounds(278, 244, 21, 23);
			frmInnerStrenght.getContentPane().add(radioTime1Per2);
			RadioTime1.add(radioTime1Per2);
		
		JRadioButton radioTime2Per1 = new JRadioButton("");
			radioTime2Per1.setBounds(434, 75, 21, 23);
			frmInnerStrenght.getContentPane().add(radioTime2Per1);
			RadioTime2.add(radioTime2Per1);
		
		JRadioButton radioTime2Per2 = new JRadioButton("");
			radioTime2Per2.setBounds(434, 244, 21, 23);
			frmInnerStrenght.getContentPane().add(radioTime2Per2);
			RadioTime2.add(radioTime2Per2);
		
		JButton btnAtacar = new JButton("Atacar");
			btnAtacar.setBounds(305, 11, 123, 76);
			frmInnerStrenght.getContentPane().add(btnAtacar);
		
		JButton btnMagia = new JButton("Lan\u00E7ar Magia");
			btnMagia.setBounds(305, 89, 123, 76);
			frmInnerStrenght.getContentPane().add(btnMagia);
		
		JTextArea textAreaDisplay = new JTextArea();
			textAreaDisplay.setBackground(new Color(192, 192, 192));
			textAreaDisplay.setEnabled(false);
			textAreaDisplay.setBounds(10, 341, 714, 51);
			frmInnerStrenght.getContentPane().add(textAreaDisplay);
		
		tblInformacoes = new JTable();
			tblInformacoes.setBackground(new Color(192, 192, 192));
			tblInformacoes.setBounds(305, 177, 123, 153);
			frmInnerStrenght.getContentPane().add(tblInformacoes);
		
		JButton btnComecar = new JButton("Come\u00E7ar");
			btnComecar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarComecar();
				}
			});
			btnComecar.setBounds(10, 403, 238, 48);
			frmInnerStrenght.getContentPane().add(btnComecar);
		
		JButton btnPararLuta = new JButton("Parar Luta");
			btnPararLuta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnPararLuta.setBounds(258, 403, 225, 48);
			frmInnerStrenght.getContentPane().add(btnPararLuta);
			
		JButton btnSair = new JButton("Sair");
			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PrincipalUtils.Sair();
				}
			});
			btnSair.setBounds(493, 403, 225, 48);
			frmInnerStrenght.getContentPane().add(btnSair);
	}
	
	Comecar comecar;
	
	private void mostrarComecar()	{
		if (comecar == null)	{
			comecar = new Comecar();
			comecar.setVisible(true);
		} else {
			comecar.setVisible(true);
		}
	}
}
