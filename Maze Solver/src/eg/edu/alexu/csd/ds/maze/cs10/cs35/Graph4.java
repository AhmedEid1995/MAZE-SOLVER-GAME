package eg.edu.alexu.csd.ds.maze.cs10.cs35;


import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.ds.maze.cs10.cs35.Graph3.MyKeyHandler;

public class Graph4 extends JFrame {
	JFrame window = new JFrame();
	ImageIcon pic1=new ImageIcon(this.getClass().getResource("rabbit.png"));
	ImageIcon pic2=new ImageIcon(this.getClass().getResource("block.png"));
	ImageIcon pic3=new ImageIcon(this.getClass().getResource("foot2.png"));
	ImageIcon pic4=new ImageIcon(this.getClass().getResource("carrot.png"));
	ImageIcon pic5=new ImageIcon(this.getClass().getResource("hole.png"));
	ImageIcon pic6=new ImageIcon(this.getClass().getResource("green.png"));
	ImageIcon pic7=new ImageIcon(this.getClass().getResource("tree.png"));
	JMenuBar menupar;
	JMenu file;
	
	
	JMenuItem newgame;
	JMenuItem bfs;
	JMenuItem dfs;
	JMenuItem exit;
	char [][] NewBoard;
	 int n=6,m=6,start_x,start_y,lucky_x,lucky_y,movex,movey;
	 char [] [] board ;
	int x,y,boundry_x=6,boundry_y=6,last_x,last_y,lucky_xx,lucky_yy;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graph4 frame = new Graph4();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Graph4() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		menupar=new JMenuBar();
		
		
		file = new JMenu("File");
		menupar.add(file);
		
		
		newgame=new JMenuItem("Menu");
		newgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				window.dispose();
				Graphics x = null;
				try {
					x = new Graphics();
					x.initialize();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
			
			}
			
		});
		file.add(newgame);
		
		
		bfs =new JMenuItem("Solution With BFS");
		bfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BFS x=new BFS(board,n,m,start_x,start_y,lucky_x,lucky_y);
				x.ShortestPass();
				
				window.getContentPane().removeAll();
				window.repaint();
				print();
			
			}
			
		});
		dfs =new JMenuItem("Solution With DFS");
		dfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DFS x=new DFS(board,n,m,start_x,start_y,lucky_x,lucky_y);
				x.DFSPath();
				x.PrintPath();
				window.getContentPane().removeAll();
				window.repaint();
				print();
			
			}
			
		});
		file.add(bfs);
		file.add(dfs);
		
		exit =new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				window.dispose();
				System.exit(0);
				
				}
		});
		file.add(exit);
		
		
		window.setJMenuBar(menupar);
		
		window.setBounds(50, 50, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 725, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 447, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		CreateMaze x=new CreateMaze();
		x.GenerateMaze();
		readFile("createmaze.txt");
		print();
		
		window.addKeyListener( new MyKeyHandler() );
		
			
			
		
			
	}
	

	public String readFile(String fileName) throws IOException {
		   
		   try{
			   BufferedReader br = new BufferedReader(new FileReader(fileName));
			   try {
				   StringBuilder sb = new StringBuilder();
				   String line = br.readLine();
				   String []  arr=line.split(" ");
					n=Integer.parseInt(arr[0]);
					m=Integer.parseInt(arr[1]);
					boundry_x=n;boundry_y=m;
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

	void print (){
JLabel lblNewLabel1;
		
		for(int i=0;i<n;i++){
			
			for(int j=0;j<m;j++){
				if(board[i][j]=='#'){
					lblNewLabel1=new JLabel(pic2);
					window.getContentPane().add(lblNewLabel1);
				
				}else if(board[i][j]=='S'){
					lblNewLabel1=new JLabel(pic1);
					window.getContentPane().add(lblNewLabel1);	
					movex=i;movey=j;
				}else if (board[i][j]=='0'){
					lblNewLabel1=new JLabel(pic3);
					window.getContentPane().add(lblNewLabel1);
				
				}else if (board[i][j]=='E'){
					lblNewLabel1=new JLabel(pic4);
					window.getContentPane().add(lblNewLabel1);
				
				}else if (board[i][j]=='.'){
					lblNewLabel1=new JLabel(pic6);
					window.getContentPane().add(lblNewLabel1);
				
				}else if (board[i][j]=='*'){
					lblNewLabel1=new JLabel(pic5);
					window.getContentPane().add(lblNewLabel1);
				
				}else if (board[i][j]=='$'){
					lblNewLabel1=new JLabel(pic7);
					window.getContentPane().add(lblNewLabel1);
				
				}
			}
			window.getContentPane().setLayout(new GridLayout(n, m));
			window.setVisible(true);
	}
	}

	
	private class MyKeyHandler extends KeyAdapter{
	 
        public void keyPressed (KeyEvent theEvent){  
        	
        	switch (theEvent.getKeyCode()){
            case KeyEvent.VK_UP:
           	 	
           	 	if(movex-1>=0&&board[movex-1][movey]!='#'){
           	 		
           	 	if(board[movex-1][movey]=='E'){
           	 		
           	 		window.dispose();
       				Toolkit.getDefaultToolkit().beep();
       				winner x = null;
       				try {
							x = new winner();
							x.setVisible(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
           	 		//System.exit(0);	
           	 	}else{
           	 	window.getContentPane().removeAll();
					window.repaint();
					board[movex][movey]='0';
					if(board[movex-1][movey]=='*')board[lucky_x][lucky_y]='S';
					else board[movex-1][movey]='S';
					
					 print();
					 
           	 	}
           	 	}
           	 break;
           	 	
           	 	
            
            case KeyEvent.VK_DOWN:
           	 if(movex+1<boundry_x&&board[movex+1][movey]!='#'){
           		 if(board[movex+1][movey]=='E'){
           			 //System.exit(0);
           			 window.dispose();
        				Toolkit.getDefaultToolkit().beep();
        				winner x = null;
        				try {
							x = new winner();
							x.setVisible(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            	 		//System.exit(0);	
           		 }else{
           		 window.getContentPane().removeAll();
					window.repaint();
					board[movex][movey]='0';
					if(board[movex+1][movey]=='*')board[lucky_x][lucky_y]='S';
					else board[movex+1][movey]='S';
           		 print();
           		 }
           		
           	 }
           	 break;
            
            case KeyEvent.VK_LEFT:
           	 if(movey+1>0&&board[movex][movey-1]!='#'){
           		 if(board[movex][movey-1]=='E'){
           			 //System.exit(0);	
           			 window.dispose();
        				Toolkit.getDefaultToolkit().beep();
        				winner x = null;
        				try {
							x = new winner();
							x.setVisible(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            	 		//System.exit(0);	
           		 }else{
           			 window.getContentPane().removeAll();
 				   		 window.repaint();
 				   		 board[movex][movey]='0';
 				   		 if(board[movex][movey-1]=='*')board[lucky_x][lucky_y]='S';
 				   		 else board[movex][movey-1]='S';
 				   		 print();
           		 }
           		
           	 }
           	 break;
            
            case KeyEvent.VK_RIGHT:
           	 if(movey+1<boundry_y&&board[movex][movey+1]!='#'){
           		 if(board[movex][movey+1]=='E'){
           			 //System.exit(0);	
           			 window.dispose();
        				Toolkit.getDefaultToolkit().beep();
        				winner x = null;
        				try {
							x = new winner();
							x.setVisible(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            	 		//System.exit(0);	
           		 }else{
           			 window.getContentPane().removeAll();
 						 window.repaint();
 						 board[movex][movey]='0';
 						 if(board[movex][movey+1]=='*')board[lucky_x][lucky_y]='S';
 						 else board[movex][movey+1]='S';
 						 print();
           		 
           	 }
           	 }
           	 break;
            
          }
         
          
           
       }
   }



}