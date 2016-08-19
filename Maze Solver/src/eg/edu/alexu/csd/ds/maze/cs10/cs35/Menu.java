package eg.edu.alexu.csd.ds.maze.cs10.cs35;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Menu extends JFrame {
	JFrame window = new JFrame();
	private JPanel contentPane;
	private JTextField welcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu()throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		welcome = new JTextField();
		welcome.setBackground(Color.LIGHT_GRAY);
		welcome.setForeground(Color.RED);
		welcome.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 20));
		welcome.setText("WELCOME TO GAME MAZE SOLVER ! ! !");
		welcome.setBounds(140, 50, 466, 61);
		contentPane.add(welcome);
		welcome.setColumns(10);
		
		JButton b1 = new JButton("PLAY WITH LOADED MAZE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				window.dispose();
				Toolkit.getDefaultToolkit().beep();
				try {
					Graph3 x=new Graph3();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		b1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 17));
		b1.setForeground(Color.RED);
		b1.setBounds(220, 171, 299, 78);
		contentPane.add(b1);
		
		JButton b2 = new JButton("PLAY WITH RANDOM MAZE");
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Toolkit.getDefaultToolkit().beep();
				window.dispose();
				try {
					Graph4 x=new Graph4();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		b2.setFont(new Font("Curlz MT", Font.ITALIC, 19));
		b2.setForeground(Color.RED);
		b2.setBounds(220, 309, 299, 78);
		contentPane.add(b2);
	}
}
