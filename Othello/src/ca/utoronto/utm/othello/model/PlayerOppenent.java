package ca.utoronto.utm.othello.model;

/**
 * @author xuwencai
 * The PlayerOppenent class which used Strategy design pattern.
 */

/**
 * @author xuwencai
 *
 */
public class PlayerOppenent {
	public Player oppenent_strategy;

	/**
	 * set which strategy oppenent takes
	 * 
	 * @param oppenent_strategy
	 */
	public PlayerOppenent(Player oppenent_strategy) {

		this.oppenent_strategy = oppenent_strategy;
	}

	/**
	 * set which strategy it takes for user's oppenent.
	 * 
	 * @param oppenent
	 */
	public void setOpponent(Player oppenent) {
		this.oppenent_strategy = oppenent;
	}

	/**
	 * @return opponent's move in othello game
	 */
	public Move getMove() {
		return this.oppenent_strategy.getMove();
	}

	/**
	 * @return oppenent's token.
	 */
	public char getToken() {
		return this.oppenent_strategy.getPlayer();
	}
}
