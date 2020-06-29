package ca.utoronto.utm.othello.viewcontroller;

import java.util.ArrayList;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This is a controller for undo a move.
 * 
 * @author Linfeng Zhou, Yang Liu, Xuwen Cai, Jiahe Xue
 *
 */
class UndoController implements EventHandler<ActionEvent> {
	protected Othello o;

	public UndoController(Othello o) {
		this.o = o;
	}

	/**
	 * Handle the user's event when they click the regret in menu.
	 */
	@Override
	public void handle(ActionEvent event) {
		if (!(o.moves.size() == 0)) {
			o.moves.remove(o.moves.size() - 1);
			o.restart_game();
			ArrayList<Move> temp = o.moves;
			o.moves = new ArrayList<Move>();
			for (Move m : temp) {
				o.move(m.getRow(), m.getCol());
			}
		}
	}
}
