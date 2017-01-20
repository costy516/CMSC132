package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JOptionPane;

import model.BoardCell;
import model.ClearCellGame;
import model.Game;

public class GameGUI extends JComponent {
	private static final long serialVersionUID = 1L;
	private static int CELL_DIMENSION = 30;
	private static boolean RAISED_CELL = true;
	private Game gameModel;
	private Timer timer;
	
	public GameGUI(int timerDelayInMilliSecs, Game gameModelIn) 
	{
		this.gameModel = gameModelIn;

		setPreferredSize(new Dimension(gameModel.getMaxCols() * CELL_DIMENSION,
				gameModel.getMaxRows() * CELL_DIMENSION));
	
		addMouseListener(new MouseHandler());
		ActionListener animator = new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				if (!gameModel.isGameOver()) 
				{
					gameModel.nextAnimationStep();
					repaint();
				} 
				else 
				{
					timer.stop();
					String message = "Score: " + gameModel.getScore() + "\nGame Over";
					JOptionPane.showMessageDialog(GameGUI.this, message);
					System.exit(0);
				}
			}
		};
		timer = new Timer(timerDelayInMilliSecs, animator);
		timer.start();
	}

	protected void paintComponent(Graphics g) 
	{
		Graphics g2 = (Graphics2D) g;

		/* Setting background */
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());

		/* Drawing the grid */
		BoardCell[][] board = getBoard(gameModel);
		for (int row = 0; row < board.length; row++) 
		{
			for (int col = 0; col < board[row].length; col++) 
			{
				g2.setColor(board[row][col].getColor());
				g2.fill3DRect(col * CELL_DIMENSION, row * CELL_DIMENSION,
							 CELL_DIMENSION, CELL_DIMENSION, RAISED_CELL);
			}
		}
	}

	private class MouseHandler extends MouseAdapter 
	{
		public void mouseReleased(MouseEvent evt) 
		{
			Point point = evt.getPoint();

			/* Determining the cell clicked */
			int rowIndex = (int) (point.y / CELL_DIMENSION);
			int colIndex = (int) (point.x / CELL_DIMENSION);

			gameModel.processCell(rowIndex, colIndex);
			repaint();
		}
	}

	private static BoardCell[][] getBoard(Game model) 
	{
		int maxRows = model.getMaxRows();
		int maxCols = model.getMaxCols();
		BoardCell[][] board = new BoardCell[maxRows][maxCols];
		
		for (int row=0; row < maxRows; row++)
			for (int col=0; col < maxCols; col++)
				board[row][col] = model.getBoardCell(row, col);
		return board;
	}
	
	public static void createAndDisplayGUI(Game gameModel, int timerDelayInMilliSecs) 
	{
		GameGUI gameGUI = new GameGUI(timerDelayInMilliSecs, gameModel);
		   
		JFrame frame = new JFrame("Clear Cell Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gameGUI);
		frame.pack();
		
		/* Centralizing the frame in the display window */
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int upperLeftCornerX = (screenSize.width - frame.getWidth()) / 2;
	    int upperLeftCornerY = (screenSize.height - frame.getHeight()) / 2;
	    frame.setLocation(upperLeftCornerX, upperLeftCornerY);
	   
		frame.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		Runnable createShowGUI = new Runnable() 
		{
			public void run() 
			{
				int maxRows = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of rows", 16));
				int maxCols = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of columns", 9));
				int timerDelayInMilliSecs = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter speed in milliseconds", 4000));
				GameGUI.createAndDisplayGUI(new ClearCellGame(maxRows, maxCols, new Random(1L), 1), 
											timerDelayInMilliSecs);
			}
		};
		SwingUtilities.invokeLater(createShowGUI);
	}
}