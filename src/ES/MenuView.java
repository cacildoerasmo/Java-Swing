package ES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class MenuView extends JFrame{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView window = new MenuView();
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
	public MenuView() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 139, 139));
		frame.setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.MAGENTA);
		frame.setBounds(100, 100, 640, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU CRUD");
		lblNewLabel.setBounds(244, 11, 250, 54);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CADASTRO ESTUDANTE");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setBounds(247, 94, 180, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
			    TelaEstudante n = new TelaEstudante();
			   
			    n.PrimeiroFrame.setVisible(true);
				n.PrimeiroFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					
	
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CADASTRO TURMA");
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setBounds(247, 149, 180, 36);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaTurma s = new TelaTurma();
				s.SegundoFrame.setVisible(true);
				s.SegundoFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
				
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SAIR");
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.setBounds(247, 207, 180, 36);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnNewButton_2);
	}
}
