package lab7;

public class GameController {
	
	private GameLogic gameLogic;
	private TicTacToeGUI view;
	private GameBoard gameBoard= new GameBoard();
	
	public GameController() {
		Player player1=new HumanPlayer("Player 1", 'x');
		Player player2=new HumanPlayer("Player 2", '0');
	
	gameLogic = new GameLogic(player1, player2);
	view = new TicTacToeGUI(this);
	
	gameLogic.startGame();
	updateView();
	}
	
	
	public void onCellClicked(int row, int col) {
	    if (gameLogic.makeMove(row, col)) {
	        updateView();

	        if (gameLogic.checkWin()) {
	            view.showWinner(gameLogic.getCurrentPlayer().getName());
	        } else if (gameLogic.isDraw()) {
	            view.showDraw();
	        }
	    } else {
	        view.showMessage("Cell already occupied!");
	    }
	}
	
	public void onResetClicked() {
		gameLogic.resetGame();
		view.clearBoard();
		updateView();
	}
	private void updateView() {
		view.updateBoard(gameLogic.getBoard().getBoard());
		
	}

}
