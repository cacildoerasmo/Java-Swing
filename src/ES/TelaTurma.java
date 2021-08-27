package ES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class TelaTurma {

	JFrame SegundoFrame;
	private JTextField textdescricao;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTurma window = new TelaTurma();
					window.SegundoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaTurma() {
		initialize();
		connection();
		processa();
	}

	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField textid;
	
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
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SegundoFrame = new JFrame();
		SegundoFrame.getContentPane().setBackground(new Color(0, 139, 139));
		SegundoFrame.setBounds(100, 100, 589, 306);
		SegundoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SegundoFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO TURMA");
		lblNewLabel.setFont(new Font("Swis721 Hv BT", Font.BOLD, 25));
		lblNewLabel.setBounds(153, 11, 269, 31);
		SegundoFrame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String descricao;
				
		
				descricao = textdescricao.getText();
				
				try {
					
					pst = conn.prepareStatement("insert into Turma(descricao) values(?)");
					pst.setString(1, descricao);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Turma Cadastrado!!!!");
					processa();
					
					textdescricao.setText("");
					textdescricao.requestFocus();
					
				}catch(SQLException e1) {
					System.err.println("Por Favor, Preencha o  o campo Correctamente!!!!");
				}
				
				
				
			}
		});
		btnNewButton.setBounds(10, 150, 81, 31);
		SegundoFrame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(345, 205, 15, -89);
		SegundoFrame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(472, 224, -84, -176);
		SegundoFrame.getContentPane().add(table_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 81, 287, 132);
		SegundoFrame.getContentPane().add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        String descricao,alterar;
				
				descricao = textdescricao.getText();
			    alterar = textid.getText();
				
				try {
					
					pst = conn.prepareStatement("update Turma set descricao=? where identificacao=?");
					pst.setString(1, descricao);
					pst.setString(2, alterar);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Turma Alterado!!!!");
					processa();
					
					textdescricao.setText("");
					textdescricao.requestFocus();
					
				}catch(SQLException e1) {
					System.err.println("Por Favor, Tente Novamente!!!!");
				}
				
				
			}
		});
		btnNewButton_1.setBounds(287, 224, 89, 31);
		SegundoFrame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Apagar");
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String apagar;
				
			      apagar = textid.getText();
				
				try {
					
					pst = conn.prepareStatement("delete from Turma where identificacao=?");
					pst.setString(1, apagar);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Turma Eliminado!!!!");
					processa();
					
					textid.setText("");
					textid.requestFocus();
					
				}catch(SQLException e1) {
					System.err.println("Por Favor, Insira os dados da Turma a ser eliminado!!!!");
				}
					
				
			}
		});
		btnNewButton_2.setBounds(386, 224, 89, 31);
		SegundoFrame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.setBackground(new Color(211, 211, 211));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    MenuView c = new MenuView();
			    SegundoFrame.dispose();
			    c.frame.setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(196, 150, 81, 31);
		SegundoFrame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Limpar");
		btnNewButton_4.setBackground(new Color(211, 211, 211));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textdescricao.setText("");
				textdescricao.requestFocus();
			}
		});
		btnNewButton_4.setBounds(105, 150, 77, 31);
		SegundoFrame.getContentPane().add(btnNewButton_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBorder(new TitledBorder(null, "Pesquisa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 203, 267, 52);
		SegundoFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("IDTurma");
		lblNewLabel_2.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 20, 94, 21);
		panel.add(lblNewLabel_2);
		
		textid = new JTextField();
		textid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String identificacao = textid.getText();
					pst = conn.prepareStatement("select descricao from Turma where identificacao=?");
					pst.setString(1, identificacao);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
						String descricao = rs.getString(1);
						
						textdescricao.setText(descricao);
						
							
					}else {
						textdescricao.setText("");
		
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
					
				}
				
				
			}
		});
		textid.setBounds(100, 20, 157, 22);
		panel.add(textid);
		textid.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBorder(new TitledBorder(null, "Cadastro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 79, 267, 60);
		SegundoFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textdescricao = new JTextField();
		textdescricao.setBounds(107, 22, 150, 27);
		panel_1.add(textdescricao);
		textdescricao.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descricao");
		lblNewLabel_1.setBounds(10, 21, 99, 23);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 15));
		
		JButton btnNewButton_5 = new JButton("Listar");
		btnNewButton_5.setBackground(new Color(211, 211, 211));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					pst = conn.prepareStatement("select * from Turma");
					rs = pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(SQLException e1) {
					System.err.println("ERRO!! Ao selecionar os dados na base de dados.");
				}
				
			}
		});
		btnNewButton_5.setBounds(485, 224, 89, 31);
		SegundoFrame.getContentPane().add(btnNewButton_5);
	}
}
