package lab7;

public class GameBoard {
	private char[][] board; // 3x3 board
	private int movesCount;
	
	public GameBoard() {
		board = new char[3][3];
		for(int row=0; row<3; row++) {
			for(int col=0; col<3; col++) {
				board[row][col]=' ';
			}
		}
		movesCount=0;
	}
	public boolean isCellEmpty(int row, int col) {
		
		if (board[row][col]==' ') {
			return true;
		}
		return false;
	}
	public boolean placeMove(int row, int col, char symbol) {
		if (board[row][col]==' ') {
			board[row][col]= symbol;
			movesCount+=1;
			return true;
		}
		return false;
	}
	public boolean checkWin(char symbol) {
		for (int row =0; row<3; row++) {
			if(board[row][0]== board[row][1] && board[row][1] == board[row][2]) {
				if (board[row][0]==symbol) {
					return true;
					
				}
			}
		}
		for (int col = 0; col<3; col++) {
			if(board[0][col]== board[1][col]&& board[1][col]==board[2][col]) {
				if(board[0][col]==symbol) {
					return true;
					
				}
			}
		}
		if(board[0][0]== board[1][1] && board[1][1]== board[2][2]) {
			if(board[0][0]== symbol) {
				return true;
			}
		}
		if(board[0][2] == board[1][1]&& board[1][1] == board[2][0]) {
			if(board[0][2]==symbol) {
				return true;
			}
		}
		return false;
	}
	public boolean isDraw() {
		if (movesCount==9 && !checkWin('X') && !checkWin('Y')) {
			return true;
		}
		return false;
	
	}
	public void resetBoard() {
		for(int row=0; row<3; row++) {
			for(int col=0; col<3; col++) {
				if(board[row][col]!=' ') {
					board[row][col]=' ';
					movesCount=0;
				}
			}
		}
	}
	public char[][] getBoard(){
		return board;
		
	}
}
