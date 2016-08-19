package eg.edu.alexu.csd.ds.maze.cs10.cs35;

import java.util.Scanner;



public class GameMaze {
		char [] [] board ;
		int start_x,start_y,x,y,boundry_x,boundry_y,last_x,last_y,lucky_xx,lucky_yy;
		GameMaze(char arr[] [],int n,int m,int row,int col,int lucky_x,int lucky_y){
			board=new char [n][m];
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
		}
		
		Scanner input = new Scanner (System.in);
		char move;
		void UserMovement(){
			//System.out.println(x+"  "+y);
			move = input.next(".").charAt(0);
			
			while(move!='S'&&move!='M'){
				if(CheckMovement(move)){
					if(board[x][y]=='E'){
						System.out.println("Winner ! ! !");
						break;
					}
					if(board[x][y]=='*'){
						board[lucky_xx][lucky_yy]='0';
						x=lucky_xx;
						y=lucky_yy;
					}
					if(board[x][y]=='0'||board[x][y]=='S'){
						board[last_x][last_y]='.';
						last_x=x;
						last_y=y;
					}else if (board[x][y] != 'S'&&board[x][y] != '$'&&board[x][y] != '*'){
						board[x][y]='0';
					}
					
					System.out.println("----------------------");
					System.out.println("----------------------");
					System.out.println("----------------------");
					for(int i=0;i<boundry_x;i++	){
						for(int j=0;j<boundry_y;j++){
							System.out.print(board[i][j]);
							System.out.print("  ");
						}
						System.out.println();
						System.out.println();
					}
					move = input.next(".").charAt(0);
					if(move=='S'){
						break;
					}
					if(move=='M'){
						break;
					}
				}else{
					move = input.next(".").charAt(0);
				}
			}
			
		}
		
		boolean CheckMovement(char a){
			if(a=='8'){
				if(x-1>=0&&board[x-1][y]!='#'){
					last_x=x;
					last_y=y;
					x=x-1;
					return true;
				}
			}
			else if(a=='2'){
				if(x+1>=0&&x+1<boundry_x&&board[x+1][y]!='#'){
					last_x=x;
					last_y=y;
					x=x+1;
					return true;
				}
			}else if(a=='6'){
				if(y+1>=0&&y+1<boundry_y&&board[x][y+1]!='#'){
					last_y=y;
					last_x=x;
					y=y+1;
					return true;
				}
			}else if(a=='4'){
				if(y-1>=0&&y-1<boundry_y&&board[x][y-1]!='#'){
					last_y=y;
					last_x=x;
					y=y-1;
					return true;
				}
			}
			System.out.println("Invalid Input !! Enter Valid Movement ");
			return false;
			
			
		}
	
	
	

}