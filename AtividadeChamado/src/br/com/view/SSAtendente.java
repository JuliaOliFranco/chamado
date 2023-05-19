package br.com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class SSAtendente extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtResponsavel;
	CRUDChamado cc = new CRUDChamado();
	private JFormattedTextField txtDataResolucao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SSAtendente frame = new SSAtendente();
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
	public SSAtendente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(209, 221, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID do Chamado:");
		lblNewLabel.setBounds(53, 32, 96, 14);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(22, 47, 158, 27);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Status Chamado:");
		lblNewLabel_1.setBounds(237, 32, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de resolução do Chamado:");
		lblNewLabel_2.setBounds(22, 120, 189, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox cboStatus = new JComboBox();
		cboStatus.setModel(new DefaultComboBoxModel(new String[] {"Em Aberto", "Resolvido", "Pendente"}));
		cboStatus.setBounds(207, 49, 158, 27);
		contentPane.add(cboStatus);
		
		JLabel lblNewLabel_3 = new JLabel("Responsável do Chamado:");
		lblNewLabel_3.setBounds(221, 120, 158, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Observações:");
		lblNewLabel_4.setBounds(156, 202, 87, 14);
		contentPane.add(lblNewLabel_4);
		
		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(207, 134, 158, 27);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(10);
		
		JTextPane txtObservacoes = new JTextPane();
		txtObservacoes.setBounds(22, 217, 343, 183);
		contentPane.add(txtObservacoes);
		
		JLabel lblAtualizarChamado = new JLabel("Atualizar Chamados");
		lblAtualizarChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chamado cr = new Chamado(); 
				 
				if(txtResponsavel.getText().trim().equals("") || cboStatus.getSelectedItem().equals("") || 
				txtId.getText().trim().equals("") || txtDataResolucao.getText().trim().equals("")) {
				 JOptionPane.showMessageDialog(null, "Os campos Responsável Chamado, Id do Chamado, Status do Chamado e Data de Resolução devem ser preenchidos", "Erro 4000765x" , JOptionPane.ERROR_MESSAGE); 
				} 
				else { 
				 
				 cr.setDataResolucao(String.valueOf(txtDataResolucao.getText())); 
				cr.setStatusChamado(cboStatus.getSelectedItem().toString()); 
				cr.setAtendente(txtResponsavel.getText()); 
				cr.setObservacoes(txtObservacoes.getText()); 
				cr.setIdChamado(Long.parseLong(txtId.getText()));
				cc.atualizar(cr);
				 JOptionPane.showMessageDialog(null, "Chamado atualizado!"); 
				}
			}
		});
		lblAtualizarChamado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAtualizarChamado.setBounds(412, 290, 151, 14);
		contentPane.add(lblAtualizarChamado);
		
		JLabel lblNewLabel_5 = new JLabel("Excluir Chamados");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtId.equals(null)) { 
					JOptionPane.showMessageDialog(null,"Selecione o chamado a ser excluído.","Erro 4000770x",JOptionPane.ERROR_MESSAGE); 
					} 
					else { 
					if(JOptionPane.showConfirmDialog(null, "Você tem certeza desta ação? \nEstá ação é permanente "+ "e não pode ser desfeita", "ATENÇÃO", JOptionPane.YES_NO_OPTION, 
					 JOptionPane.QUESTION_MESSAGE) == 0) { 
					Chamado cr = new Chamado(); 
					cr.setIdChamado(Long.parseLong(txtId.getText())); 
					JOptionPane.showMessageDialog(null, "Chamado excluido!"); 
					}
				}
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(419, 349, 129, 14);
		contentPane.add(lblNewLabel_5);
		
		MaskFormatter msf = null;
		try { msf = new MaskFormatter("##/##/####");}
		catch(Exception e) {e.printStackTrace();}
		txtDataResolucao = new JFormattedTextField(msf);
		txtDataResolucao.setBounds(22, 134, 158, 27);
		contentPane.add(txtDataResolucao);
		
		
	}
}
