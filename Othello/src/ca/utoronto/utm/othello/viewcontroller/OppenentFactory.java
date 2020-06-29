package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;

import ca.utoronto.utm.othello.model.Player;
import ca.utoronto.utm.othello.model.PlayerAlpha;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import ca.utoronto.utm.othello.model.PlayerHuman;
import ca.utoronto.utm.othello.model.PlayerRandom;

/**
 * Create different opponents depends on controller.
 * @author Xuwen Cai, LinFeng Zhou, Yang Liu, jiahe Xue
 *
 */
public class OppenentFactory {
	
	/**
	 * @param product
	 * @param othello Othello
	 * @param c       first player or second player
	 * @return the opponent for the user. It is whether greedy or random or human or
	 *         alpha (the improved Strategy)
	 */
	public static Player createPlayer(String product, Othello othello, char c) {
		switch (product) {
		case "Greedy":
			return new PlayerGreedy(othello, c);
		case "Random":
			return new PlayerRandom(othello, c);
		case "Human":
			return new PlayerHuman(othello, c);
		case "Alpha":
			return new PlayerAlpha(othello, c);
		}
		return null;
	}

}
