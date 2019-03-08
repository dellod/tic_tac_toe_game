
abstract class Player 
{
	protected String name;
	protected Board board;
	protected Player opponent;
	protected char mark;
	
	abstract protected void play();
	abstract protected void makeMove();
	
	protected void setOpponent(Player p)
	{
		opponent = p;
	}
	
	protected Player(String n, char m)
	{
		name = n;
		mark = m;
	}
	
	protected void setBoard(Board theBoard)
	{
		board = theBoard;
	}
	
	protected char getMark()
	{
		return mark;
	}
	
	
}
