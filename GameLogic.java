package lab7;
import java.util.Random;
public class GameLogic {
	private Player currentPlayer;
	private Player player1, player2;
	public boolean gameOver=false;
	GameBoard board;

	public GameLogic(Player player1,Player player2) {
		this.player1=player1;
		this.player2=player2;
	}
	
	public void startGame() {
		board = new GameBoard();
		currentPlayer=player1;
	}
	public boolean makeMove(int row, int col) {
		
		if (gameOver) {
			return false;
		}
		
		if(board.placeMove(row,col, currentPlayer.getSymbol())){
			if (checkWin()) {
				return true;
			}
			if (isDraw()) {
				return true;
			}
			switchPlayer();
			return true;
			}
		return false;
	}
	public boolean checkWin() {
		
		if (board.checkWin(currentPlayer.getSymbol())){
			gameOver = true;
			return true;
		}
		return false;
	}
	public boolean isDraw() {
		if (board.isDraw())	{
			gameOver=true;
		return true;
		}
		return false;
		}
	
//	public boolean player1Turn() {
//		Random random = new Random();
//		if (random.nextInt(2)==0) {
//			player1Turn=true;
//			return true;
//		}
//		player1Turn=false;
//		return false;
//	}
	public void switchPlayer() {
		
		if(currentPlayer==player1) {
			currentPlayer = player2;
		}
		else {
			currentPlayer= player1;
		}
	}
	public void resetGame() {
		board.resetBoard();
		gameOver=false;
	}
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public GameBoard getBoard() {
		return board;
	}
	public boolean isGameOver() {
		return gameOver;
	}
	
}
