package interfaces.gui;

import interfaces.funcionamento.Mensagens;
import interfaces.funcionamento.Rodada;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
import javax.swing.JTextPane;

public class Principal {

	private JFrame frmInnerStrenght;
	private JTable InfoTime1Per1;
	private JTable InfoTime1Per2;
	private JScrollPane scrollPaneTime1Per2;
	private JTable InfoTime2Per1;
	private JScrollPane scrollPaneTime2Per1;
	private JTable InfoTime2Per2;
	private JScrollPane scrollPaneTime2Per2;
	private Comecar comecar = new Comecar();
	private JLabel FotoTime1Per1;
	private JLabel FotoTime1Per2;
	private JLabel FotoTime2Per1;
	private JLabel FotoTime2Per2;
	private JButton btnAtacar;
	private JButton btnMagia;
	private JButton btnPararLuta;
	private Rodada rodada;
	private JTextPane Ocorrencias;
	private JTextPane Informacoes;
	private JScrollPane scrollPane;
	
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
			InfoTime1Per1.setEnabled(false);
			scrollPaneTime1Per1.setViewportView(InfoTime1Per1);
		
		scrollPaneTime1Per2 = new JScrollPane();
			scrollPaneTime1Per2.setBounds(10, 176, 127, 154);
			frmInnerStrenght.getContentPane().add(scrollPaneTime1Per2);
		
			InfoTime1Per2 = new JTable();
			InfoTime1Per2.setEnabled(false);
			scrollPaneTime1Per2.setViewportView(InfoTime1Per2);
		
		scrollPaneTime2Per1 = new JScrollPane();
			scrollPaneTime2Per1.setBounds(597, 11, 127, 154);
			frmInnerStrenght.getContentPane().add(scrollPaneTime2Per1);
		
			InfoTime2Per1 = new JTable();
			InfoTime2Per1.setEnabled(false);
			scrollPaneTime2Per1.setViewportView(InfoTime2Per1);
		
		scrollPaneTime2Per2 = new JScrollPane();
			scrollPaneTime2Per2.setBounds(597, 177, 127, 154);
			frmInnerStrenght.getContentPane().add(scrollPaneTime2Per2);
			
			InfoTime2Per2 = new JTable();
			InfoTime2Per2.setEnabled(false);
			scrollPaneTime2Per2.setViewportView(InfoTime2Per2);
		
		JPanel panelTime1Per1 = new JPanel();
			panelTime1Per1.setBounds(147, 11, 127, 154);
			frmInnerStrenght.getContentPane().add(panelTime1Per1);
			panelTime1Per1.setLayout(null);
		
			FotoTime1Per1 = new JLabel((""));
				FotoTime1Per1.setBounds(0, 0, 127, 154);
				panelTime1Per1.add(FotoTime1Per1);
				FotoTime1Per1.setLabelFor(InfoTime1Per1);
		
		JPanel panelTime1Per2 = new JPanel();
			panelTime1Per2.setBounds(147, 177, 127, 154);
			frmInnerStrenght.getContentPane().add(panelTime1Per2);
			panelTime1Per2.setLayout(null);
		
			FotoTime1Per2 = new JLabel("");
				FotoTime1Per2.setBounds(0, 0, 127, 154);
				panelTime1Per2.add(FotoTime1Per2);
				FotoTime1Per2.setLabelFor(InfoTime1Per2);
		
		JPanel panelTime2Per1 = new JPanel();
			panelTime2Per1.setBounds(460, 11, 127, 154);
			frmInnerStrenght.getContentPane().add(panelTime2Per1);
			panelTime2Per1.setLayout(null);
		
			FotoTime2Per1 = new JLabel("");
				FotoTime2Per1.setBounds(0, 0, 127, 154);
				panelTime2Per1.add(FotoTime2Per1);
				FotoTime2Per1.setLabelFor(InfoTime2Per1);
		
		JPanel panelTime2Per2 = new JPanel();
			panelTime2Per2.setBounds(460, 176, 127, 154);
			frmInnerStrenght.getContentPane().add(panelTime2Per2);
			panelTime2Per2.setLayout(null);
			
			FotoTime2Per2 = new JLabel("");
				FotoTime2Per2.setBounds(0, 0, 127, 154);
				panelTime2Per2.add(FotoTime2Per2);
				FotoTime2Per2.setLabelFor(InfoTime2Per2);
		
		final ButtonGroup RadioTime1 = new ButtonGroup();
		ButtonGroup RadioTime2 = new ButtonGroup();
				
		final JRadioButton radioTime1Per1 = new JRadioButton("");
		radioTime1Per1.setEnabled(false);
			radioTime1Per1.setBounds(278, 75, 21, 23);
			frmInnerStrenght.getContentPane().add(radioTime1Per1);
			RadioTime1.add(radioTime1Per1);
		
		final JRadioButton radioTime1Per2 = new JRadioButton("");
		radioTime1Per2.setEnabled(false);
			radioTime1Per2.setBounds(278, 244, 21, 23);
			frmInnerStrenght.getContentPane().add(radioTime1Per2);
			RadioTime1.add(radioTime1Per2);
		
		final JRadioButton radioTime2Per1 = new JRadioButton("");
		radioTime2Per1.setEnabled(false);
			radioTime2Per1.setBounds(434, 75, 21, 23);
			frmInnerStrenght.getContentPane().add(radioTime2Per1);
			RadioTime2.add(radioTime2Per1);
		
		final JRadioButton radioTime2Per2 = new JRadioButton("");
		radioTime2Per2.setEnabled(false);
			radioTime2Per2.setBounds(434, 244, 21, 23);
			frmInnerStrenght.getContentPane().add(radioTime2Per2);
			RadioTime2.add(radioTime2Per2);
		
		btnAtacar = new JButton("Atacar");
		btnAtacar.setEnabled(false);
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Atacar(radioTime1Per1, radioTime1Per2, radioTime2Per1, radioTime2Per2);
			}
		});
			btnAtacar.setBounds(305, 11, 123, 76);
			frmInnerStrenght.getContentPane().add(btnAtacar);
		
		btnMagia = new JButton("Lan\u00E7ar Magia");
		btnMagia.setEnabled(false);
		btnMagia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(Rodada.getProtagonista1().getClasse());
				System.out.println(Rodada.getProtagonista2().getClasse());
				System.out.println(Rodada.getAntagonista1().getClasse());
				System.out.println(Rodada.getAntagonista2().getClasse());
			}
		});
			btnMagia.setBounds(305, 89, 123, 76);
			frmInnerStrenght.getContentPane().add(btnMagia);
			Font fonte = new Font("Verdana", Font.BOLD, 12);
		
		JButton btnComecar = new JButton("Come\u00E7ar");
			btnComecar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarComecar();
				}
			});
			btnComecar.setBounds(10, 403, 238, 48);
			frmInnerStrenght.getContentPane().add(btnComecar);
		
		btnPararLuta = new JButton("Parar Luta");
		btnPararLuta.setEnabled(false);
			btnPararLuta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnPararLuta.setBounds(258, 403, 225, 48);
			frmInnerStrenght.getContentPane().add(btnPararLuta);
			
		JButton btnSair = new JButton("Sair");
			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnSair.setBounds(493, 403, 231, 48);
			frmInnerStrenght.getContentPane().add(btnSair);
		
		scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 341, 714, 48);
			frmInnerStrenght.getContentPane().add(scrollPane);
			
		Ocorrencias = new JTextPane();
		scrollPane.setViewportView(Ocorrencias);
		Ocorrencias.setEditable(false);
		
		Informacoes = new JTextPane();
		Informacoes.setEditable(false);
		Informacoes.setBounds(305, 176, 123, 154);
		frmInnerStrenght.getContentPane().add(Informacoes);
		
		comecar.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				if (Rodada.getAntagonista1() != null && Rodada.getAntagonista2() != null && Rodada.getProtagonista1() != null && Rodada.getProtagonista2() != null)	{
					PrincipalUtils.AdicionaFotos(Rodada.getProtagonista1(), Rodada.getProtagonista2(), Rodada.getAntagonista1(), Rodada.getAntagonista2(),
												 FotoTime1Per1, FotoTime2Per1, FotoTime1Per2, FotoTime2Per2);
					PrincipalUtils.AdicionaInformacoes(Rodada.getProtagonista1(),Rodada.getProtagonista2(),Rodada.getAntagonista1(), Rodada.getAntagonista2(),
													   InfoTime1Per1,InfoTime2Per1,InfoTime1Per2,InfoTime2Per2);
					Mensagens.setInformacoes("Rodada: "+Rodada.getRodadaAtual()+"\r\nVez de: "+Rodada.getAntagonista1().getEquipe());
					Mensagens.setOcorrencias("Novo Jogo: "+Rodada.getAntagonista1().getEquipe()+" X "+Rodada.getAntagonista2().getEquipe());
					Informacoes.setText(Mensagens.getInformacoes());
					Ocorrencias.setText(Mensagens.getOcorrencias());
					LiberaBotoes(radioTime1Per1, radioTime1Per2, radioTime2Per1, radioTime2Per2);
				}
			}
		});
		
	}
	
	private void mostrarComecar()	{
		comecar.setVisible(true);
	}
	
	private void Atacar(JRadioButton radioTime1Per1, JRadioButton radioTime1Per2, JRadioButton radioTime2Per1, JRadioButton radioTime2Per2)	{
		Rodada.Atacar(radioTime1Per1, radioTime1Per2, radioTime2Per1, radioTime2Per2);
		PrincipalUtils.AdicionaInformacoes(Rodada.getProtagonista1(),Rodada.getProtagonista2(),Rodada.getAntagonista1(), Rodada.getAntagonista2(),
					   InfoTime1Per1,InfoTime2Per1,InfoTime1Per2,InfoTime2Per2);
		Ocorrencias.setText(Mensagens.getOcorrencias());
		Informacoes.setText(Mensagens.getInformacoes());
		boolean resultado = Rodada.PassaRodada();
		if (resultado == true)	{
			BloqueaBotoes(radioTime1Per1, radioTime1Per2, radioTime2Per1, radioTime2Per2);
			FotoTime1Per1.setIcon(null);
			FotoTime1Per2.setIcon(null);
			FotoTime2Per1.setIcon(null);
			FotoTime2Per2.setIcon(null);
			PrincipalUtils.LimpaTabela(InfoTime1Per1);
			PrincipalUtils.LimpaTabela(InfoTime1Per2);
			PrincipalUtils.LimpaTabela(InfoTime2Per1);
			PrincipalUtils.LimpaTabela(InfoTime2Per2);
		}
	}
	
	private void LiberaBotoes(	JRadioButton radioTime1Per1, JRadioButton radioTime1Per2, JRadioButton radioTime2Per1, JRadioButton radioTime2Per2)	{
		radioTime1Per1.setEnabled(true);
		radioTime1Per2.setEnabled(true);
		radioTime2Per1.setEnabled(true);
		radioTime2Per2.setEnabled(true);
		btnAtacar.setEnabled(true);
		btnMagia.setEnabled(true);
		btnPararLuta.setEnabled(true);
	}
	
	private void BloqueaBotoes(	JRadioButton radioTime1Per1, JRadioButton radioTime1Per2, JRadioButton radioTime2Per1, JRadioButton radioTime2Per2)	{
		radioTime1Per1.setEnabled(false);
		radioTime1Per2.setEnabled(false);
		radioTime2Per1.setEnabled(false);
		radioTime2Per2.setEnabled(false);
		btnAtacar.setEnabled(false);
		btnMagia.setEnabled(false);
		btnPararLuta.setEnabled(false);
		Informacoes.setText(Mensagens.getInformacoes());
		Ocorrencias.setText(Mensagens.getOcorrencias());
	}
}
