package edu.jsu.mcis;

import java.util.*;

public class TicTacToe {
	 public enum positionState {Blank, X, O, TIE};
	 private int n = 3;
	 private positionState[][] boardArray = new positionState[n][n];
	 private int moveCounter;
	 private positionState turn;
	 
	public TicTacToe() {
		initializeBoard();
		turn = positionState.X;
		moveCounter = 0;
	}

	public void initializeBoard() {
		for (int i = 0; i < boardArray.length; i++) {
			for (int j = 0; j < boardArray[0].length; j++) {
				boardArray[i][j] = positionState.Blank;
			}
		}
	}
	
	public void playerMark(int row, int column) {
		if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
			if (boardArray[row][column] == positionState.Blank) {
				boardArray[row][column] = turn;
				moveCounter++;
				if(turn == positionState.X) turn = positionState.O;
				else turn = positionState.X;
			}
		}
	}
	
	public positionState checkWinner() {
		if(boardArray[0][0] == boardArray[1][1] && boardArray[1][1] == boardArray[2][2]) 
			return boardArray[0][0];
		else if(boardArray[0][0] == boardArray[0][1] && boardArray[0][1] == boardArray[0][2]) 
			return boardArray[0][0];
		else if(boardArray[1][0] == boardArray[1][1] && boardArray[1][1] == boardArray[1][2]) 
			return boardArray[1][0];
		else if(boardArray[2][0] == boardArray[2][1] && boardArray[2][1] == boardArray[2][2]) 
			return boardArray[2][0];
		else if(boardArray[0][0] == boardArray[1][0] && boardArray[1][0] == boardArray[2][0]) 
			return boardArray[0][0];
		else if(boardArray[0][1] == boardArray[1][1] && boardArray[1][1] == boardArray[2][1]) 
			return boardArray[0][1];
		else if(boardArray[0][2] == boardArray[1][2] && boardArray[1][2] == boardArray[2][2]) 
			return boardArray[0][2];
		else if(boardArray[0][2] == boardArray[1][1] && boardArray[1][1] == boardArray[2][0]) 
			return boardArray[0][2];
		else if(moveCounter == 9) 
			return positionState.TIE;
		else return positionState.Blank;
	}
	
	public positionState getTurn() {
		return turn;
	}
	
	public positionState getBoardAt(int row, int col) {
		return boardArray[row][col];
	}
}