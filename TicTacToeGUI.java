package lab7;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class TicTacToeGUI{
	Random random = new Random();
	GameLogic gameLogic;
	
	private JButton[][] button= new JButton[3][3];
	private JLabel statusLabel=new JLabel();
	private JButton resetButton= new JButton("Reset");
	private JFrame frame = new JFrame();
	private JPanel titlePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	
	public TicTacToeGUI(GameController controller) {
		
		button = new JButton[3][3];
		statusLabel= new JLabel();
		frame = new JFrame("TIC TAC TOE");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());	
		frame.getContentPane().setBackground(new Color(150,150,150));		
		
		statusLabel.setBackground(new Color(25,25,25));
		statusLabel.setForeground(new Color(25,255,0));
		statusLabel.setFont(new Font("Ink Free", Font.BOLD,75));
		statusLabel.setHorizontalAlignment(JLabel.CENTER);
		statusLabel.setText("Tic-Tac-Toe");
		statusLabel.setOpaque(true);
		
		titlePanel=new JPanel(new GridLayout(3,3));
		titlePanel.setLayout(new BorderLayout());
		titlePanel.add(statusLabel, BorderLayout.CENTER);
		titlePanel.add(resetButton, BorderLayout.EAST);
		titlePanel.setBounds(0,0,800,100);
		
	//	Font font = new Font("Arial", Font.BOLD, 60);
		
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		
	
		
		for(int row=0; row<3; row++) {
			for (int col=0; col<3; col++) {
				final int i=row, j=col;
				button[row][col]= new JButton("");
				buttonPanel.add(button[row][col]);
				button[row][col].setFont(new Font("MV Boli" , Font.BOLD,120));
				button[row][col].setFocusable(false);
				button[row][col].addActionListener(e -> controller.onCellClicked(i,j));
			
				button[row][col].setOpaque(true);
				button[row][col].setContentAreaFilled(true);
				
			}
			
		}
		resetButton.addActionListener(e -> controller.onResetClicked());
		
		frame.add(titlePanel,BorderLayout.NORTH);
	 	frame.add(buttonPanel, BorderLayout.SOUTH);
	 	frame.setVisible(true);
	}
	public void updateBoard(char[][] board) {
		
		
		for (int row=0; row<3; row++) {
			for(int col=0; col<3; col++) {
				 button[row][col].setText(String.valueOf(board[row][col]));
				 
				 if (board[row][col] == 'X') {
		                button[row][col].setForeground(Color.RED);
		                button[row][col].setBackground(Color.WHITE);
		            } else if (board[row][col] == 'O') {
		                button[row][col].setForeground(Color.BLUE); 
		                button[row][col].setBackground(Color.WHITE);
		            } else {
		                button[row][col].setForeground(Color.BLACK); 
		                
		            }
		    }
				}
				
		}
		
	public void showWinner(String playerName) {
		statusLabel.setText( playerName+ " won the game! ");
	}
	public void showDraw() {
		statusLabel.setText("The game is a draw!");
	}
	public void clearBoard() {
		
		for(int row =0; row<3; row++) {
			for(int col=0; col<3; col++) {
				button[row][col].setText("");
		
			}
			
		}
		statusLabel.setText("Game reset.");
	}
	public void showMessage(String message) {
		statusLabel.setText(message);
	}

	

	
	
}
