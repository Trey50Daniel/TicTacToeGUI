package edu.jsu.mcis;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeVC extends JPanel implements ActionListener {
	
	private TicTacToe model;
	private int n = 3;
	private JButton[][] buttons;
	
	public TicTacToeVC() {
		model = new TicTacToe();
		buttons = new JButton[n][n];
		setLayout(new GridLayout(3, 3));
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].setPreferredSize(new Dimension(100, 100));
				buttons[i][j].addActionListener(this);
				buttons[i][j].setName("Location" + i + j);
				add(buttons[i][j]);
			}
		}		
	}
	
	private String getMark(int row, int col) {
		TicTacToe.positionState move = model.getBoardAt(row, col);
		if(move == TicTacToe.positionState.X) {
			return "X";
		}
		else if(move == TicTacToe.positionState.O) {
			return "O";
		}
		else {
			return "";
		}
	}
	
	public void actionPerformed(ActionEvent evt) {
		JButton b = (JButton)evt.getSource();
		String loc = b.getName().substring(8);
		int row = Integer.parseInt(loc.substring(0, 1));
		int col = Integer.parseInt(loc.substring(1, 2));
		model.playerMark(row, col);
		b.setText(getMark(row, col));
		checkForWin();
	}
	
	private void checkForWin() {
		TicTacToe.positionState result = model.checkWinner();
		final String s;
		JOptionPane p = new JOptionPane();
		if(result == TicTacToe.positionState.X) {
			s = "X";
		}
		else if(result == TicTacToe.positionState.O) {
			s = "O";
		}
		else if(result == TicTacToe.positionState.TIE) {
			s = "TIE";
		}
		else { 
			s = ""; 
		}
		if(s.length() > 0) {
			new Thread(new Runnable() {
				public void run() {
					JOptionPane.showMessageDialog(null, "The winner is " + s, "Game Over", JOptionPane.INFORMATION_MESSAGE);
				}
			}).start();
		}
	}
	public static void main(String[] args) {
		TicTacToeVC panel = new TicTacToeVC();
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
}