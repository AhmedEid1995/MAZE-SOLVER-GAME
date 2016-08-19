package eg.edu.alexu.csd.ds.maze.cs10.cs35;

import Implementation.Implementation;
import Implementation.Queue;



public class BFS {
		char [] [] board ;
		boolean [][]visited;
		int start_x,start_y,x,y,boundry_x,boundry_y,last_x,last_y,lucky_xx,lucky_yy;
		BFS(char arr[] [],int n,int m,int row,int col,int lucky_x,int lucky_y){
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
	int ShortestPass(){
		Implementation q = new Queue();
		State state = new State(start_x,start_y,null);
		q.push(state);
		visited[start_x][start_y]=true;
		while(!q.isEmpty()){
			
			state=(State) q.pop();
			x=state.row;
			y=state.col;
			if(board[x][y]=='*'){
				visited[lucky_xx][lucky_yy]=true;
				State attemp = new State(lucky_xx,lucky_yy,state);
				q.push(attemp);
			}else{
			if(x>=1 && board[x-1][y]!='#' && !visited[x-1][y]){
				if(board[x-1][y]=='E'){
					printPath(state);
					return 1;
				}
				visited[state.row-1][state.col]=true;
				State attemp = new State(x-1,y,state);
				
				q.push(attemp);
				
			}
			if(x<boundry_x-1 && board[x+1][y]!='#' && !visited[x+1][y]){
				if(board[state.row+1][state.col]=='E'){
					printPath(state);
					return 1;
				}
				visited[x+1][y]=true;
				State attemp = new State(x+1,y,state);
				
				q.push(attemp);
				
			}
			if(y>=1 && board[x][y-1]!='#' && !visited[x][y-1]){
				if(board[x][y-1]=='E'){
					printPath(state);
					return 1;
				}
				visited[x][y-1]=true;
				State attemp = new State(x,y-1,state);
				
				q.push(attemp);
				
			}
			if(y<boundry_y-1 && board[x][y+1]!='#' && !visited[x][y+1]){
				if(board[x][y+1]=='E'){
					printPath(state);
					return 1;
				}
				visited[x][y+1]=true;
				State attemp = new State(x,y+1,state);
				q.push(attemp);
				
			}
			}
			
		}
		return 1;
	}
	private void printPath(State state) {
		// TODO Auto-generated method stub
		
		while(state.parent!=null){
			
			if(board[state.row][state.col]!='*'&&board[state.row][state.col]!='$')board[state.row][state.col]='0';
			state=(State) state.parent;
		}
	}
	public char []	[] print (){
	/*	for(int i=0;i<boundry_x;i++	){
			for(int j=0;j<boundry_y;j++){
				System.out.print(board[i][j]);
				System.out.print("  ");
			}
			System.out.println();
			System.out.println();
		}*/
		return board;
		
	}
}
