package tests;

import static org.junit.Assert.*;

import java.util.Random;

import model.BoardCell;
import model.ClearCellGame;
import model.Game;

import org.junit.Test;

public class PublicTests {
	/* We use this string to prevent any hardcoding of results. */
	/* The submit server uses a different value for TESTS_TAG   */
	public static final String TESTS_TAG = "\nClearCellGameTest";
	
	@Test
	public void emptyBoard() {
		int maxRows = 4, maxCols = 5, strategy = 1;
		Game ccGame = new ClearCellGame(maxRows, maxCols, new Random(1L),
				strategy);

		String answer = getBoardStr(ccGame);
		
		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubEmptyBoard.txt", answer));
	}

	@Test
	public void animationSteps() {
		int maxRows = 4, maxCols = 5, strategy = 1;
		Game ccGame = new ClearCellGame(maxRows, maxCols, new Random(1L),
				strategy);
		ccGame.nextAnimationStep();
		ccGame.nextAnimationStep();

		String answer = getBoardStr(ccGame);
		
		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubAnimationSteps.txt", answer));
	}

	@Test
	public void horizontalCells() {
		int maxRows = 8, maxCols = 8, strategy = 1;
		Game ccGame = new ClearCellGame(maxRows, maxCols, new Random(1L), strategy);
	   
		ccGame.setBoardWithColor(BoardCell.BLUE);
		ccGame.setRowWithColor(maxRows - 1, BoardCell.EMPTY);
		ccGame.setRowWithColor(1, BoardCell.YELLOW);
		ccGame.setBoardCell(1, maxCols - 1, BoardCell.RED);
		
		String answer = "Before processCell\n\n";
		answer += getBoardStr(ccGame);
		ccGame.processCell(1, 4);
		answer += "\nAfter processCell\n";
		answer += getBoardStr(ccGame);
		
		answer += TESTS_TAG;
		
		assertTrue(TestsSupport.isCorrect("pubHorizontalCells.txt", answer));
	}

	@Test
	public void collapseCells() {
		int maxRows = 8, maxCols = 8, strategy = 1;
		Game ccGame = new ClearCellGame(maxRows, maxCols, new Random(1L), strategy);
	   
		ccGame.setBoardWithColor(BoardCell.BLUE);
		ccGame.setRowWithColor(maxRows - 1, BoardCell.EMPTY);
		ccGame.setRowWithColor(1, BoardCell.YELLOW);
		ccGame.setBoardCell(1, maxCols - 1, BoardCell.RED);
		ccGame.setRowWithColor(3, BoardCell.GREEN);
		ccGame.setRowWithColor(6, BoardCell.RED);
		
		String answer = "Before processCell\n\n";
		answer += getBoardStr(ccGame);
		ccGame.processCell(1, 4);
		answer += "\nAfter processCell\n";
		answer += getBoardStr(ccGame);
		ccGame.processCell(1, maxCols - 1);
		answer += "\nAfter processCell\n";
		answer += getBoardStr(ccGame);
		
		answer += TESTS_TAG;
//		assertEquals("pubCollapseCells.txt", answer);
		assertTrue(TestsSupport.isCorrect("pubCollapseCells.txt", answer));
	}

	
	
	/* Support methods */
	private static String getBoardStr(Game game) {
		int maxRows = game.getMaxRows(), maxCols = game.getMaxCols();

		String answer = "Board(Rows: " + maxRows + ", Columns: " + maxCols + ")\n";
		for (int row = 0; row < maxRows; row++) {
			for (int col = 0; col < maxCols; col++) {
				answer += game.getBoardCell(row, col).getName();
			}
			answer += "\n";
		}

		return answer;
	}
	
}
