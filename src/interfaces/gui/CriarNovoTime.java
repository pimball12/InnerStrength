package interfaces.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import utils.CriarNovoTimeUtils;

public class CriarNovoTime extends JDialog {

	private JPanel contentPane;
	private JTextField textFieldNomeDoTime;
	private JTextField textFieldDanoNormal1;
	private JTextField textFieldDanoMagico1;
	private JTextField textFieldResistenciaNormal1;
	private JTextField textFieldResistenciaMagica1;
	private JTextField textFieldDanoNormal2;
	private JTextField textFieldDanoMagico2;
	private JTextField textFieldResistenciaNormal2;
	private JTextField textFieldResistenciaMagica2;
	private JComboBox<String[]> comboBoxPer1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarNovoTime frame = new CriarNovoTime();
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
	public CriarNovoTime() {
		String[] personagensProtagonistas = {"Guerreiro", "Atirador", "Conjurador"};
		String[] personagensAntagonistas  = {"Demonio", "MortoVivo", "Wookie"};
		
		setModal(true);
		setTitle("Criar Novo Time");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoTime = new JLabel("Nome do Time:");
			lblNomeDoTime.setBounds(10, 11, 84, 14);
			contentPane.add(lblNomeDoTime);
		
		textFieldNomeDoTime = new JTextField();
			lblNomeDoTime.setLabelFor(textFieldNomeDoTime);
			textFieldNomeDoTime.setBounds(104, 8, 320, 20);
			contentPane.add(textFieldNomeDoTime);
			textFieldNomeDoTime.setColumns(10);
		
		JLabel lblPersonagemProtagonista = new JLabel("Personagem Protagonista:");
			lblPersonagemProtagonista.setBounds(10, 36, 198, 14);
			contentPane.add(lblPersonagemProtagonista);
		
		JLabel lblPersonagemAntagonista = new JLabel("Personagem Antagonista:");
			lblPersonagemAntagonista.setBounds(218, 39, 206, 14);
			contentPane.add(lblPersonagemAntagonista);
		
		JScrollPane scrollPanePer1 = new JScrollPane();
			scrollPanePer1.setBounds(10, 269, 198, 102);
			contentPane.add(scrollPanePer1);
			
			final JTextPane txtpnPer1 = new JTextPane();
				scrollPanePer1.setViewportView(txtpnPer1);
					txtpnPer1.setEditable(false);
		
		JScrollPane scrollPanePer2 = new JScrollPane();
			scrollPanePer2.setBounds(218, 269, 206, 102);
			contentPane.add(scrollPanePer2);
		
			final JTextPane txtpnPer2 = new JTextPane();
				scrollPanePer2.setViewportView(txtpnPer2);
					txtpnPer2.setEditable(false);
		
		final JComboBox<String> comboBoxPer1 = new JComboBox(personagensProtagonistas);
			comboBoxPer1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CriarNovoTimeUtils.textoSelecao(comboBoxPer1.getSelectedItem(), txtpnPer1);
				}
			});
			comboBoxPer1.setToolTipText("Selecionar");
			lblPersonagemProtagonista.setLabelFor(comboBoxPer1);
			comboBoxPer1.setBounds(10, 61, 198, 20);
			comboBoxPer1.setSelectedItem(null);
			contentPane.add(comboBoxPer1);
		
		final JComboBox<String> comboBoxPer2 = new JComboBox(personagensAntagonistas);
			comboBoxPer2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CriarNovoTimeUtils.textoSelecao(comboBoxPer2.getSelectedItem(), txtpnPer2);
				}
			});
			comboBoxPer2.setToolTipText("Selecionar");
			lblPersonagemAntagonista.setLabelFor(comboBoxPer2);
			comboBoxPer2.setBounds(218, 61, 206, 20);
			comboBoxPer2.setSelectedItem(null);
			contentPane.add(comboBoxPer2);
		
		JLabel lblDanoNormal1 = new JLabel("Dano Normal:");
			lblDanoNormal1.setBounds(10, 144, 76, 14);
			contentPane.add(lblDanoNormal1);
		
		textFieldDanoNormal1 = new JTextField();
			lblDanoNormal1.setLabelFor(textFieldDanoNormal1);
			textFieldDanoNormal1.setBounds(134, 141, 74, 20);
			contentPane.add(textFieldDanoNormal1);
			textFieldDanoNormal1.setColumns(10);
		
		JLabel lblDanoMagico1 = new JLabel("Dano M\u00E1gico:");
			lblDanoMagico1.setBounds(10, 169, 76, 14);
			contentPane.add(lblDanoMagico1);
		
		textFieldDanoMagico1 = new JTextField();
			lblDanoMagico1.setLabelFor(textFieldDanoMagico1);
			textFieldDanoMagico1.setBounds(134, 166, 74, 20);
			contentPane.add(textFieldDanoMagico1);
			textFieldDanoMagico1.setColumns(10);
		
		JLabel lblResistnciaNormal = new JLabel("Resist\u00EAncia Normal:");
			lblResistnciaNormal.setBounds(10, 194, 114, 14);
			contentPane.add(lblResistnciaNormal);
		
		textFieldResistenciaNormal1 = new JTextField();
			lblResistnciaNormal.setLabelFor(textFieldResistenciaNormal1);
			textFieldResistenciaNormal1.setBounds(134, 191, 74, 20);
			contentPane.add(textFieldResistenciaNormal1);
			textFieldResistenciaNormal1.setColumns(10);
		
		JLabel lblResistenciaMagica = new JLabel("Resistencia Magica:");
			lblResistenciaMagica.setBounds(10, 219, 114, 14);
			contentPane.add(lblResistenciaMagica);
		
		textFieldResistenciaMagica1 = new JTextField();
			lblResistenciaMagica.setLabelFor(textFieldResistenciaMagica1);
			textFieldResistenciaMagica1.setBounds(134, 216, 74, 20);
			contentPane.add(textFieldResistenciaMagica1);
			textFieldResistenciaMagica1.setColumns(10);
		
		JLabel lblDanoNormal2 = new JLabel("Dano Normal:");
			lblDanoNormal2.setBounds(218, 147, 76, 14);
			contentPane.add(lblDanoNormal2);
		
		JLabel lblDanoMagico2 = new JLabel("Dano M\u00E1gico:");
			lblDanoMagico2.setBounds(218, 172, 76, 14);
			contentPane.add(lblDanoMagico2);
		
		JLabel lblResistênciaNormal2 = new JLabel("Resist\u00EAncia Normal:");
			lblResistênciaNormal2.setBounds(218, 197, 114, 14);
			contentPane.add(lblResistênciaNormal2);
		
		JLabel lolResistenciaMagica2 = new JLabel("Resistencia Magica:");
			lolResistenciaMagica2.setBounds(218, 222, 114, 14);
			contentPane.add(lolResistenciaMagica2);
		
		textFieldDanoNormal2 = new JTextField();
			lblDanoNormal2.setLabelFor(textFieldDanoNormal2);
			textFieldDanoNormal2.setColumns(10);
			textFieldDanoNormal2.setBounds(340, 141, 84, 20);
			contentPane.add(textFieldDanoNormal2);
		
		textFieldDanoMagico2 = new JTextField();
			lblDanoMagico2.setLabelFor(textFieldDanoMagico2);
			textFieldDanoMagico2.setColumns(10);
			textFieldDanoMagico2.setBounds(340, 166, 84, 20);
			contentPane.add(textFieldDanoMagico2);
		
		textFieldResistenciaNormal2 = new JTextField();
			lblResistênciaNormal2.setLabelFor(textFieldResistenciaNormal2);
			textFieldResistenciaNormal2.setColumns(10);
			textFieldResistenciaNormal2.setBounds(340, 191, 84, 20);
			contentPane.add(textFieldResistenciaNormal2);
		
		textFieldResistenciaMagica2 = new JTextField();
			lolResistenciaMagica2.setLabelFor(textFieldResistenciaMagica2);
			textFieldResistenciaMagica2.setColumns(10);
			textFieldResistenciaMagica2.setBounds(340, 216, 84, 20);
			contentPane.add(textFieldResistenciaMagica2);
		
		JLabel lblCaracteristicasDaClasse1 = new JLabel("Caracteristicas da Classe:");
			lblCaracteristicasDaClasse1.setBounds(10, 244, 198, 14);
			contentPane.add(lblCaracteristicasDaClasse1);
		
		JLabel lblCaracteristicasDaClasse2 = new JLabel("Caracteristicas da Classe:");
			lblCaracteristicasDaClasse2.setBounds(218, 244, 206, 14);
			contentPane.add(lblCaracteristicasDaClasse2);
		
		JButton btnCriar = new JButton("Criar");
			btnCriar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try	{
						if (CriarNovoTimeUtils.CriaTime( 
							(String)comboBoxPer1.getSelectedItem(), textFieldNomeDoTime.getText(), 
							Double.parseDouble(textFieldDanoNormal1.getText()) , Double.parseDouble(textFieldDanoMagico1.getText()),
							Double.parseDouble(textFieldResistenciaNormal1.getText()), Double.parseDouble(textFieldResistenciaMagica1.getText()),
							(String)comboBoxPer2.getSelectedItem(), textFieldNomeDoTime.getText(), 
							Double.parseDouble(textFieldDanoNormal2.getText()) , Double.parseDouble(textFieldDanoMagico2.getText()),
							Double.parseDouble(textFieldResistenciaNormal2.getText()), Double.parseDouble(textFieldResistenciaMagica2.getText()) ))	{
								limparCampos();
								dispose();
						}
					} catch(Exception ex)	{
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
					}
				}
			});
			btnCriar.setBounds(10, 382, 198, 46);
			contentPane.add(btnCriar);
		
		JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limparCampos();
					dispose();
				}
			});
			btnCancelar.setBounds(218, 382, 206, 46);
			contentPane.add(btnCancelar);
		
		JTextPane txtpnEscolhaOsAtributos = new JTextPane();
			txtpnEscolhaOsAtributos.setBackground(Color.WHITE);
			txtpnEscolhaOsAtributos.setEditable(false);
			txtpnEscolhaOsAtributos.setText("Escolha os atributos para seus personagens.\r\nVoc\u00EA tem at\u00E9 12 pontos para distribuir entre cada personagem.");
			txtpnEscolhaOsAtributos.setBounds(10, 92, 414, 38);
			txtpnEscolhaOsAtributos.setOpaque(false);
			contentPane.add(txtpnEscolhaOsAtributos);
	}
	
	public void limparCampos()	{
		textFieldNomeDoTime.setText("");
		textFieldDanoMagico1.setText("");
		textFieldDanoMagico2.setText("");
		textFieldDanoNormal1.setText("");
		textFieldDanoNormal2.setText("");
		textFieldResistenciaMagica1.setText("");
		textFieldResistenciaMagica2.setText("");
		textFieldResistenciaNormal1.setText("");
		textFieldResistenciaNormal2.setText("");
	}
}
