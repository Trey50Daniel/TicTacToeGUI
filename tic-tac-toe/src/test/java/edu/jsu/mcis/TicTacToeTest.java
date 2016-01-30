package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import static org.junit.matchers.JUnitMatchers.both;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.everyItem;
import static org.junit.matchers.JUnitMatchers.hasItems;
import edu.jsu.mcis.TicTacToe.positionState;

public class TicTacToeTest {
	
	private TicTacToe t;
	@Before
	public void setup() {
		t = new TicTacToe();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		positionState initialBoardValue = positionState.Blank;
		positionState s;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				s = t.getBoardAt(i, j);
				assertEquals(initialBoardValue, s);
			}
		}
		
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		t.playerMark(0, 2);
		assertEquals(positionState.X, t.getBoardAt(0, 2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		t.playerMark(0, 0);
		t.playerMark(2, 0);
		assertEquals(positionState.O, t.getBoardAt(2, 0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		t.playerMark(0, 0);
		t.playerMark(0, 0);
		assertEquals(positionState.X, t.getBoardAt(0, 0));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		positionState player1 = positionState.X;
		t.playerMark(0, 0);
		positionState winningPlayer = t.checkWinner();
		assertEquals(positionState.Blank, winningPlayer);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		positionState thisDudeWon;
		t.playerMark(0, 0);
		t.playerMark(1, 1);
		t.playerMark(0, 1);
		t.playerMark(1, 2);
		t.playerMark(0, 2);
		thisDudeWon = t.checkWinner();
		assertEquals(positionState.X, thisDudeWon);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		positionState thisDudeWon;
		t.playerMark(1, 1);
		t.playerMark(0, 0);
		t.playerMark(2, 0);
		t.playerMark(0, 2);
		t.playerMark(0, 1);
		t.playerMark(2, 1);
		t.playerMark(1, 2);
		t.playerMark(1, 0);
		t.playerMark(2, 2);
		thisDudeWon = t.checkWinner();
		assertEquals(positionState.TIE, thisDudeWon);
	}

	@Test
	public void testGameIsWonByXDiagonally() {
		positionState thisDudeWon;
		t.playerMark(1, 1);
		t.playerMark(0, 1);
		t.playerMark(0, 0);
		t.playerMark(0, 2);
		t.playerMark(2, 2);
		thisDudeWon = t.checkWinner();
		assertEquals(positionState.X, thisDudeWon);
	}
	
	@Test
	public void testGameIsWonByOHorizontally() {
		positionState thisDudeWon;
		t.playerMark(1, 1);
		t.playerMark(2, 0);
		t.playerMark(0, 0);
		t.playerMark(2, 2);
		t.playerMark(0, 2);
		t.playerMark(2, 1);
		thisDudeWon = t.checkWinner();
		assertEquals(positionState.O, thisDudeWon);
	}
}
