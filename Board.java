
/**
 * 
 * This class is where most of the drawing and visuals in the text based tic-toe 
 * game are created. 
 * Also provides methods to check the board state and physically adds marks.
 * 
 * @author Daryl Dang
 * @since Jan 30, 2019
 */
public class Board implements Constants 
{
	/**
	 * The board which is represented by a two-dimensional array (row and column)
	 */
	private char theBoard[][];
	
	/**
	 * Tracks the total marks on the board.
	 */
	private int markCount;

	/**
	 * Constructs the board with initial mark count of 0 and creates an empty
	 * 3x3 board.
	 */
	public Board() 
	{
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) 
		{
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
	
	/**
	 * Constructs board to have the same board array elements as argument and 
	 * mark count.
	 * @param b is the board that is used as a copy for this constructor.
	 */
	public Board(Board b)
	{
		for(int i = 0; i < b.theBoard.length; i++)
		{
			for(int j = 0; j < b.theBoard[i].length; j++)
			{
				this.theBoard[i][j] = b.theBoard[i][j];
			}
		}
		this.markCount = b.markCount;
	}
	
	/**
	 * Checks the mark at given row and column location and gives the 
	 * mark at the particular spot.
	 * 
	 * @param row is the row index to be checked.
	 * @param col is the column index to be checked.
	 * @return character mark located at the specified location.
	 */
	public char getMark(int row, int col) 
	{
		return theBoard[row][col];
	}
	
	/**
	 * Checks if the board is full of marks.
	 * @return true if the board is full (== 9), otherwise return false (!= 9).
	 */
	public boolean isFull() 
	{
		return markCount == 9;
	}

	/**
	 * Checks if X wins by calling method checkWinner.
	 * @return true if X wins, otherwise return false.
	 */
	public boolean xWins() 
	{
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if O wins by calling method checkWinner.
	 * @return true if O wins, otherwise return false.
	 */
	public boolean oWins() 
	{
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Draws text-based board by calling methods displayColumnHeaders, addHyphens,
	 * and addSpaces.
	 */
	public void display() 
	{
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds specified mark to the described row and column indices.
	 * @param row is the index of row to be located.
	 * @param col is the index of column to be located.
	 * @param mark is the character mark to be added at specified location.
	 */
	public void addMark(int row, int col, char mark) 
	{
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Clears the marks from the board and resets the markCount (== 0).
	 */
	public void clear() 
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}
	
	/**
	 * Checks if the specified mark has won under tic-toe game conditions.
	 * @param mark is the marks to be checked on the board for a winner.
	 * @return 1 if the mark has won the game, otherwise return 0.
	 */
	int checkWinner(char mark) 
	{
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
	
	boolean checkSpot(int row, int col)
	{
		if(theBoard[row][col] == 'X' || theBoard[row][col] == 'O')
		{
			return false; //if spot is occupied
		}
		return true; //if free
		
	}
	
	/**
	 * Displays the column headers.
	 */
	void displayColumnHeaders() 
	{
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}
	
	/**
	 * Adds hyphens.
	 */
	void addHyphens()
	{
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
	
	/**
	 * Adds spaces.
	 */
	void addSpaces()
	{
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
