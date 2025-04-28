package lab7;

public interface Player {
	public int[] makeMove(char[][] board); // Returns {row, col} for move
	public char getSymbol(); // Returns 'X' or 'O'
	public String getName(); // Returns player's name


}
