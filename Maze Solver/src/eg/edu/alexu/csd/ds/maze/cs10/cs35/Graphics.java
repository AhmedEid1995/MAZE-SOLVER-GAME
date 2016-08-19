package eg.edu.alexu.csd.ds.maze.cs10.cs35;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.SystemColor;

import sun.audio.*;
public class Graphics {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphics window = new Graphics();
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
	public Graphics() {
		initialize();
		ImageIcon image1 = new ImageIcon(getClass().getResource("cover.png"));
		JLabel label1 = new JLabel(image1);
		label1.setForeground(Color.YELLOW);
		label1.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(label1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 800, 600);
		frame.setBackground(Color.green);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		//frame.setLayout(new BorderLayout());
		//frame.setContentPane(new JLabel(new ImageIcon("download.png")));
		frame.setLayout(new FlowLayout());
		
		JButton btnNewButton = new JButton("START !!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Toolkit.getDefaultToolkit().beep();
				Menu newWindow;
				try {
					newWindow = new Menu();
					newWindow.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Segoe Script", Font.ITALIC, 21));
		btnNewButton.setForeground(Color.RED);
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}
}
