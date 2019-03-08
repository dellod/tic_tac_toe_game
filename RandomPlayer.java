
public class RandomPlayer extends Player 
{

	protected RandomPlayer(String n, char m) 
	{
		super(n, m);
	}

	@Override
	protected void play() 
	{
		makeMove();
		if(board.xWins() || board.oWins())
		{
			board.display();
			System.out.println("Game Over! " + name + " wins!");
			System.out.println("Game ended...");
			System.exit(1);
		}
		else if(board.isFull())
		{
			board.display();
			System.out.println("Tie Game!");
			System.out.println("Game ended...");
			System.exit(1);
		}
		
		board.display();
	}

	@Override
	protected void makeMove() 
	{
		int row, col;
		System.out.println("\n"+ this.name + " is making a random move...\n");
		
		RandomGenerator generator = new RandomGenerator();
		row = generator.discrete(0,2);
		col = generator.discrete(0,2);

		if(board.checkSpot(row, col))
		{
			board.addMark(row, col, mark);
		}
		else
		{
			System.out.println("\nSpot is unavailable, finding another...");
			makeMove();
		}
	}

	@Override
	protected void setOpponent(Player p) {
		// TODO Auto-generated method stub
		
	}

}
