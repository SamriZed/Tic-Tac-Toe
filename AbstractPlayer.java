package lab7;

public abstract class AbstractPlayer implements Player {
	protected String name;
	protected char symbol;
	
	public AbstractPlayer() {
		
	}
	
	public AbstractPlayer(String name, char symbol) {
		this.name=name;
		this.symbol=symbol;
	}
	
	@Override
	
	public char getSymbol() {
		return symbol;
	}
	
	@Override
	
	public String getName() {
		return name;
	}
	
	@Override
	
	public abstract int[] makeMove(char[][] board);
	
}
