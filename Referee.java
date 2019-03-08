
/**
 * This class monitors and runs the tic-toe game.
 * Also initializes the board and player state.
 *  
 * @author Daryl Dang
 * @since Jan 30, 2019
 */
public class Referee 
{
	/**
	 * The player that has the X mark.
	 */
	private Player xPlayer;
	
	/**
	 * The player that has the O mark.
	 */
	private Player oPlayer;
	
	/**
	 * The board that the referee monitors of type Board.
	 */
	private Board board;
	
	/**
	 * Sets class board data member to be the same as the board parameter and initializes 
	 * the xPlayer and oPlayer as well as their respective opponents.
	 * @param board is the board that is used to set the board data member.
	 */
	public void setBoard(Board board)
	{
		this.board = board;
		/*
		oPlayer = new Player();
		xPlayer = new Player();
		oPlayer.setOpponent(xPlayer);
		xPlayer.setOpponent(oPlayer);*/
	}
	
	/**
	 * Sets oPlayer to specified parameter oPlayer.
	 * @param oPlayer is the Player that is going to be set to the data member oPlayer.
	 */
	public void setoPlayer(Player oPlayer)
	{
		this.oPlayer = oPlayer;
	}
	
	/**
	 * Sets xPlayer to specified parameter xPlayer.
	 * @param xPlayer is the Player that is going to be set to the data member xPlayer.
	 */
	public void setxPlayer(Player xPlayer)
	{
		this.xPlayer = xPlayer;
	}
	
	/**
	 * Runs the game by first initializing the board and then loops the plays for each player.
	 */
	public void runTheGame() 
	{
		board.display();
		while(true)
		{
			xPlayer.play();
			oPlayer.play();
		}
	}
	
}

