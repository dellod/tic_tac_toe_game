
public class BlockingPlayer extends RandomPlayer
{

	protected void setOpponent(Player p)
	{
		opponent = p;
	}
	
	protected BlockingPlayer(String n, char m) 
	{
		super(n, m);
	}
	
	protected void makeMove()
	{
		System.out.println("\n"+ this.name + " is looking for place to block...");
		boolean add = false;
		int i, j = 0;
		for(i = 0; i < 3; i++)
		{
			for(j = 0; j < 3; j++)
			{
				if(testForBlocking(i,j))
				{
					add = true;
					break;
				}
			}
			if(add)
			{
				break;
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
	
	protected boolean testForBlocking(int row, int col) //false if you dont need to block this spot.
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
				if(board.getMark(row,i) == opponent.getMark()) // Check horizontal
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
				if(board.getMark(i,col) == opponent.getMark()) // Check vertical
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
				if(board.getMark(i,i) == opponent.getMark()) // Check diagonal
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
				if(board.getMark(row, i) == opponent.getMark()) // Check horizontal
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
				if(board.getMark(i,col) == opponent.getMark()) // Check vertical
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
				if(board.getMark(row,i) == opponent.getMark()) // Check horizontal
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
				if(board.getMark(i,col) == opponent.getMark()) // Check vertical
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
				if(board.getMark(i, 2 - i) == opponent.getMark()) // Check diagonal
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
		else if(row == 1 && col == 1)
		{
			for(int i = 0; i < 3; i++)
			{
				if(board.getMark(row,i) == opponent.getMark()) // Check horizontal
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
				if(board.getMark(i,col) == opponent.getMark()) // Check vertical
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
				if(board.getMark(i,i) == opponent.getMark()) // Check diagonal
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
				if(board.getMark(i, 2 - i) == opponent.getMark()) // Check diagonal
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
		return false;
	}
}
