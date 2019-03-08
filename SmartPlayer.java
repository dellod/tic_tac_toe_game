
public class SmartPlayer extends BlockingPlayer
{

	protected SmartPlayer(String n, char m) 
	{
		super(n, m);
	}

	
	public void makeMove()
	{
		System.out.println("\n" + this.name + " is looking for win condition...");
		boolean add = false;
		int i, j = 0;
		for(i = 0; i < 3; i++)
		{
			for(j = 0; j < 3; j++)
			{
				if(testForWin(i,j))
				{
					add = true;
					break;
				}
			}
		}
		if(i == 3)
		{
			i--;
		}
		if(j == 3)
		{
			j--;
		}
		if(add && board.checkSpot(i, j))
		{
			board.addMark(i, j, mark);
		}
		else 
		{
			super.makeMove();
		}
	}
	
	public boolean testForWin(int row, int col)
	{
		int markCount = 0;
		if(!board.checkSpot(row,col))
		{
			return false; 
		}
		else if((row == 0 && col == 0) || (row == 2 && col == 2))
		{
			for(int i = 0; i < 3; i++)
			{
				if(board.getMark(row,i) == mark) // Check horizontal
				{
					markCount++;
				}
			}
			if(markCount >= 2)
			{
				return true;
			}
			markCount = 0;
			for(int i = 0; i < 3; i++)
			{
				if(board.getMark(i,col) == mark) // Check vertical
				{
					markCount++;
				}
			}
			if(markCount >= 2)
			{
				return true;
			}
			markCount = 0;
			for(int i = 0; i < 3; i++)
			{
				if(board.getMark(i,i) == mark) // Check diagonal
				{
					markCount++;
				}
			}
			if(markCount >= 2)
			{
				return true;
			}
			markCount = 0;
		}
		else if((row == 0 && col == 1) || (row == 2 && col ==1) || (row == 1 && col == 0) || (row == 1 && col ==2))
		{
			for(int i = 0; i < 3; i++)
			{
				if(board.getMark(row, i) == mark) // Check horizontal
				{
					markCount++;
				}
			}
			if(markCount >= 2)
			{
				return true;
			}
			markCount = 0;
			for(int i = 0; i < 3; i++)
			{
				if(board.getMark(i,col) == mark) // Check vertical
				{
					markCount++;
				}
			}
			if(markCount >= 2)
			{
				return true;
			}
			markCount = 0;
		}
		else if((row == 0 && col == 2) || (row == 2 && col == 0))
		{
			for(int i = 0; i < 3; i++)
			{
				if(board.getMark(row,i) == mark) // Check horizontal
				{
					markCount++;
				}
			}
			if(markCount >= 2)
			{
				return true;
			}
			markCount = 0;
			for(int i = 0; i < 3; i++)
			{
				if(board.getMark(i,col) == mark) // Check vertical
				{
					markCount++;
				}
			}
			if(markCount >= 2)
			{
				return true;
			}
			markCount = 0;
			for(int i = 0; i < 3; i++)
			{
				if(board.getMark(i, 2 - i) == mark) // Check diagonal
				{
					markCount++;
				}
			}
			if(markCount >= 2)
			{
				return true;
			}
			markCount = 0;
		}

		
		return false; //returns false if there is no win condition, true if there is one at spot
	}
}
