package eg.edu.alexu.csd.ds.maze.cs10.cs35;

import Implementation.Implementation;
import Implementation.Stack;


public class DFS {
	char [] [] board ;
	boolean [][]visited;
	int start_x,start_y,x,y,boundry_x,boundry_y,last_x,last_y,lucky_xx,lucky_yy;
	DFS(char arr[] [],int n,int m,int row,int col,int lucky_x,int lucky_y){
		board=new char [n][m];
		visited=new boolean[n][m];
		board=arr;
		start_x=row;
		start_y=col;
		x=row;
		y=col;
		boundry_x=n;
		boundry_y=m;
		last_x=row;
		last_y=col;
		lucky_xx=lucky_x;
		lucky_yy=lucky_y;
		//State last=new State(last_x,last_y);
	}
	
	Object [][] path = new Object [100][100];
	void DFSPath(){
		State New , way;
		Implementation s = new Stack();
		
		State a=new State(x,y,null);
		s.push(a);
		visited[x][y]=true;
		while(!s.isEmpty()){
			State temp=(State) s.pop();
			x=temp.row;
			y=temp.col;
			if(board[x][y]=='*'){
				visited[x][y]=true;
				New=new State(lucky_xx,lucky_yy,null);
				s.push(New);
				way = new State(x,y,null);
				path[lucky_xx][lucky_yy]=way;
				last_x=x;
				last_y=y;
			}
			else{
			if(!visited[x][y]&&board[x][y]=='E'){
				way = new State (last_x,last_y,null);
				path[x][y]=way;
				break;
			}
			visited[x][y]=true;
			if(y+1>=0&&y+1<boundry_y&&board[x][y+1]!='#'&&!visited[x][y+1]){
				New=new State(x,y+1,null);
				s.push(New);
				way = new State(x,y,null);
				path[x][y+1]=way;
				last_x=x;
				last_y=y;
			}
			if(y-1>=0&&y-1<boundry_y&&board[x][y-1]!='#'&&!visited[x][y-1]){
				New=new State(x,y-1,null);
				s.push(New);
				way = new State(x,y,null);
				path[x][y-1]=way;
				last_x=x;
				last_y=y;
			}
			if(x-1>=0&&board[x-1][y]!='#'&&!visited[x-1][y]){
				New=new State(x-1,y,null);
				s.push(New);
				way = new State(x,y,null);
				path[x-1][y]=way;
				last_x=x;
				last_y=y;
			}
			if(x+1>=0&&x+1<boundry_x&&board[x+1][y]!='#'&&!visited[x+1][y]){
				 New=new State(x+1,y,null);
				s.push(New);
				way = new State (x,y,null);
				path[x+1][y]=way;
				last_x=x;
				last_y=y;
			}
			
			}
		}
	}
	void PrintPath (){
		int i=x,j=y;
		while(i!=start_x||j!=start_y){
			State temp = (State) path[i][j];
			if(board[temp.row][temp.col]!='*'&&board[temp.row][temp.col]!='$')board[temp.row][temp.col]='0';
			i=temp.row;
			j=temp.col;
			
		}
		board[start_x][start_y]='S';
	}
	char[][] print(){
		return board;
	}

}
