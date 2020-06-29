package ca.utoronto.utm.othello.viewcontroller;

import java.util.ArrayList;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.Player;
import ca.utoronto.utm.othello.model.PlayerAlpha;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import ca.utoronto.utm.othello.model.PlayerRandom;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

/**
 * Controller used for menu bar
 * @author Xuwen Cai, LinFeng Zhou, Yang Liu, jiahe Xue
 *
 */
public class MenuController implements EventHandler<ActionEvent> {
	private Othello othello;
	public Move hint_move;
	public boolean restart;
	private Player hint_player;

	public MenuController(Othello othello) {
		this.othello = othello;
		this.restart = false;
	}

	/**
	 * Handle the user's event when they click the menu.
	 */
	public void handle(ActionEvent event) {

		MenuItem item = (MenuItem) event.getSource();
		if (item.getText() == "Restart Game") {
			this.restart = true;
			this.othello.restart_game();
			this.othello.moves = new ArrayList<Move>();
			this.hint_move = null;
		} else {
			if (item.getText() == "Greedy Hint") {
				hint_player = new PlayerGreedy(othello, this.othello.getWhosTurn());
			} else if (item.getText() == "Random Hint") {
				hint_player = new PlayerRandom(othello, this.othello.getWhosTurn());
			} else if (item.getText() == "Alpha Hint") {
				hint_player = new PlayerAlpha(othello, this.othello.getWhosTurn());
			}
			this.hint_move = hint_player.getMove();
			this.othello.notifyObservers();
		}
	}
}
