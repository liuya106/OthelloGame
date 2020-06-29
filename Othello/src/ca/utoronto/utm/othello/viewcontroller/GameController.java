
package ca.utoronto.utm.othello.viewcontroller;

import java.util.ArrayList;

import ca.utoronto.utm.othello.model.Move;

import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerHuman;
import ca.utoronto.utm.othello.model.PlayerOppenent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
/**
 * 
 * @author Xuwen Cai, LinFeng Zhou, Yang Liu, jiahe Xue
 *
 */
public class GameController implements EventHandler<ActionEvent> {
	public Othello othello;
	public PlayerOppenent opponent = null;
	public ArrayList<Move> moves;

	public GameController(Othello othello) {
		this.othello = othello;
		this.moves = new ArrayList<Move>();
	}

	/**
	 * Handle the user's event when they click the chessboard.
	 */
	public void handle(ActionEvent event) {

		Integer rowIndex = GridPane.getRowIndex((Button) event.getSource());
		Integer colIndex = GridPane.getColumnIndex((Button) event.getSource());
		Move move = new Move(rowIndex, colIndex);
		if ((this.opponent.oppenent_strategy instanceof PlayerHuman)) {
			this.othello.move(move.getRow(), move.getCol());
		} else {
			this.othello.move(move.getRow(), move.getCol());
			this.oppenent_move();
		}
		this.available_move();

	}

	/**
	 * Change the opponent to Human or Greedy or Alpha when User clicks the
	 * choicebox.
	 * 
	 * @param s
	 */
	protected void change_oppenent(String s) {
		if (othello.getWhosTurn() == 'O') {
			this.opponent.setOpponent(OppenentFactory.createPlayer(s, othello, othello.getWhosTurn()));
		} else {
			this.opponent.setOpponent(
					OppenentFactory.createPlayer(s, othello, OthelloBoard.otherPlayer(othello.getWhosTurn())));
		}
	}

	/**
	 * make player's opponent move if it is allowed.
	 */
	protected void oppenent_move() {
		if (othello.getWhosTurn() == this.opponent.getToken()) {
			this.othello.move(opponent.getMove().getRow(), opponent.getMove().getCol());
		}
	}

	/**
	 * Add the players's available move into an arraylist.
	 */
	protected void available_move() {
		this.moves.clear();
		for (int row = 0; row < Othello.DIMENSION; row++) {
			for (int col = 0; col < Othello.DIMENSION; col++) {
				Othello copy = othello.copy();
				if (copy.move(row, col)) {
					this.moves.add(new Move(row, col));
				}
			}
		}
	}

}
