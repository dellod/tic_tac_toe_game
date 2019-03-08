
import java.util.Scanner;

public class HumanPlayer extends Player
{
	protected HumanPlayer(String n, char m) 
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
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n" + name + ", what row should your next " + mark + " be placed in?");
		row = Integer.parseInt(scan.nextLine());
		System.out.println("\n" + name + ", what column should your next " + mark + " be placed in?");
		col = Integer.parseInt(scan.nextLine());
		if(board.checkSpot(row, col))
		{
			board.addMark(row, col, mark);
		}
		else
		{
			System.out.println("\nSpot is unavailable, enter again.");
			makeMove();
		}
		
	}

	@Override
	protected void setOpponent(Player p) 
	{
		this.opponent = p;
		
	}
}
