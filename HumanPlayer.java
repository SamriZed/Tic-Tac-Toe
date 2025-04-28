package lab7;

public class HumanPlayer extends AbstractPlayer {
	
	public HumanPlayer() {
		
	}
	public HumanPlayer(String name, char symbol) {
		this.name= name;
		this.symbol = symbol;
	}
	private int[] move = null;

	public void setMove(int row, int col) {
	    this.move = new int[]{row, col};
	}

	@Override
	public int[] makeMove(char[][] board) {
	    return move;
	}

}
