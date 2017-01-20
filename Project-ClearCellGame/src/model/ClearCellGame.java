 package model;

import java.awt.Color;
import java.util.Random;

/* This class must extend Game */
public class ClearCellGame extends Game {
	
	Random random;
	int strategy;
	int score = 0;
	
	/**
	 * Stores values passed as param
	 * @param maxRows
	 * @param maxCols
	 * @param random
	 * @param strategy
	 */
	public ClearCellGame(int maxRows, int maxCols, java.util.Random random, int strategy) 
	{
		super(maxRows, maxCols);
		this.random = random;
		this.strategy = strategy;
		
	}

	/**
	 * Gets target color that it compares other cells to
	 * Runs HoriztonalHelper
	 * Runs VerticalHelper
	 * Runs FowardSlashHelper
	 * Runs BackSlashHelper
	 * Clears initially selected cell
	 * Increments score
	 * Runs ShiftHelper
	 * @param rowIndex
	 * @param colIndex
	 */
	@Override
	public void processCell(int rowIndex, int colIndex) 
	{
		Color target = board[rowIndex][colIndex].getColor();
		
		processCellHorizontalHelper(rowIndex, colIndex, target);
		processCellVerticalHelper(rowIndex, colIndex, target);
		processCellFowardSlashHelper(rowIndex,colIndex, target);
		processCellBackSlashHelper(rowIndex, colIndex, target);

		this.setBoardCell(rowIndex,colIndex, BoardCell.EMPTY);
		score++;
		processCellShiftHelper();
		//throw new UnsupportedOperationException();
	}
	
	/**
	 * Establishes two booleans
	 * 			leftSide --> false: default, when leftSide is still same as target
	 * 					 --> true : hits cell on leftSide that is different from target
	 * 			
	 * 			rightSide --> false: default, when rightSide is still same as target
	 * 					  --> true : hits cell on rightSide that is different from target
	 * Loop is used to check cells that are spaced "i" away from target (Horizontally)
	 * First if statements are used to prevent arrayOutOfBounds
	 * Next statements check to see if either of the booleans are hit and if the cell is the same color as target
	 * 						true: Sets cell to EMPTY
	 * 							  Increments score
	 * 						false: Changes boolean to true (Meaning it cannot remove from that side anymore)
	 * @param rowIndex
	 * @param colIndex
	 * @param target
	 */
	public void processCellHorizontalHelper(int rowIndex, int colIndex, Color target)
	{
		boolean leftSide = false;
		boolean rightSide = false;
		
		for(int i = 1; i <= board[rowIndex].length; i++)
		{
			if(colIndex+i < board[rowIndex].length)
			{
				if(!rightSide && board[rowIndex][colIndex+i].getColor() == target)
				{
					board[rowIndex][colIndex+i] = BoardCell.EMPTY;
					//this.setBoardCell(rowIndex, colIndex+i, BoardCell.EMPTY);
					score++;
				}
				else
				{
					rightSide = true;
				}
			}
			if(colIndex-i >= 0)
			{
				if(!leftSide && board[rowIndex][colIndex-i].getColor() == target)
				{
					board[rowIndex][colIndex-i] = BoardCell.EMPTY;
					//this.setBoardCell(rowIndex, colIndex-i, BoardCell.EMPTY);
					score++;
				}
				else
				{
					leftSide = true;
				}
			}
		}
	}
	
	/**
	 * Establishes two booleans
	 * 			top --> false: default, when top is still same as target
	 * 					 --> true : hits cell on top that is different from target
	 * 			
	 * 			bottom --> false: default, when bottom is still same as target
	 * 					  --> true : hits cell on bottom that is different from target
	 * Loop is used to check cells that are spaced "i" away from target (Vertically)
	 * First if statements are used to prevent arrayOutOfBounds
	 * Next statements check to see if either of the booleans are hit and if the cell is the same color as target
	 * 						true: Sets cell to EMPTY
	 * 							  Increments score
	 * 						false: Changes boolean to true (Meaning it cannot remove from that side anymore)
	 * @param rowIndex
	 * @param colIndex
	 * @param target
	 */
	public void processCellVerticalHelper(int rowIndex, int colIndex, Color target)
	{
		boolean top = false;
		boolean bottom = false;
		
		for(int i = 1; i <= board.length; i++)
		{
			if(rowIndex+i < board.length)
			{
				if(!bottom && board[rowIndex+i][colIndex].getColor() == target)
				{
					this.setBoardCell(rowIndex+i, colIndex, BoardCell.EMPTY);
					score++;
				}
				else
				{
					bottom = true;
				}
			}
			if(rowIndex-i >= 0)
			{
				if(!top && board[rowIndex-i][colIndex].getColor() == target)
				{
					this.setBoardCell(rowIndex-i, colIndex, BoardCell.EMPTY);
					score++;
				}
				else
				{
					top = true;
				}
			}
		}
	}
	
	/**
	 * Establishes two booleans
	 * 			topRight --> false: default, when topRight is still same as target
	 * 					 --> true : hits cell on topRight that is different from target
	 * 			
	 * 			bottomLeft --> false: default, when bottomLeft is still same as target
	 * 					   --> true : hits cell on bottomLeft that is different from target
	 * Loop is used to check cells that are spaced "i" away from target (FowardSlash from target /)
	 * First if statements are used to prevent arrayOutOfBounds
	 * Next statements check to see if either of the booleans are hit and if the cell is the same color as target
	 * 						true: Sets cell to EMPTY
	 * 							  Increments score
	 * 						false: Changes boolean to true (Meaning it cannot remove from that side anymore)
	 * @param rowIndex
	 * @param colIndex
	 * @param target
	 */
	public void processCellFowardSlashHelper(int rowIndex, int colIndex, Color target)
	{
		boolean topRight = false;
		boolean bottomLeft = false;
		
		for(int i = 1; i <= board.length; i++)
		{
			if(rowIndex+i < board.length && colIndex-i >= 0)
			{
				if(!bottomLeft && board[rowIndex+i][colIndex-i].getColor() == target)
				{
					this.setBoardCell(rowIndex+i, colIndex-i, BoardCell.EMPTY);
					score++;
				}
				else
				{
					bottomLeft = true;
				}
			}
			if(rowIndex-i >= 0 && colIndex+i < board[rowIndex-i].length)
			{
				if(!topRight && board[rowIndex-i][colIndex+i].getColor() == target)
				{
					this.setBoardCell(rowIndex-i, colIndex+i, BoardCell.EMPTY);
					score++;
				}
				else
				{
					topRight = true;
				}
			}
		}
	}
	
	/**
	 * Establishes two booleans
	 * 			topLeft --> false: default, when topLeft is still same as target
	 * 					 --> true : hits cell on topLeft that is different from target
	 * 			
	 * 			bottomRight --> false: default, when bottomRight is still same as target
	 * 					    --> true : hits cell on bottomRight that is different from target
	 * Loop is used to check cells that are spaced "i" away from target (BackSlash from target \)
	 * First if statements are used to prevent arrayOutOfBounds
	 * Next statements check to see if either of the booleans are hit and if the cell is the same color as target
	 * 						true: Sets cell to EMPTY
	 * 							  Increments score
	 * 						false: Changes boolean to true (Meaning it cannot remove from that side anymore)
	 * @param rowIndex
	 * @param colIndex
	 * @param target
	 */
	public void processCellBackSlashHelper(int rowIndex, int colIndex, Color target)
	{
		boolean topLeft = false;
		boolean bottomRight = false;
		
		for(int i = 1; i <= board.length; i++)
		{
			if(rowIndex+i < board.length && colIndex+i < board[rowIndex+i].length)
			{
				if(!bottomRight && board[rowIndex+i][colIndex+i].getColor() == target)
				{
					this.setBoardCell(rowIndex+i, colIndex+i, BoardCell.EMPTY);
					score++;
				}
				else
				{
					bottomRight = true;
				}
			}
			if(rowIndex-i >= 0 && colIndex-i >= 0)
			{
				if(!topLeft && board[rowIndex-i][colIndex-i].getColor() == target)
				{
					this.setBoardCell(rowIndex-i, colIndex-i, BoardCell.EMPTY);
					score++;
				}
				else
				{
					topLeft = true;
				}
			}
		}
	}
	
	/**
	 * Establishes a boolean
	 * 			blank --> true: default, When the entire row is empty
	 * 				  --> false: When cell atleast one cell in the row is not empty
	 * 
	 * For loop checks to see if the entire row is blank --> false: stops checking row and blank is false
	 * Checks to see if blank --> true: swaps the empty row with row below it until empty row is all the way at the bottom
	 */
	public void processCellShiftHelper()
	{
		boolean blank;
		
		for(int i = 0; i < board.length-1; i++)
		{
			blank = true;
			for(int j = 0; j < board[i].length; j++)
			{
				if(board[i][j].getColor() != Color.WHITE)
				{
					j = board[i].length+1;
					blank = false;
				}
			}
			if(blank)
			{
				for(int j = 0; j < board[i].length; j++)
				{
					this.setBoardCell(i, j, this.getBoardCell(i+1, j));
					this.setBoardCell(i+1, j, BoardCell.EMPTY);
				}
			}
		}
	}
	
	/**
	 * Checks to see if game is over
	 * If any cell non-empty cell occupies bottom row then game is over
	 */
	@Override
	public boolean isGameOver()
	{
		for(int j = 0; j < board[board.length-1].length; j++)
		{
			if(board[board.length-1][j] != BoardCell.EMPTY)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the score
	 */
	@Override
	public int getScore()
	{
		return score;
		//throw new UnsupportedOperationException();
	}

	/**
	 * Advances the animation one step.
	 */
	@Override
	public void nextAnimationStep()
	{
		if(!isGameOver())
		{
			for(int i = board.length-1; i > 0; i--)
			{
				for(int j = 0; j < board[i].length; j++)
				{
						this.setBoardCell(i, j, this.getBoardCell(i-1, j));
				}
			}
			for (int i = 0; i < board[0].length; i++) 
			{
				board[0][i] = BoardCell.getNonEmptyRandomBoardCell(random);
			}
		}
	}

}