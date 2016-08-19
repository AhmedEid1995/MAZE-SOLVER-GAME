package eg.edu.alexu.csd.ds.maze.cs10.cs35;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class CreateMaze {
	int n=20,m=20;
	char [][] board =new char [20][20];
	Random rand = new Random();
	void GenerateMaze(){
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				board[i][j]='.';
			}
		}
		
		int start_x =0;
		int start_y = rand.nextInt((15 - 1) + 1) +1;
		board[start_x][start_y]='S';
		int end_x = 19;
		int end_y = rand.nextInt((18 - 1) + 1) +1;
		board[end_x][end_y]='E';
		board[19][end_y-1]='#';
		board[18][end_y]='#';
		int lucky_x$ = rand.nextInt((17 -2) + 1) +2;
		int lucky_y$ = rand.nextInt((18 - 1) + 1) +1;
		board[lucky_x$][lucky_y$]='$';
		board[lucky_x$][lucky_y$+1]='#';
		board[lucky_x$-1][lucky_y$]='#';
		int lucky_input_x = rand.nextInt((17 - 2) + 1) +2;
		int lucky_input_y = rand.nextInt((18 - 1) + 1) +1;
		while(board[lucky_input_x][lucky_input_y]=='$'){
			lucky_input_x = rand.nextInt((17 - 2) + 1) +2;
			lucky_input_y = rand.nextInt((18 - 1) + 1) +1;
		}
		board[lucky_input_x][lucky_input_y]='*';
		board[lucky_input_x+1][lucky_input_y]='#';
		board[lucky_input_x-1][lucky_input_y]='#';
		BFS x=new BFS(board,n,m,start_x,start_y,lucky_x$,lucky_y$);
		x.ShortestPass();
		board[end_x][end_y]='#';
		board[lucky_input_x][lucky_input_y]='E';
		
		
		
		BFS xx=new BFS(board,n,m,start_x,start_y,lucky_x$,lucky_y$);
		xx.ShortestPass();
		board[end_x][end_y]='E';
		board[lucky_input_x][lucky_input_y]='*';
		BFS xxx=new BFS(board,n,m,lucky_x$,lucky_y$,lucky_x$,lucky_y$);
		xxx.ShortestPass();
		board[end_x][end_y]='#';
		board[lucky_input_x][lucky_input_y]='E';
		BFS y=new BFS(board,n,m,lucky_x$,lucky_y$,lucky_x$,lucky_y$);
		y.ShortestPass();
		board[lucky_input_x][lucky_input_y]='*';
		board[end_x][end_y]='E';
		
		BFS yy=new BFS(board,n,m,0,0,lucky_x$,lucky_y$);
		yy.ShortestPass();
		
		BFS yyy=new BFS(board,n,m,10,8,lucky_x$,lucky_y$);
		yyy.ShortestPass();
		
		BFS yyyy=new BFS(board,n,m,4,3,lucky_x$,lucky_y$);
		yyyy.ShortestPass();
		BFS q=new BFS(board,n,m,5,19,lucky_x$,lucky_y$);
		q.ShortestPass();
		board[end_x][end_y]='#';
		board[lucky_x$][lucky_y$]='E';
		
		BFS qq=new BFS(board,n,m,5,19,lucky_x$,lucky_y$);
		qq.ShortestPass();
		board[end_x][end_y]='E';
		board[lucky_x$][lucky_y$]='$';
		board[end_x][end_y]='#';
		board[5][19]='E';

		BFS qqq=new BFS(board,n,m,start_x,start_y,lucky_x$,lucky_y$);
		qqq.ShortestPass();
		board[end_x][end_y]='E';
		board[5][19]='0';
		
		BFS a=new BFS(board,n,m,6,6,lucky_x$,lucky_y$);
		a.ShortestPass();
		
		board[end_x][end_y]='#';
		board[6][6]='E';
		
		BFS aa=new BFS(board,n,m,start_x,start_y,lucky_x$,lucky_y$);
		aa.ShortestPass();
		board[end_x][end_y]='E';
		board[6][6]='0';
		
		board[end_x][end_y]='#';
		board[10][0]='E';
		
		BFS aaa=new BFS(board,n,m,lucky_x$,lucky_y$,lucky_x$,lucky_y$);
		aaa.ShortestPass();
		board[end_x][end_y]='E';
		board[10][0]='0';
		board[end_x][end_y]='#';
		board[4][19]='E';

		BFS e=new BFS(board,n,m,start_x,start_y,lucky_x$,lucky_y$);
		e.ShortestPass();
		
		board[end_x][end_y]='E';
		board[4][19]='0';
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(board[i][j]=='.'){
					board[i][j]='#';
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(board[i][j]=='0'){
					board[i][j]='.';
				}
			}
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("createmaze.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		writer.println(n+" "+m);
		for(int i=0;i<n;i++){
			writer.println(board[i]);
		}
		writer.close();
	}

}