package eg.edu.alexu.csd.ds.maze.cs10.cs35;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Graph1 extends JFrame {
	static char [][] NewBoard;
	static int n=2,m=2,start_x,start_y,lucky_x,lucky_y;
	static char [] [] board ;	
	int x,y;
	static int boundry_x=20;
	static int boundry_y=20;
	int last_x;
	int last_y;
	int lucky_xx;
	int lucky_yy;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Graph1 frame = new Graph1();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Graph1() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ImageIcon pic1=new ImageIcon(this.getClass().getResource("rabbit.png"));
		ImageIcon pic2=new ImageIcon(this.getClass().getResource("block.png"));
		ImageIcon pic3=new ImageIcon(this.getClass().getResource("foot2.png"));
		ImageIcon pic4=new ImageIcon(this.getClass().getResource("carrot.png"));
		ImageIcon pic5=new ImageIcon(this.getClass().getResource("hole.png"));
		ImageIcon pic6=new ImageIcon(this.getClass().getResource("green.png"));
		JFrame window = new JFrame();
		readFile("maze.txt");
		BFS xx=new BFS(board, n, m, start_x, start_y,  lucky_x, lucky_y);
		xx.ShortestPass();
		 NewBoard =xx.print();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 800, 600);

		
		JLabel lblNewLabel1;
		
		for(int i=0;i<n;i++){
			
			for(int j=0;j<m;j++){
				if(NewBoard[i][j]=='#'){
					lblNewLabel1=new JLabel(pic2);
					window.add(lblNewLabel1);
				
				}else if(NewBoard[i][j]=='S'){
					lblNewLabel1=new JLabel(pic1);
					window.add(lblNewLabel1);				
				}else if (NewBoard[i][j]=='0'){
					lblNewLabel1=new JLabel(pic3);
					window.add(lblNewLabel1);
				
				}else if (NewBoard[i][j]=='E'){
					lblNewLabel1=new JLabel(pic4);
					window.add(lblNewLabel1);
				
				}else if (NewBoard[i][j]=='.'){
					lblNewLabel1=new JLabel(pic6);
					window.add(lblNewLabel1);
				
				}else if (NewBoard[i][j]=='*'||NewBoard[i][j]=='$'){
					lblNewLabel1=new JLabel(pic5);
					window.add(lblNewLabel1);
				
				}
			}
			window.setLayout(new GridLayout(n, m));
			window.setVisible(true);
		}
	/*	for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				
			}
		}*/
		
		
	}
	static String readFile(String fileName) throws IOException {
		   
		   try{
			   BufferedReader br = new BufferedReader(new FileReader(fileName));
			   try {
				   StringBuilder sb = new StringBuilder();
				   String line = br.readLine();
				   String []  arr=line.split(" ");
					n=Integer.parseInt(arr[0]);
					m=Integer.parseInt(arr[1]);
					boundry_x=n;
					boundry_y=m	;
					board=new char[n][m];
				   line = br.readLine();
					int i=0;
					while (line != null) {
					   for(int j=0;j<m;j++){
						   board[i][j]=line.charAt(j);
						   if(board[i][j]=='S'){
							   start_x=i;
							   start_y=j;
						   }else if(board[i][j]=='$'){
							   lucky_x=i;
							   lucky_y=j;
						   }
					   }
					   i++;
					   sb.append(line);
					   //sb.append(",");
					   line = br.readLine();
				   }
				   return sb.toString();
			   } finally {
				   br.close();
			   }
		   }catch(FileNotFoundException  e){
			   System.out.println("ERROR! ");
			   return null;
		   }
		}

}
