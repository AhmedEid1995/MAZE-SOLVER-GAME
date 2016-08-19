package eg.edu.alexu.csd.ds.maze.cs10.cs35;

public class State {
	public Integer row;
	public Integer col;
	public State parent;
	public State(int x, int y, Object father) {
		// TODO Auto-generated constructor stub
		row=x;
		col=y;
		parent=(State) father;
	}
	
}
