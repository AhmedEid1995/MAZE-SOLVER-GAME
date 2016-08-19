package eg.edu.alexu.csd.ds.maze.cs10.cs35;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static int n=2,m=2,start_x,start_y,lucky_x,lucky_y;
	static char [] [] board ;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			UI();
			
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
	static void UI () throws IOException{
		System.out.println("WELCOME TO  MAZE SOLVER !!!");
		System.out.println("_____________________________");
		System.out.println("_____________________________");
		Scanner input =new Scanner(System.in);
		System.out.println("1) Play with loaded Maze ");
		System.out.println();
		System.out.println("2)Play with Random Maze ");
		System.out.println();
		System.out.println("3)How to play !!!");
		System.out.println();
		System.out.println("4)Exit !");
		int mode=input.nextInt();
		if(mode==1){
			readFile("maze.txt");
			PlayGame();
		}else if (mode ==2){
			CreateMaze x=new CreateMaze();
			x.GenerateMaze();
			readFile("createmaze.txt");
			PlayGame();
		}else if(mode ==3){
			Instructions();
		}else if (mode==4){
			System.exit(0); 
		}
	}
	static void PlayGame() throws IOException{
		
		GameMaze x=new GameMaze(board, n, m, start_x, start_y,lucky_x,lucky_y);
		for(int a=0;a<n;a++	){
			for(int b=0;b<m;b++){
				System.out.print(board[a][b]);
				System.out.print("  ");
			}
			System.out.println();
			System.out.println();
		}
		x.UserMovement();
		System.out.println("Do You want to see Solution ? (YES/NO)");
		Scanner scan =new Scanner(System.in);
		String s=scan.nextLine();
		if(s.equals("YES")){
			System.out.println("Do you want to see the solution using BFS or DFS ? (BFS/DFS)");
			String a=scan.nextLine();
			if(a.equals("BFS")){
				BFS xx=new BFS(board, n, m, start_x, start_y,  lucky_x, lucky_y);
				xx.ShortestPass();
				xx.print();
			}else if (a.equals("DFS")){
				DFS xx=new DFS(board, n, m, start_x, start_y,  lucky_x, lucky_y);
				xx.DFSPath();
				xx.PrintPath();
				xx.print();
			}else {
				System.out.println("ERROR !!");
			}
			UI();
		}else{
			UI();
		}
		
	}
	static void Instructions () throws IOException{
		System.out.println("Maze Slover Game ");
		System.out.println("The game is Find the path between 'S' and 'E' using four direction up/down /left/right ");
		System.out.println(", You can Move using Directions in Numbers keyboard 2----"
				+ "----> down , 4----->left , 6----->right,8---->up .");
		System.out.println("and there is Power Bouns '*' It can move You directly to '$' . There are two option one to play "
				+ "with Loaded maze ane other with Generating New Maze (Random).");
			System.out.println("After you will finish the game you can see the solution using two ways 1 )BFS (optimal solution 2)DFS "
				+ "And if You cant continue the game press 'S' for Solution . 	");
			UI();
	}
		

}
