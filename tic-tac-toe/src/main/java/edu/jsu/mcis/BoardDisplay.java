package edu.jsu.mcis;

import java.util.*;


public class BoardDisplay {
	private TicTacToe t;
	private int n = 3;
	public String[][] visualBoard = new String[n][n];
	
	public void setupGame() {
		t = new TicTacToe();
	}
	
	public void updateBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(t.getBoardAt(i, j) == TicTacToe.positionState.Blank) {
					visualBoard[i][j] = "*";
				}
				else if (t.getBoardAt(i, j) == TicTacToe.positionState.X) {
					visualBoard[i][j] = "X";
				}
				else {
					visualBoard[i][j] = "O";
				}
			}
		}
	}
	
	public void showBoard() {
		output(" " + visualBoard[0][0] + " | " + visualBoard[0][1] + " | " + visualBoard[0][2]);
		output("----------");
		output(" " + visualBoard[1][0] + " | " + visualBoard[1][1] + " | " + visualBoard[1][2]);
		output("----------");
		output(" " + visualBoard[2][0] + " | " + visualBoard[2][1] + " | " + visualBoard[2][2]);
	}
	public void output(String s) {
		System.out.println(s);
	}
	
	public String getPlayer() {
		TicTacToe.positionState playerTurn = t.getTurn();
		if (playerTurn == TicTacToe.positionState.X)
			return "Player X";
		else
			return "Player O";
	}
	
	public static void main(String[] args) {
		BoardDisplay b = new BoardDisplay();
		b.setupGame();
		b.updateBoard();
		b.showBoard();
		while (b.t.checkWinner() == TicTacToe.positionState.Blank) {
			b.output("Where would you like to place your mark " + b.getPlayer() + "? [row 0-2] [ENTER] [col 0-2]");
			Scanner userInputRow = new Scanner(System.in);
			int rowInput = userInputRow.nextInt();
			Scanner userInputCol = new Scanner(System.in);
			int colInput = userInputCol.nextInt();
			b.t.playerMark(rowInput, colInput);
			b.t.checkWinner();
			b.updateBoard();
			b.showBoard();
		}
	}
}