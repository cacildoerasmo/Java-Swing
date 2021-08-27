package ES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaEstudante extends JDialog{

	JFrame PrimeiroFrame;
	private JTextField textnome;
	private JTextField textapelido;
	private JTextField texttelefone;
	private JTextField textendereco;
	private JTextField textid;
	private JTextField textmatricula;
	private JTable table;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstudante window = new TelaEstudante();
					window.PrimeiroFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaEstudante() {
		initialize();
		 connection();
		 processa();
	}
	
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	
	public void connection() {
		
		
		try {
	
		
			Class.forName("org.gjt.mm.mysql.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/faculdade", "root", "");

		
			}catch(ClassNotFoundException ex) {
				ex.printStackTrace();
				
			}
		catch(SQLException ex) {
			System.err.println("ERRO!!! Ao conectar com a base de dados.");
		}


	}
	
	public void processa() {
	
	}
	
	

	private void initialize() {
		PrimeiroFrame = new JFrame();
		PrimeiroFrame.getContentPane().setBackground(new Color(0, 139, 139));
		PrimeiroFrame.setBounds(100, 100, 1012, 508);
		PrimeiroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PrimeiroFrame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("CADASTRO ESTUDANTE");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 41));
		lblNewLabel.setBounds(337, 11, 406, 69);
		PrimeiroFrame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBorder(new TitledBorder(null, "CADASTRO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 85, 374, 237);
		PrimeiroFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 59, 122, 39);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Apelido");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 99, 122, 39);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telefone");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(10, 141, 122, 39);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Endereco");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(10, 183, 122, 39);
		panel.add(lblNewLabel_1_5);
		
		textnome = new JTextField();
		textnome.setColumns(10);
		textnome.setBounds(142, 67, 205, 27);
		panel.add(textnome);
		
		textapelido = new JTextField();
		textapelido.setColumns(10);
		textapelido.setBounds(142, 105, 205, 31);
		panel.add(textapelido);
		
		texttelefone = new JTextField();
		texttelefone.setColumns(10);
		texttelefone.setBounds(142, 147, 205, 31);
		panel.add(texttelefone);
		
		textendereco = new JTextField();
		textendereco.setColumns(10);
		textendereco.setBounds(142, 189, 205, 31);
		panel.add(textendereco);
		
		textid = new JTextField();
		textid.setColumns(10);
		textid.setBounds(142, 29, 205, 27);
		panel.add(textid);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("IDTurma");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(10, 21, 122, 39);
		panel.add(lblNewLabel_1_2_1);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String fk_identificacao_turma,nome,apelido,telefone,endereco;
			
			fk_identificacao_turma = textid.getText();
			nome = textnome.getText();
			apelido = textapelido.getText();
			telefone = texttelefone.getText();
			endereco = textendereco.getText();
			
			try {
				
				pst = conn.prepareStatement("insert into Estudante(fk_identificacao_turma,nome,apelido,telefone,endereco) values(?,?,?,?,?)");
				pst.setString(1, fk_identificacao_turma);
				pst.setString(2, nome);
				pst.setString(3, apelido);
				pst.setString(4, telefone);
				pst.setString(5, endereco);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Estudante Cadastrado!!!!");
				processa();
				
				textid.setText("");
				textnome.setText("");
				textapelido.setText("");
				texttelefone.setText("");
				textendereco.setText("");
				textid.requestFocus();
				
			}catch(SQLException e1) {
				System.err.println("Por Favor, Preencha Todos os campos Correctamente!!!!");
			}
			
			
			
				
				
				
				
			}
		});
		btnNewButton.setBounds(22, 333, 98, 37);
		PrimeiroFrame.getContentPane().add(btnNewButton);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.setBackground(new Color(211, 211, 211));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		    MenuView c = new MenuView();
		    PrimeiroFrame.dispose();
		    c.frame.setVisible(false);
		    
		
			}
		});
		btnSair.setBounds(238, 333, 98, 37);
		PrimeiroFrame.getContentPane().add(btnSair);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color(211, 211, 211));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textid.setText("");
				textnome.setText("");
				textapelido.setText("");
				texttelefone.setText("");
				textendereco.setText("");
				textid.requestFocus();
				
				
			}
		});
		btnLimpar.setBounds(130, 333, 98, 37);
		PrimeiroFrame.getContentPane().add(btnLimpar);
		
		JScrollPane tabela = new JScrollPane();
		tabela.setBounds(406, 91, 588, 300);
		PrimeiroFrame.getContentPane().add(tabela);
		
		table = new JTable();
		tabela.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBorder(new TitledBorder(null, "Pesquisa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(22, 381, 314, 69);
		PrimeiroFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("IDMatricula");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5_1.setBounds(10, 19, 122, 39);
		panel_1.add(lblNewLabel_1_5_1);
		
		textmatricula = new JTextField();
		textmatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String numero_matricula = textmatricula.getText();
					pst = conn.prepareStatement("select fk_identificacao_turma,nome,apelido,telefone,endereco from Estudante where numero_matricula=?");
					pst.setString(1, numero_matricula);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
						String fk_identificacao_turma = rs.getString(1);
						String nome = rs.getString(2);
						String apelido = rs.getString(3);
						String telefone = rs.getString(4);
						String endereco = rs.getString(5);
						
						textid.setText(fk_identificacao_turma);
						textnome.setText(nome);
						textapelido.setText(apelido);
						texttelefone.setText(telefone);
						textendereco.setText(endereco);
						
							
					}else {
						textid.setText("");
						textnome.setText("");
						textapelido.setText("");
						texttelefone.setText("");
						textendereco.setText("");
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
					
				}
				
				
				
				
				
			}
		});
		textmatricula.setColumns(10);
		textmatricula.setBounds(99, 25, 205, 31);
		panel_1.add(textmatricula);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(211, 211, 211));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fk_identificacao_turma,nome,apelido,telefone,endereco,btnAlterar;
				
				fk_identificacao_turma = textid.getText();
				nome = textnome.getText();
				apelido = textapelido.getText();
				telefone = texttelefone.getText();
				endereco = textendereco.getText();
				btnAlterar = textmatricula.getText();
				
				try {
					
					pst = conn.prepareStatement("update Estudante set fk_identificacao_turma=?,nome=?,apelido=?,telefone=?,endereco=? where numero_matricula=?");
					pst.setString(1, fk_identificacao_turma);
					pst.setString(2, nome);
					pst.setString(3, apelido);
					pst.setString(4, telefone);
					pst.setString(5, endereco);
					pst.setString(6, btnAlterar);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Estudante Alterado!!!!");
					processa();
					
					textid.setText("");
					textnome.setText("");
					textapelido.setText("");
					texttelefone.setText("");
					textendereco.setText("");
					textid.requestFocus();
					
				}catch(SQLException e1) {
					System.err.println("Por Favor, Preencha Todos os campos Correctamente!!!!");
				}
				
				
				
					
				
				
				
				
				
				
			}
		});
		btnAlterar.setBounds(406, 402, 98, 37);
		PrimeiroFrame.getContentPane().add(btnAlterar);
		
		JButton btnLimpar_2 = new JButton("Apagar");
		btnLimpar_2.setBackground(new Color(211, 211, 211));
		btnLimpar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String btnAlterar;
				
				btnAlterar = textmatricula.getText();
				
				try {
					
					pst = conn.prepareStatement("delete from Estudante where numero_matricula=?");
					pst.setString(1, btnAlterar);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Estudante Eliminado!!!!");
					processa();
					
					textid.setText("");
					textnome.setText("");
					textapelido.setText("");
					texttelefone.setText("");
					textendereco.setText("");
					textid.requestFocus();
					
				}catch(SQLException e1) {
					System.err.println("Por Favor, Insira os dados do estudante a ser eliminado!!!!");
				}
						
			}
		});
		btnLimpar_2.setBounds(514, 402, 98, 37);
		PrimeiroFrame.getContentPane().add(btnLimpar_2);
		
		JButton btnNewButton_1 = new JButton("Listar");
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					pst = conn.prepareStatement("select Estudante.numero_matricula, Estudante.fk_identificacao_turma, Estudante.nome, Estudante.apelido, Estudante.telefone, Estudante.endereco, Turma.descricao from Estudante join Turma on Turma.identificacao = Estudante.fk_identificacao_turma order by Estudante.numero_matricula");
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(SQLException e1) {
					System.err.println("ERRO!! Ao selecionar os dados na base de dados.");
				}
				
			}
		});
		btnNewButton_1.setBounds(624, 402, 89, 37);
		PrimeiroFrame.getContentPane().add(btnNewButton_1);
	}
}
