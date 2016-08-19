package eg.edu.alexu.csd.ds.maze.cs10.cs35;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class SECONDRY extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static SECONDRY frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SECONDRY();
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
	public SECONDRY() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ImageIcon pic1=new ImageIcon(this.getClass().getResource("a.png"));
		//JLabe lblNewLabel = new JLabel(pic1);
		JLabel lblNewLabel1;
		JLabel lblNewLabel2;
		JLabel lblNewLabel3;
		JLabel lblNewLabel4;
		lblNewLabel1=new JLabel(pic1);
		lblNewLabel2=new JLabel(pic1);
		lblNewLabel3=new JLabel(pic1);
		lblNewLabel4=new JLabel(pic1);
			add(lblNewLabel1);
			add(lblNewLabel2);
			add(lblNewLabel3);
			add(lblNewLabel4);
			
			
		
			contentPane.setLayout(new GridLayout());
		
	}

}
