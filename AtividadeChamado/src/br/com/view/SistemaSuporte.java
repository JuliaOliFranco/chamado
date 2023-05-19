package br.com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.dao.CRUDChamado;
import br.com.dominio.Chamado;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class SistemaSuporte extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDepartamento;
	CRUDChamado cc = new CRUDChamado();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaSuporte frame = new SistemaSuporte();
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
	public SistemaSuporte() {
		setTitle("Sistema de Suporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 423);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(209, 221, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Preencha todos os campos para efetuar um chamado.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(169, 11, 369, 24);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(127, 137, 205, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Insira seu nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(127, 124, 252, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Data de abertura:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(375, 125, 123, 14);
		contentPane.add(lblNewLabel_4);
		
		MaskFormatter msf = null;
		try { msf = new MaskFormatter("##/##/####");}
		catch(Exception e) {e.printStackTrace();}
		JFormattedTextField txtDataAbertura = new JFormattedTextField(msf);
		txtDataAbertura.setBounds(375, 142, 112, 25);
		contentPane.add(txtDataAbertura);
		
		JLabel lblNewLabel_2 = new JLabel("Informe com qual departamento deseja falar:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(127, 57, 252, 14);
		contentPane.add(lblNewLabel_2);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(127, 72, 252, 30);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Conte-no mais sobre seu problema:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(127, 201, 225, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextPane txtDescricao = new JTextPane();
		txtDescricao.setBounds(127, 216, 387, 114);
		contentPane.add(txtDescricao);
		
		JLabel lblChamado = new JLabel("Chamado");
		lblChamado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chamado soliChamado = new Chamado(); 
				 
				if(txtNome.getText().trim().equals("") || 
				txtDepartamento.getText().trim().equals("") || 
				txtDescricao.getText().trim().equals("")) { 
				 JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro 4000765x" , JOptionPane.ERROR_MESSAGE); 
				} 
				else { 
				 
				soliChamado.setSolicitacao(txtNome.getText()); 
				 
				soliChamado.setDepSolicitado(txtDepartamento.getText()); 
				 
				soliChamado.setDescChamado(txtDescricao.getText()); 
				
				soliChamado.setDataAbertura(txtDataAbertura.getText());
				 
				 JOptionPane.showMessageDialog(null, cc.registrar(soliChamado)); 
				 
				} 
			}
		});
		lblChamado.setBounds(419, 341, 79, 32);
		contentPane.add(lblChamado);
		
		textField = new JTextField();
		textField.setBackground(new Color(64, 224, 208));
		textField.setBounds(0, 0, 86, 384);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
}
